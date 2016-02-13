package com.palette.busi.project.tms.business.receive.csmStockIn.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
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
import com.palette.busi.project.tms.business.receive.csmStockIn.controller.CsmStockInController;
import com.palette.busi.project.tms.business.receive.csmStockIn.dto.CsmStockInReqDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.service.CsmStockInService;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockImportVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockInCsmUpdateVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockInPiecesUpdateVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmConsignmentCurrentDao;
import com.palette.busi.project.tms.core.dao.TmConsignmentDao;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmConsignment;
import com.palette.busi.project.tms.core.entity.TmConsignmentCurrent;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
@Transactional
public class CsmStockInServiceImpl extends BaseServiceImpl implements CsmStockInService {

	@Autowired
	private TmConsignmentDao tmConsignmentDao;
	@Autowired
	private TmConsignmentCurrentDao tmConsignmentCurrentDao;
	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public void formatCsmStockInUpdateVo(CsmStockInReqDto reqDto) {
		
		if(reqDto.getActualWeight() != null) {
			reqDto.setActualWeight(reqDto.getActualWeight().setScale(2, BigDecimal.ROUND_UP));
		}
		
		if(reqDto.getVolumeWeight() != null) {
			reqDto.setVolumeWeight(reqDto.getVolumeWeight().setScale(2, BigDecimal.ROUND_UP));
			reqDto.setLength(reqDto.getLength().setScale(2, BigDecimal.ROUND_UP));
			reqDto.setWidth(reqDto.getWidth().setScale(2, BigDecimal.ROUND_UP));
			reqDto.setHeight(reqDto.getHeight().setScale(2, BigDecimal.ROUND_UP));
		}
		
		reqDto.setReferenceNo(StringUtils.toUpperAndTrim(reqDto.getReferenceNo()));
	}
	
	@Override
	public TmConsignment insertOrUpdateCsmInfo(CsmStockInCsmUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo) {
		
		// Insert or update csm
		TmConsignment updateCsm = null;
		if(updateVo.getTmConsignmentId() == null) {
			updateCsm = new TmConsignment();
			updateCsm.setConsignmentNo(servicePvd.commonSeqNumberService.generateCsmNo());
		}
		if(updateVo.getTmConsignmentId() != null) {
			updateCsm = querier.selectTmConsignmentById(updateVo.getTmConsignmentId());
		}
		
		updateCsm.setShipperName(updateVo.getShipperName());
		updateCsm.setShipperMobileNo(updateVo.getShipperMobileNo());
		updateCsm.setShipperEnglishFullAddress(updateVo.getShipperEnglishFullAddress());
		updateCsm.setShipperCompanyName(updateVo.getShipperCompanyName());
		
		updateCsm.setConsigneeStateName(updateVo.getConsigneeStateName());
		updateCsm.setConsigneeCityName(updateVo.getConsigneeCityName());
		updateCsm.setConsigneeStreet(updateVo.getConsigneeStreet());
		updateCsm.setConsigneeChineseFullAddress(updateVo.getConsigneeChineseFullAddress());
		updateCsm.setConsigneePostCode(updateVo.getConsigneePostCode());
		updateCsm.setConsigneeMobileNo(updateVo.getConsigneeMobileNo());
		updateCsm.setConsigneeName(updateVo.getConsigneeName());
		
		updateCsm.setTotalGoodsDescription(updateVo.getTotalGoodsDescription());
		updateCsm.setTotalGoodsValue(updateVo.getTotalGoodsValue());
		updateCsm.setTotalGoodsValueCurrency(updateVo.getTotalGoodsValueCurrency());
		updateCsm.setTotalGoodsBrand(updateVo.getTotalGoodsBrand());
		updateCsm.setTotalQty(updateVo.getTotalQty());
		updateCsm.setTotalGoodsBrand(updateVo.getTotalGoodsBrand());
		updateCsm.setTotalGoodsSpec(updateVo.getTotalGoodsSpec());
		updateCsm.setTotalGoodsUnit(updateVo.getTotalGoodsUnit());
		
		updateCsm.setLogisticsNo(updateVo.getReferenceNo());
		
		tmConsignmentDao.saveTmConsignment(updateCsm, updateVo.getUserName(), updateVo.getControllerId());
		
		// Insert csm current
		if(updateVo.getTmConsignmentId() == null) {
			TmConsignmentCurrent tmConsignmentCurrent = new TmConsignmentCurrent();
			
			tmConsignmentCurrent.setTmConsignmentId(updateCsm.getTmConsignmentId());
			tmConsignmentCurrent.setConsignmentNo(updateCsm.getConsignmentNo());
			tmConsignmentCurrent.setAuditStatus(CodeConstants.CONSIGNMENT_AUDIT_STATUS.WAIT_AUDIT);
			
			tmConsignmentCurrentDao.insertTmConsignmentCurrent(tmConsignmentCurrent, updateVo.getUserName(), updateVo.getControllerId());
		}
		
		return updateCsm;
	}
	
