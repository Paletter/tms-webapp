package com.palette.busi.project.tms.business.delivery.outTemplate.controller;

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

import com.palette.busi.project.tms.business.delivery.outTemplate.service.OutTemplateService;
import com.palette.busi.project.tms.business.delivery.outTemplate.vo.DeliverPiecesImportVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.PrintTemplateConstants;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.util.PrintUtils;

@RestController
public class OutTemplateController extends BaseController {

	public static String CONTROLLER_ID = "OUT_TEMPLATE";
	
	@Autowired
	private OutTemplateService outTemplateService;

	@RequestMapping(value="/OutTemplateController/printDeliverPiecesImportTemplate")
	public void printDeliverPiecesImportTemplate(HttpServletResponse response) throws FileNotFoundException, IOException {
			
		String templatePath = getServletRealPath() + PrintTemplateConstants.OT_DELIVER_PIECES_IMPORT_TEMPLATE;
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(templatePath));
		PrintUtils.excelResponseOutput(response, workbook, "DeliverPiecesImportTemplate.xlsx");
	}
	
	@RequestMapping(value="/OutTemplateController/importDeliverPiecesExcel")
	public boolean importDeliverPiecesExcel(@RequestParam(value="deliverPiecesFile") MultipartFile file) throws IOException {
		
		// Validate
		ExcelUtils.validateImportExcel(file);
		
		// Business
		List<DeliverPiecesImportVo> importVoList = outTemplateService.importDeliverPiecesExcel(file);
		
		outTemplateService.concurrencyDeliverPieces(importVoList, getSessionLinkerVo());
		
		return true;
	}
}
