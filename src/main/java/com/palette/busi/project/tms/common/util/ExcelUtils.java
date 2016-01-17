package com.palette.busi.project.tms.common.util;

import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

	public static void setCellStrValue(Cell cell, String str) {
		cell.setCellValue(str == null ? "" : str);
	}
	
	public static void setCellStrValue(Cell cell, BigDecimal b) {
		cell.setCellValue(b == null ? "" : b.toString());
	}
	
	public static void setCellStrValue(Cell cell, Integer i) {
		cell.setCellValue(i == null ? "" : i.toString());
	}
	
	public static void setCellIntValue(Cell cell, Integer i) {
		if(i != null) cell.setCellValue(i);
	}
	
	public static void setCellIntValue(Cell cell, BigDecimal b) {
		if(b != null) cell.setCellValue(b.intValue());
	}
	
	public static void setCellDoubleValue(Cell cell, BigDecimal b) {
		if(b != null) cell.setCellValue(b.doubleValue());
	}
	
	public static CellStyle createBlackAllBorderCellStyle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		return style;
	}
	
	public static CellStyle createBackgroundCellStyle(Workbook wb, short color) {
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(color);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		return style;
	}
	
	public static HSSFCellStyle createBackgroundCellStyle(HSSFWorkbook wb, short color) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(color);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		return style;
	}
	
	public static CellStyle createFontColorCellStyle(Workbook wb, short color) {
		Font font = wb.createFont();
		font.setColor(color);
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		return style;
	}
	
	public static CellStyle createWrapCellStyle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setWrapText(true);
		return style;
	}

	public static CellStyle setCellStyleFontColor(Workbook wb, CellStyle style, short color) {
		Font font = wb.createFont();
		font.setColor(color);
		style.setFont(font);
		return style;
	}
	
	public static CellStyle setCellStyleBackground(Workbook wb, CellStyle style, short color) {
		style.setFillForegroundColor(color);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		return style;
	}
	
	public static CellStyle setCellStyleBlackAllBorder(Workbook wb, CellStyle style, short color) {
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		return style;
	}
	
	public static HSSFComment createCellCommoent(HSSFSheet sheet, HSSFClientAnchor anchor, String text) {
		HSSFPatriarch patr = sheet.createDrawingPatriarch();
		HSSFComment comment = patr.createComment(anchor);
		comment.setString(new HSSFRichTextString(text));
		return comment;
	}
}
