package com.palette.busi.project.tms.business.delivery.flight.service.impl;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.delivery.flight.service.FlightPrintService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.PrintTemplateConstants;
import com.palette.busi.project.tms.core.entity.TmUnit;

@Service
public class FlightPrintServiceImpl extends BaseServiceImpl implements FlightPrintService {

	@Override
	public XSSFWorkbook createUnitLabel(String servletRealPath, List<TmUnit> tmUnitList) throws Exception {

		String templatePath = servletRealPath + PrintTemplateConstants.COM_UNIT_LABLE;
		XSSFWorkbook workbook = servicePvd.usLabelExcelCreator.createUnitLabelWorkBook(templatePath, tmUnitList);
		
		return workbook;
	}
}
