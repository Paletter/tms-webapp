package com.palette.busi.project.tms.business.common.print.impl;

import java.io.FileInputStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.palette.busi.project.tms.common.util.BarCodeUtils;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public abstract class FatherLabelExcelCreatorImpl {

	public XSSFWorkbook createPiecesStorageLabelWorkBook(String templatePath, TmPieces pieces, ServiceOptParamLinkerVo paramLinkerVo) throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(templatePath));
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		// Member code
		XSSFCell memberCodeCell = sheet.getRow(0).getCell(0);
		ExcelUtils.setCellStrValue(memberCodeCell, pieces.getMemberCode());
		// Stock date
		XSSFCell stockDateCell = sheet.getRow(0).getCell(3);
		ExcelUtils.setCellStrValue(stockDateCell, DateUtils.dateTimeFormat.format(new Date()));
		// Actural Weight
		XSSFCell weightCell = sheet.getRow(1).getCell(2);
		ExcelUtils.setCellStrValue(weightCell, pieces.getActualWeight());
		// Volume weight
		XSSFCell volumeCell = sheet.getRow(2).getCell(2);
		String volumeStr = pieces.getLength() == null || pieces.getWidth() == null || pieces.getHeight() == null ? 
				           "" : pieces.getLength() + "X" + pieces.getWidth() + "X" + pieces.getHeight();
		ExcelUtils.setCellStrValue(volumeCell, volumeStr);
		// Weight unit
		XSSFCell acturalWeightUnitCell = sheet.getRow(1).getCell(4);
		ExcelUtils.setCellStrValue(acturalWeightUnitCell, paramLinkerVo.getWeightUnit());
		// Volume unit
		XSSFCell volumeWeightUnitCell = sheet.getRow(2).getCell(6);
		ExcelUtils.setCellStrValue(volumeWeightUnitCell, paramLinkerVo.getVolumnUnit());
		// Pieces no code
		String tmpCodeImgPath = this.getClass().getClassLoader().getResource("").getPath() + "/tmpCodeImg.jpg";
		BarCodeUtils.insertStockInLabelPiecesNoCode128Img(pieces.getPiecesNo(), 4, 1, 0, 13, workbook, tmpCodeImgPath);
		// Logistic no
		XSSFCell logisticNoCodeCell = sheet.getRow(6).getCell(0);
		ExcelUtils.setCellStrValue(logisticNoCodeCell, pieces.getLogisticsNo());
		// Pieces no
		String piecesNo = pieces.getPiecesNo();
		Pattern p = Pattern.compile("[1-9]");
		Matcher m = p.matcher(piecesNo);
		if(m.find()) {
			String firstNo = piecesNo.substring(0, m.end() - 1);
			String lastNo = piecesNo.substring(m.end() - 1);
			XSSFCell firstPiecesNoCell = sheet.getRow(7).getCell(0);
			ExcelUtils.setCellStrValue(firstPiecesNoCell, firstNo);
			XSSFCell lastPiecesNoCell = sheet.getRow(7).getCell(6);
			ExcelUtils.setCellStrValue(lastPiecesNoCell, lastNo);
		} else {
			XSSFCell piecesNoCell = sheet.getRow(7).getCell(0);
			ExcelUtils.setCellStrValue(piecesNoCell, piecesNo);
		}
		
		return workbook;
	}
}
