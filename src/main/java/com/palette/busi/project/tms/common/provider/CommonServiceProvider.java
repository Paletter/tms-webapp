package com.palette.busi.project.tms.common.provider;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palette.busi.project.tms.business.common.print.LabelExcelCreator;
import com.palette.busi.project.tms.business.common.service.CommonFlightService;
import com.palette.busi.project.tms.business.common.service.CommonLocationService;
import com.palette.busi.project.tms.business.common.service.CommonPiecesService;
import com.palette.busi.project.tms.business.common.service.CommonSeqNumberService;

@Component
public class CommonServiceProvider {

	@Autowired
	public CommonPiecesService commonPiecesService;
	@Autowired
	public CommonSeqNumberService commonSeqNumberService;
	@Autowired
	public CommonLocationService commonLocationService;
	@Autowired
	public CommonFlightService commonFlightService;
	@Resource(name="USLabelExcelCreator")
	public LabelExcelCreator usLabelExcelCreator;
}