	@Override
	public TmPieces updatePiecesInfoForStockIn(CsmStockInPiecesUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo) {
		
		TmPieces updatePieces = null;
		if(updateVo.getTmPiecesId() == null) {
			updatePieces = new TmPieces();
			updatePieces.setPiecesNo(servicePvd.commonSeqNumberService.generatePiecesNo());
		}
		if(updateVo.getTmPiecesId() != null) {
			updatePieces = querier.selectTmPiecesById(updateVo.getTmPiecesId());
		}

		// Inser or Update pieces
		updatePieces.setActualWeight(updateVo.getActualWeight());
		updatePieces.setLength(updateVo.getLength());
		updatePieces.setWidth(updateVo.getWidth());
		updatePieces.setHeight(updateVo.getHeight());
		updatePieces.setVolumeWeight(updateVo.getVolumeWeight());
		updatePieces.setMemberCode(updateVo.getMemberCode());
		updatePieces.setLogisticsNo(StringUtils.toUpperAndTrim(updateVo.getReferenceNo()));
		updatePieces.setWarehouseCode(linkerVo.getWarehouseCode());
		updatePieces.setMemo(updateVo.getMemo());
		if(updatePieces.getCheckDate() == null) updatePieces.setCheckDate(DateUtils.getCurrentGMTDate());
		updatePieces.setTmConsignmentId(updateVo.getTmConsignment().getTmConsignmentId());
		updatePieces.setConsignmentNo(updateVo.getTmConsignment().getConsignmentNo());
		updatePieces.setCompanyCode(linkerVo.getCompanyCode());
		
		updatePieces = tmPiecesDao.saveTmPieces(updatePieces, updateVo.getUserName(), updateVo.getControllerId());
		
		// Insert or Update pieces current and history
		String memo = StringUtils.concat(linkerVo.getWarehouseDesc(), " 入库");;
		if(updatePieces.getActualWeight() != null) {
			memo = StringUtils.concat(memo, " 实重 ", updatePieces.getActualWeight().toString(), linkerVo.getWeightUnit());
		}
		
		ComPiecesStatusUpdateVo updatePiecesStatusVo = servicePvd.commonPiecesService.createPiecesStatusUpdateVo(updatePieces.getTmPiecesId()
																											    ,updatePieces.getPiecesNo()
																											    ,CodeConstants.PIECES_ACTION.CI
																											    ,memo
																											    ,updateVo.getControllerId()
																											    ,linkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(updatePiecesStatusVo);
		
		return updatePieces;
	}
	
	@Override
	public List<CsmStockImportVo> importStockCsmExcel(MultipartFile file) throws Exception {
		
		List<CsmStockImportVo> importVoList = new ArrayList<CsmStockImportVo>();
		
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
        		
        		CsmStockImportVo importVo = new CsmStockImportVo();

        		Integer rowIndex = i + 1;
        		Row row = sheet.getRow(i);
        		ThrowExp.isNull(row, "操作失败。第" + rowIndex + "行信息异常");
            	
        		// Reference no
            	Cell referenceNoCell = row.getCell(0);
            	String piecesNo = ExcelUtils.getCellStrValue(workBook, referenceNoCell, rowIndex, 1);
            	ThrowExp.isNull(piecesNo, "操作失败。第" + rowIndex + "行关联号信息异常");
            	importVo.setReferenceNo(piecesNo);
            	// Actual weight
            	Cell actualWeightCell = row.getCell(1);
            	if(ExcelUtils.isFullCell(evaluator, actualWeightCell)) {
            		BigDecimal actualWeight = ExcelUtils.getCellBigDecimalValue(workBook, actualWeightCell, rowIndex, 2);
            		importVo.setActualWeight(actualWeight);
            	}
            	// Shipper name
            	Cell shipperNameCell = row.getCell(2);
            	if(ExcelUtils.isFullCell(evaluator, shipperNameCell)) {
            		String shipperName = ExcelUtils.getCellStrValue(workBook, shipperNameCell, rowIndex, 3);
            		importVo.setShipperName(shipperName);
            	}
            	// Shipper mobile no
            	Cell shipperMobileCell = row.getCell(3);
            	if(ExcelUtils.isFullCell(evaluator, shipperMobileCell)) {
            		String shipperMobile = ExcelUtils.getCellStrValue(workBook, shipperMobileCell, rowIndex, 4);
            		importVo.setShipperMobileNo(shipperMobile);
            	}
            	// Shipper company
            	Cell shipperCompanyCell = row.getCell(4);
            	if(ExcelUtils.isFullCell(evaluator, shipperCompanyCell)) {
            		String shipperCompany = ExcelUtils.getCellStrValue(workBook, shipperCompanyCell, rowIndex, 5);
            		importVo.setShipperCompanyName(shipperCompany);
            	}
            	
            	// Consignee name
            	Cell consigneeNameCell = row.getCell(5);
            	String consigneeName = ExcelUtils.getCellStrValue(workBook, consigneeNameCell, rowIndex, 6);
            	ThrowExp.isNull(consigneeName, "操作失败。第" + rowIndex + "行收货人信息异常");
            	importVo.setConsigneeName(consigneeName);
            	// Consignee mobile no
            	Cell consigneeMobileNoCell = row.getCell(6);
            	String consigneeMobile = ExcelUtils.getCellStrValue(workBook, consigneeMobileNoCell, rowIndex, 7);
            	ThrowExp.isNull(consigneeMobile, "操作失败。第" + rowIndex + "行收货人电话异常");
            	importVo.setConsigneeMobileNo(consigneeMobile);
            	// Consignee state
            	Cell consigneeStateCell = row.getCell(7);
            	if(ExcelUtils.isFullCell(evaluator, consigneeStateCell)) {
            		String consigneeState = ExcelUtils.getCellStrValue(workBook, consigneeStateCell, rowIndex, 8);
            		importVo.setConsigneeStateName(consigneeState);
            	}
            	// Consignee address
            	Cell consigneeAddressCell = row.getCell(8);
            	String consigneeAddress = ExcelUtils.getCellStrValue(workBook, consigneeAddressCell, rowIndex, 9);
            	ThrowExp.isNull(consigneeAddress, "操作失败。第" + rowIndex + "行收货人地址异常");
            	importVo.setConsigneeChineseFullAddress(consigneeAddress);
            	
            	// Goods desc
            	Cell goodsDescCell = row.getCell(9);
            	String goodsDesc = ExcelUtils.getCellStrValue(workBook, goodsDescCell, rowIndex, 10);
            	ThrowExp.isNull(goodsDesc, "操作失败。第" + rowIndex + "行商品名称异常");
            	importVo.setTotalGoodsDescription(goodsDesc);
            	// Goods brand
            	Cell goodsBrandCell = row.getCell(10);
            	if(ExcelUtils.isFullCell(evaluator, goodsBrandCell)) {
            		String goodsBrand = ExcelUtils.getCellStrValue(workBook, goodsBrandCell, rowIndex, 11);
            		importVo.setTotalGoodsBrand(goodsBrand);
            	}
            	// Goods unit
            	Cell goodsUnitCell = row.getCell(11);
            	if(ExcelUtils.isFullCell(evaluator, goodsUnitCell)) {
            		String goodsUnit = ExcelUtils.getCellStrValue(workBook, goodsUnitCell, rowIndex, 12);
            		importVo.setTotalGoodsUnit(goodsUnit);
            	}
            	// Goods qty
            	Cell goodsQtyCell = row.getCell(12);
            	if(ExcelUtils.isFullCell(evaluator, goodsQtyCell)) {
            		BigDecimal goodsQty = ExcelUtils.getCellBigDecimalValue(workBook, goodsQtyCell, rowIndex, 13);
            		importVo.setTotalQty(goodsQty);
            	}
            	// Goods value
            	Cell goodsValueCell = row.getCell(13);
            	if(ExcelUtils.isFullCell(evaluator, goodsValueCell)) {
            		BigDecimal goodsValue = ExcelUtils.getCellBigDecimalValue(workBook, goodsValueCell, rowIndex, 14);
            		importVo.setTotalGoodsValue(goodsValue);
            	}
            	// Goods value currency
            	Cell goodsValueCurrencyCell = row.getCell(14);
            	if(ExcelUtils.isFullCell(evaluator, goodsValueCurrencyCell)) {
            		String goodsValueCurrency = ExcelUtils.getCellStrValue(workBook, goodsValueCurrencyCell, rowIndex, 15);
            		importVo.setTotalGoodsValueCurrency(goodsValueCurrency);
            	}
            	// Goods spec
            	Cell goodsSpecCell = row.getCell(15);
            	if(ExcelUtils.isFullCell(evaluator, goodsSpecCell)) {
            		String goodsSpec = ExcelUtils.getCellStrValue(workBook, goodsSpecCell, rowIndex, 16);
            		importVo.setTotalGoodsSpec(goodsSpec);
            	}
        		
        		importVoList.add(importVo);
        	}
    	}
        
