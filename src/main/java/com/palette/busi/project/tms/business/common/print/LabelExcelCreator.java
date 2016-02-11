package com.palette.busi.project.tms.business.common.print;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmUnit;

public interface LabelExcelCreator {

	public XSSFWorkbook createPiecesStorageLabelWorkBook(String templatePath, TmPieces pieces, ServiceOptParamLinkerVo paramLinkerVo) throws Exception;
	public XSSFWorkbook createUnitLabelWorkBook(String templatePath, List<TmUnit> tmUnitList) throws Exception;
}
