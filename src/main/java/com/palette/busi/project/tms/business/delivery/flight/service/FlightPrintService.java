package com.palette.busi.project.tms.business.delivery.flight.service;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.palette.busi.project.tms.core.entity.TmUnit;

public interface FlightPrintService {

	public XSSFWorkbook createUnitLabel(String servletRealPath, List<TmUnit> tmUnitList) throws Exception;

}
