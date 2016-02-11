package com.palette.busi.project.tms.business.other.express.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.other.express.service.ExpressService;
import com.palette.busi.project.tms.business.other.express.vo.ExpressImportVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.PrintTemplateConstants;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.util.PrintUtils;

@RestController
public class ExpressController extends BaseController {

	@Autowired
	private ExpressService expressService;
	
	@RequestMapping(value="/ExpressController/importExpressExcel")
	public boolean importExpressExcel(@RequestParam(value="expressFile") MultipartFile file) throws IOException {
		
		// Validate
		ExcelUtils.validateImportExcel(file);
		
		// Business
		List<ExpressImportVo> importVoList = expressService.importExpressExcel(file);
		
		if(importVoList != null && importVoList.size() > 0) {
			expressService.updatePiecesExpressInfo(importVoList);
		}
		
		return true;
	}
	
	@RequestMapping(value="/ExpressController/printExpressImportTemplate")
	public void printExpressImportTemplate(HttpServletResponse response) throws FileNotFoundException, IOException {
			
		String templatePath = getServletRealPath() + PrintTemplateConstants.EP_EXPRESS_IMPORT_TEMPLATE;
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(templatePath));
		PrintUtils.excelResponseOutput(response, workbook, "ExpressImportTemplate.xlsx");
	}
}
