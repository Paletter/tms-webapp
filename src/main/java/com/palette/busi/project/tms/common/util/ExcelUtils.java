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
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.web.exception.BusinessException;

public class ExcelUtils {

	public static void validateImportExcel(MultipartFile file) {
		ThrowExp.isTrue(file.isEmpty(), "操作失败。上传文件不存在");
		
		String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		ThrowExp.isTrue(!fileType.equals("xls") && !fileType.equals("xlsx"), "操作失败。上传文件类型错误，只可上传xls和xlsx结尾的excel文件");
	}
	
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
	
	public static String getCellStrValue(Workbook wb, Cell cell) {
		try {
			
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			if(cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				Double value = cellValue.getNumberValue();
				return String.valueOf(value);
			} else if(cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
				return cellValue.getStringValue();
			} else {
				throw new BusinessException("操作失败。第" + (cell.getRowIndex() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列，数据解析错误");
			}
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。数据解析错误");
		}
	}
	
	public static Integer getCellIntValue(Workbook wb, Cell cell) {
		try {
			
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			if(cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				Double value = cellValue.getNumberValue();
				return value.intValue();
			} else if(cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
				return Integer.valueOf(cellValue.getStringValue());
			} else {
				throw new BusinessException("操作失败。第" + (cell.getRowIndex() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列，数据解析错误");
			}

		} catch (Exception e) {
			throw new BusinessException("操作失败。数据解析错误");
		}
	}
	
	public static BigDecimal getCellBigDecimalValue(Workbook wb, Cell cell) {
		try {
			
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			if(cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				Double value = cellValue.getNumberValue();
				return BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else if(cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
				return BigDecimal.valueOf(Double.valueOf(cellValue.getStringValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else {
				throw new BusinessException("操作失败。第" + (cell.getRowIndex() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列，数据解析错误");
			}
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。数据解析错误");
		}
	}
	
	public static String getCellStrValue(Workbook wb, Cell cell, Integer rowIndex, Integer cellIndex) {
		try {
			
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			if(cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				Double value = cellValue.getNumberValue();
				return String.valueOf(value);
			} else if(cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
				return cellValue.getStringValue();
			} else {
				throw new BusinessException("操作失败。第" + rowIndex + "行，第" + cellIndex + "列，数据解析错误");
			}
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。第" + rowIndex + "行，第" + cellIndex + "列，数据解析错误");
		}
	}
	
	public static Integer getCellIntValue(Workbook wb, Cell cell, Integer rowIndex, Integer cellIndex) {
		try {
			
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			if(cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				Double value = cellValue.getNumberValue();
				return value.intValue();
			} else if(cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
				return Integer.valueOf(cellValue.getStringValue());
			} else {
				throw new BusinessException("操作失败。第" + (cell.getRowIndex() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列，数据解析错误");
			}
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。第" + rowIndex + "行，第" + cellIndex + "列，数据解析错误");
		}
	}
	
	public static BigDecimal getCellBigDecimalValue(Workbook wb, Cell cell, Integer rowIndex, Integer cellIndex) {
		try {
			
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			if(cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				Double value = cellValue.getNumberValue();
				return BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else if(cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
				return BigDecimal.valueOf(Double.valueOf(cellValue.getStringValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else {
				throw new BusinessException("操作失败。第" + (cell.getRowIndex() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列，数据解析错误");
			}
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。第" + rowIndex + "行，第" + cellIndex + "列，数据解析错误");
		}
	}
	
	public static Integer getCellType(Workbook wb, Cell cell) {
		try {
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			return cellValue.getCellType();
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。数据解析错误");
		}
	}
	
	public static boolean isFullCell(FormulaEvaluator evaluator, Cell cell) {
		return cell != null && evaluator.evaluate(cell) != null;
	}
}
