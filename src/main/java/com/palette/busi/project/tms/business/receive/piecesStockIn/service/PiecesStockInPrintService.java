package com.palette.busi.project.tms.business.receive.piecesStockIn.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface PiecesStockInPrintService {

	public XSSFWorkbook createPiecesStorageLabel(String servletRealPath, TmPieces tmPieces, ServiceOptParamLinkerVo paramLinkerVo) throws Exception;
}
