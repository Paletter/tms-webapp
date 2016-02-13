package com.palette.busi.project.tms.business.basic.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.basic.role.controller.RoleController;
import com.palette.busi.project.tms.business.basic.role.dto.AddRoleReqDto;
import com.palette.busi.project.tms.business.basic.role.dto.UpdateRoleReqDto;
import com.palette.busi.project.tms.business.basic.role.dto.UpdateRoleResReqDto;
import com.palette.busi.project.tms.business.basic.role.service.RoleService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.CdResRoleDao;
import com.palette.busi.project.tms.core.dao.CdRoleDao;
import com.palette.busi.project.tms.core.entity.CdResRole;
import com.palette.busi.project.tms.core.entity.CdRole;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Autowired
	private CdRoleDao cdRoleDao;
	@Autowired
	private CdResRoleDao cdResRoleDao;
	
	@Override
	public void createRoleInfo(AddRoleReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdRole cdRole = new CdRole();
		cdRole.setRoleName(reqDto.getRoleName());
		cdRole.setDescpt(reqDto.getDescpt());
		cdRole.setCategory(reqDto.getCategory());
		cdRoleDao.insertCdRole(cdRole, linkerVo.getUserName(), RoleController.CONTROLLER_ID);
	}
	
	@Override
	public void updateRoleInfo(UpdateRoleReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdRole cdRole = querier.selectCdRoleById(reqDto.getCdRoleId());
		cdRole.setRoleName(reqDto.getRoleName());
		cdRole.setDescpt(reqDto.getDescpt());
		cdRole.setCategory(reqDto.getCategory());
		cdRoleDao.updateCdRole(cdRole, linkerVo.getUserName(), RoleController.CONTROLLER_ID);
	}
	
	@Override
	public void insertResRole(UpdateRoleResReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdResRole cdResRole = new CdResRole();
		cdResRole.setCdRoleId(reqDto.getCdRoleId());
		cdResRole.setCdResourceId(reqDto.getCdResourceId());
		cdResRoleDao.insertCdResRole(cdResRole, linkerVo.getUserName(), RoleController.CONTROLLER_ID);
	}
	
	@Override
	public void deleteResRole(UpdateRoleResReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdResRole cdResRoleQuery = new CdResRole();
		cdResRoleQuery.setCdRoleId(reqDto.getCdRoleId());
		cdResRoleQuery.setCdResourceId(reqDto.getCdResourceId());
		CdResRole cdResRole = querier.selectCdResRoleOneByRecord(cdResRoleQuery);
		
		cdResRoleDao.deleteCdResRole(cdResRole.getCdResRoleId());
	}
}
