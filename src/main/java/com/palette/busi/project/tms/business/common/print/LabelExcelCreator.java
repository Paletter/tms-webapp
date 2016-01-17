package com.palette.busi.project.tms.business.common.print;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface LabelExcelCreator {

	public XSSFWorkbook createPiecesStorageLabelWorkBook(String templatePath, TmPieces pieces, ServiceOptParamLinkerVo paramLinkerVo) throws Exception;
}
