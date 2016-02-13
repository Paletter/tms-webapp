package com.palette.busi.project.tms.business.delivery.outTemplate.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesQueryVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.delivery.outTemplate.controller.OutTemplateController;
import com.palette.busi.project.tms.business.delivery.outTemplate.service.OutTemplateService;
import com.palette.busi.project.tms.business.delivery.outTemplate.vo.DeliverPiecesImportVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
@Transactional
public class OutTemplateServiceImpl extends BaseServiceImpl implements OutTemplateService {

	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public List<DeliverPiecesImportVo> importDeliverPiecesExcel(MultipartFile file) throws IOException {

		List<DeliverPiecesImportVo> importVoList = new ArrayList<DeliverPiecesImportVo>();
		
		byte[] byt = file.getBytes();
		InputStream inputStream = new ByteArrayInputStream(byt);
		
		String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		Workbook workBook = null;
        if(fileType.equals("xls")) {
    		workBook = new HSSFWorkbook(inputStream);
    	} else if(fileType.equals("xlsx")) {
    		workBook = new XSSFWorkbook(inputStream);
    	}
        
        FormulaEvaluator evaluator = workBook.getCreationHelper().createFormulaEvaluator();
        
        Sheet sheet = workBook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        
        if (rows > 0) {
        	for (int i = 1; i <= rows; i++) {
        		
        		DeliverPiecesImportVo importVo = new DeliverPiecesImportVo();

        		Integer rowIndex = i + 1;
        		Row row = sheet.getRow(i);
        		ThrowExp.isNull(row, "操作失败。第" + rowIndex + "行信息异常");
        		
        		// Reference no
            	Cell referenceNoCell = row.getCell(0);
            	if(ExcelUtils.isFullCell(evaluator, referenceNoCell)) {
            		String referenceNo = ExcelUtils.getCellStrValue(workBook, referenceNoCell);
            		importVo.setReferenceNo(referenceNo);
            	}
            	// Pieces no
            	Cell piecesNoCell = row.getCell(1);
            	if(ExcelUtils.isFullCell(evaluator, piecesNoCell)) {
	            	String piecesNo = ExcelUtils.getCellStrValue(workBook, piecesNoCell);
	            	importVo.setPiecesNo(piecesNo);
            	}
            	
            	ThrowExp.isTrue(StringUtils.isNullOrEmpty(importVo.getPiecesNo()) && StringUtils.isNullOrEmpty(importVo.getReferenceNo())
            				   ,"操作失败。第" + rowIndex + "行，关联号和包裹号至少填写一个");
            	
            	importVoList.add(importVo);
        	}
        }
        
        return importVoList;
	}

	@Override
	public void concurrencyDeliverPieces(final List<DeliverPiecesImportVo> importVoList, final ServiceOptParamLinkerVo linkerVo) {
		
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable call = new Callable() {
            public String call() throws Exception {
            	
            	for(DeliverPiecesImportVo importVo : importVoList) {
            		
            		ComUsablePiecesQueryVo usablePiecesQueryVo = new ComUsablePiecesQueryVo();
            		if(StringUtils.isNotNullOrEmpty(importVo.getReferenceNo()))
            			usablePiecesQueryVo.setLogisticsNo(importVo.getReferenceNo());
            		else if(StringUtils.isNotNullOrEmpty(importVo.getPiecesNo())) 
            			usablePiecesQueryVo.setPiecesNo(importVo.getPiecesNo());
            		ComUsablePiecesResultVo usablePieces = servicePvd.commonPiecesService.queryUsablePieces(usablePiecesQueryVo, linkerVo);
            		
            		if(usablePieces != null) {
            			
	            		// Update pieces
            			TmPieces updatePieces = new TmPieces();
            			updatePieces.setTmPiecesId(usablePieces.getTmPiecesId());
            			updatePieces.setDeliveryDate(DateUtils.getCurrentGMTDate());
            			tmPiecesDao.updateTmPieces(updatePieces, linkerVo.getUserName(), OutTemplateController.CONTROLLER_ID);
            			
	        			ComPiecesStatusUpdateVo updateVo = servicePvd.commonPiecesService.createPiecesStatusUpdateVo(usablePieces.getTmPiecesId()
	        					 																					,usablePieces.getPiecesNo()
	        					 																					,CodeConstants.PIECES_ACTION.CO
	        					 																					,"包裹出仓"
	        					 																					,OutTemplateController.CONTROLLER_ID
	        					 																					,linkerVo);
	        			
	        			servicePvd.commonPiecesService.updatePiecesStatus(updateVo);
            		}
            	}
            	
				return "true";
            }
		};
		
		exec.submit(call);  
        exec.shutdown();
	}
}
