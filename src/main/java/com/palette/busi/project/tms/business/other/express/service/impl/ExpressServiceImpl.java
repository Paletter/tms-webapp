package com.palette.busi.project.tms.business.other.express.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.other.express.service.ExpressService;
import com.palette.busi.project.tms.business.other.express.support.PiecesDeliveryBatchUpdateParam;
import com.palette.busi.project.tms.business.other.express.vo.ExpressImportVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.CdDelivery;

@Service
@Transactional
public class ExpressServiceImpl extends BaseServiceImpl implements ExpressService {

	@Override
	public List<ExpressImportVo> importExpressExcel(MultipartFile file) throws IOException {
	
		List<ExpressImportVo> importVoList = new ArrayList<ExpressImportVo>();
		
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
        		
        		ExpressImportVo importVo = new ExpressImportVo();
        		
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
            	ThrowExp.isTrue(StringUtils.isNullOrEmpty(importVo.getReferenceNo()) && StringUtils.isNullOrEmpty(importVo.getPiecesNo())
            			       ,"操作失败。第" + rowIndex + "行，关联号和包裹号至少填写一个");
            	// Delivery name
            	Cell deliveryNameCell = row.getCell(2);
        		String deliveryName = ExcelUtils.getCellStrValue(workBook, deliveryNameCell);
        		ThrowExp.isNull(deliveryName, "操作失败。第" + rowIndex + "行快递公司信息异常");
        		importVo.setDeliveryName(deliveryName);
        		// Delivery no
        		Cell deliveryNoCell = row.getCell(3);
        		String deliveryNo = ExcelUtils.getCellStrValue(workBook, deliveryNoCell);
        		ThrowExp.isNull(deliveryNo, "操作失败。第" + rowIndex + "行快递单号信息异常");
        		importVo.setDeliveryNo(deliveryNo);
        		
        		importVoList.add(importVo);
        	}
        }
        
        return importVoList;
	}
	
	@Override
	public void updatePiecesExpressInfo(List<ExpressImportVo> importVoList) {
		
		List<PiecesDeliveryBatchUpdateParam> updateParamList = new ArrayList<PiecesDeliveryBatchUpdateParam>();
		List<CdDelivery> cdDeliveryList = querier.selectCdDeliveryAll();
		for(ExpressImportVo importVo : importVoList) {
			
			CdDelivery cdDelivery = searchCdDeliveryByName(importVo.getDeliveryName(), cdDeliveryList);
			ThrowExp.isNull(cdDelivery, "操作失败。快递公司" + importVo.getDeliveryName() + "不存在");
			
			PiecesDeliveryBatchUpdateParam updateParam = new PiecesDeliveryBatchUpdateParam();
			updateParam.setDeliveryCode(cdDelivery.getDeliveryCode());
			updateParam.setDeliveryNo(importVo.getDeliveryNo());
			updateParam.setPiecesNo(importVo.getPiecesNo());
			updateParam.setLogisticsNo(importVo.getReferenceNo());
			updateParamList.add(updateParam);
		}
		
		if(updateParamList.size() > 0) {
			baseDao.update(SqlMapperConstants.EXPRESS_BATCH_UPDATE_PIECES_DELIVERY_INFO, updateParamList);
		}
	}
	
	private CdDelivery searchCdDeliveryByName(String deliveryName, List<CdDelivery> cdDeliveryList) {
		
		CdDelivery result = null;
		for(CdDelivery cdDelivery : cdDeliveryList) {
			if(cdDelivery.getDeliveryName().equals(deliveryName)) {
				result = cdDelivery;
			}
		}
		return result;
	}
}
