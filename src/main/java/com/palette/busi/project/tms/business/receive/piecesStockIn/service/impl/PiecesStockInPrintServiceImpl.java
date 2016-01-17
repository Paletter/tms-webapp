package com.palette.busi.project.tms.business.receive.piecesStockIn.service.impl;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInPrintService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.PrintTemplateConstants;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
public class PiecesStockInPrintServiceImpl extends BaseServiceImpl implements PiecesStockInPrintService {

	@Override
	public XSSFWorkbook createPiecesStorageLabel(String servletRealPath, TmPieces tmPieces, ServiceOptParamLinkerVo paramLinkerVo) throws Exception {
		
		String templatePath = servletRealPath + PrintTemplateConstants.COM_PIECES_STORAGE_LABLE;
		XSSFWorkbook workbook = servicePvd.usLabelExcelCreator.createPiecesStorageLabelWorkBook(templatePath, tmPieces, paramLinkerVo);
		
		return workbook;
	}
	
}
