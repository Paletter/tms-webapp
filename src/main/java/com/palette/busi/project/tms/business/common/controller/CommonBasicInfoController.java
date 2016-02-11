package com.palette.busi.project.tms.business.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.entity.CdDelivery;
import com.palette.busi.project.tms.core.entity.CdPort;

@RestController
public class CommonBasicInfoController extends BaseController {

	@RequestMapping("/CommonBasicInfoController/queryAllPort")
    public List<CdPort> queryAllPort() {
    	List<CdPort> resultList = querier.selectCdPortAll();
    	return resultList;
    }
    
    @RequestMapping("/CommonBasicInfoController/queryAllCountry")
    public List<CdCountry> queryAllCountry() {
    	List<CdCountry> resultList = querier.selectCdCountryAll();
    	return resultList;
    }
    
    @RequestMapping("/CommonBasicInfoController/queryAllDelivery")
    public List<CdDelivery> queryAllDelivery() {
    	List<CdDelivery> resultList = querier.selectCdDeliveryAll();
    	return resultList;
    }
}