        return importVoList;
	}
	
	@Override
	public void concurrencyCsmStockIn(final List<CsmStockImportVo> importVoList, final ServiceOptParamLinkerVo linkerVo) {
		
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable call = new Callable() {
            public String call() throws Exception {
            	
            	for(CsmStockImportVo importVo : importVoList) {
            		
            		ComUsablePiecesQueryVo usablePiecesQueryVo = new ComUsablePiecesQueryVo();
            		usablePiecesQueryVo.setLogisticsNo(importVo.getReferenceNo());
            		ComUsablePiecesResultVo usablePieces = servicePvd.commonPiecesService.queryUsablePieces(usablePiecesQueryVo, linkerVo);
            		
            		// Update csm
            		CsmStockInCsmUpdateVo csmUpdateVo = new CsmStockInCsmUpdateVo(linkerVo.getUserName(), CsmStockInController.CONTROLLER_ID);
            		BeanUtilsExt.copyProperties(importVo, csmUpdateVo);
            		if(usablePieces != null && usablePieces.getTmConsignmentId() != null)
            			csmUpdateVo.setTmConsignmentId(usablePieces.getTmConsignmentId());
            		TmConsignment tmCsm = insertOrUpdateCsmInfo(csmUpdateVo, linkerVo);
            		
            		// Update pieces
            		CsmStockInPiecesUpdateVo piecesUpdateVo = new CsmStockInPiecesUpdateVo(linkerVo.getUserName(), CsmStockInController.CONTROLLER_ID);
            		BeanUtilsExt.copyProperties(importVo, piecesUpdateVo);
            		piecesUpdateVo.setTmConsignment(tmCsm);
            		if(usablePieces != null && usablePieces.getTmPiecesId() != null)
            			piecesUpdateVo.setTmPiecesId(usablePieces.getTmPiecesId());
            		updatePiecesInfoForStockIn(piecesUpdateVo, linkerVo);
            	}
            	
				return "true";
            }
		};
		
		exec.submit(call);  
        exec.shutdown();
	}
}
