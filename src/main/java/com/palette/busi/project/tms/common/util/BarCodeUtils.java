package com.palette.busi.project.tms.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class BarCodeUtils {

	private static int FONTSIZE = 10;
	private static String IMAGETYPE = "JPEG";
	
	public static void insertStockInLabelPiecesNoCode128Img(String code, int row, int rowHeight, int col, int colWidth, Workbook wb, Sheet sheet, String path) throws Exception{
		FONTSIZE = 0;
		importExcelForCode(200, 42, row, rowHeight, col, colWidth, code, wb, sheet, path);
	}
	
	public static void insertUnitLabelCode128Img(String code, int row, int rowHeight, int col, int colWidth, Workbook wb, Sheet sheet, String path) throws Exception{
		FONTSIZE = 0;
		importExcelForCode(200, 42, row, rowHeight, col, colWidth, code, wb, sheet, path);
	}

	public static Workbook importExcelForCode(int width
			                                     ,int height
			                                     ,int row
			                                     ,int rowHeight
			                                     ,int col
			                                     ,int colWidth
			                                     ,String no
			                                     ,Workbook workbook
			                                     ,Sheet sheet
			                                     ,String path) throws Exception {
		
		createCodeImg(width, height, no, path);
		
		BufferedImage image = ImageIO.read(new File(path));
		Drawing drawing = sheet.createDrawingPatriarch();
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", bao);
		ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, col, row, col + colWidth, row + rowHeight);
		anchor.setAnchorType(0);
		drawing.createPicture(anchor, workbook.addPicture(bao.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
		
		new File(path).delete();
		return workbook;
	}
	
	public static XSSFWorkbook importExcelForCodeAndFont(int width
			                                     ,int height
			                                     ,int row
			                                     ,int rowHeight
			                                     ,int col
			                                     ,int colWidth
			                                     ,String no
			                                     ,XSSFWorkbook xssfWorkbook
			                                     ,XSSFSheet sheet
			                                     ,String path) throws Exception {
		
		createCodeImg(width, height, no, path);
		createFont(width, height, no, path);
		
		BufferedImage image = ImageIO.read(new File(path));
		XSSFDrawing xssfDrawing = sheet.createDrawingPatriarch();
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", bao);
		XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, col, row, col + colWidth, row + rowHeight);
		anchor.setAnchorType(0);
		xssfDrawing.createPicture(anchor, xssfWorkbook.addPicture(bao.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
		
		new File(path).delete();
		return xssfWorkbook;
	}

	public static void createCodeImg(int width, int height, String no, String path) throws Exception {
		FileOutputStream fos = new FileOutputStream(new File(path));
		int codeheight = (int) (height - FONTSIZE * 1.5);
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix m = new MultiFormatWriter().encode(no, BarcodeFormat.CODE_128, width, codeheight, hints);
		MatrixToImageWriter.writeToStream(m, IMAGETYPE, fos);
		fos.flush();
		fos.close();
	}

	public static void createFont(int width, int height, String no, String path) throws Exception {
		BufferedImage font = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		BufferedImage code = ImageIO.read(new File(path));
		int codeHeight = code.getHeight();
		Graphics2D g = (Graphics2D) font.getGraphics();
		g.clearRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		for (int i = 0; i < no.length(); i++) {
			g.setColor(Color.black);
			Font font_ = new Font("Consolas", 0, FONTSIZE);
			g.setFont(font_);
			g.drawString(no.charAt(i) + "", (FONTSIZE * 2 + width - no.length() * FONTSIZE)
					/ 2 + (i - 1) * FONTSIZE, codeHeight + height - codeHeight);
		}
		g.drawImage(code, 0, 0, null);
		g.dispose();
		int[] rgb = new int[3];
		for (int i = 0; i < width; i++) {
			for (int j = codeHeight; j < height; j++) {
				int pixel = font.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if (rgb[0] > 125 || rgb[1] > 125 || rgb[2] > 125) {
					font.setRGB(i, j, -1);
				}
				if (rgb[0] < 100 || rgb[1] < 100 || rgb[2] < 100) {
					font.setRGB(i, j, -16777216);
				}
			}
		}

		File outputfile = new File(path);
		ImageIO.write(font, IMAGETYPE, outputfile);
	}

}
