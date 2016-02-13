package com.palette.busi.project.tms.business.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.core.entity.CdCompany;
import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.entity.CdDelivery;
import com.palette.busi.project.tms.core.entity.CdPort;
import com.palette.busi.project.tms.core.entity.CdResource;
import com.palette.busi.project.tms.core.entity.CdRole;
import com.palette.busi.project.tms.core.entity.CdWarehouse;

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
    
    @RequestMapping("/CommonBasicInfoController/queryAllActiveCompany")
    public List<CdCompany> queryAllActiveCompany() {
    	
    	CdCompany cdCompanyQuery = new CdCompany();
    	cdCompanyQuery.setIsActive(1);
    	List<CdCompany> resultList = querier.selectCdCompanyAllByRecord(cdCompanyQuery);
    	return resultList;
    }
    
    @RequestMapping("/CommonBasicInfoController/queryAllActiveWarehouse")
    public List<CdWarehouse> queryAllActiveWarehouse() {
    	
    	CdWarehouse cdWarehouseQuery = new CdWarehouse();
    	cdWarehouseQuery.setIsActive(1);
    	List<CdWarehouse> resultList = querier.selectCdWarehouseAllByRecord(cdWarehouseQuery);
    	return resultList;
    }
    
    @RequestMapping("/CommonBasicInfoController/queryAllRole")
    public List<CdRole> queryAllRole() {
    	
    	List<CdRole> resultList = querier.selectCdRoleAll();
    	return resultList;
    }
    
    @RequestMapping("/CommonBasicInfoController/queryAllActiveResource")
    public List<CdResource> queryAllActiveResource() {
    	
    	CdResource cdResourceQuery = new CdResource();
    	cdResourceQuery.setIsActive(1);
    	List<CdResource> resultList = querier.selectCdResourceAllByRecord(cdResourceQuery);
    	return resultList;
    }
}
