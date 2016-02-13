package com.palette.busi.project.tms.business.basic.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.basic.role.dto.AddRoleReqDto;
import com.palette.busi.project.tms.business.basic.role.dto.UpdateRoleReqDto;
import com.palette.busi.project.tms.business.basic.role.dto.UpdateRoleResReqDto;
import com.palette.busi.project.tms.business.basic.role.service.RoleService;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.core.entity.CdResource;

@RestController
public class RoleController extends BaseController {

	public static String CONTROLLER_ID = "ROLE";
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/RoleController/addRole")
	public boolean addRole(@RequestBody AddRoleReqDto reqDto) {
		
		// Business
		roleService.createRoleInfo(reqDto, getSessionLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/RoleController/updateRole")
	public boolean updateRole(@RequestBody UpdateRoleReqDto reqDto) {
		
		// Business
		roleService.updateRoleInfo(reqDto, getSessionLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/RoleController/queryRoleRes")
	public List<CdResource> queryRoleRes(@RequestParam Integer cdRoleId) {
		
		List<CdResource> cdResList = selectList(SqlMapperConstants.ROLE_QUERY_ROLE_RESOURCE, cdRoleId);
		
		return cdResList;
	}
	
	@RequestMapping(value="/RoleController/addRoleRes")
	public boolean addRoleRes(@RequestBody UpdateRoleResReqDto reqDto) {
		
		roleService.insertResRole(reqDto, getSessionLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/RoleController/removeRoleRes")
	public boolean removeRoleRes(@RequestBody UpdateRoleResReqDto reqDto) {
		
		roleService.deleteResRole(reqDto, getSessionLinkerVo());
		
		return true;
	}
}
