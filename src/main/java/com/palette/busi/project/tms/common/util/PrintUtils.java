package com.palette.busi.project.tms.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrintUtils {
	
	public static void excelResponseOutput(HttpServletResponse response, HSSFWorkbook workbook, String outPutFileName) {
		try{
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + outPutFileName);    
			response.setContentType("application/msexcel-print-paper;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			workbook = null;
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void excelResponseOutput(HttpServletResponse response, XSSFWorkbook workbook, String outPutFileName) {
		try{
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + outPutFileName);    
			response.setContentType("application/msexcel-print-paper;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			workbook = null;
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void labelResponseOutput(HttpServletResponse response, HSSFWorkbook workbook, String outPutFileName) {
		try{
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + outPutFileName);    
			response.setContentType("application/msexcel-print-label;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			workbook = null;
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void labelResponseOutput(HttpServletResponse response, XSSFWorkbook workbook, String outPutFileName) {
		try{
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + outPutFileName);    
			response.setContentType("application/msexcel-print-label;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			workbook = null;
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fileResponseOutput(HttpServletResponse response, File file, String outPutFileName) {
		try{
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + outPutFileName);    
			response.setContentType("application/msexcel-print-paper;charset=UTF-8");
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buff = new byte[2048];
	        while (true) {
	        	int bytesRead;
	        	if(-1 == (bytesRead = bis.read(buff, 0, buff.length))) break;
	        	bos.write(buff, 0, bytesRead);
	        }
	        	
	        bis.close();
	        bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
