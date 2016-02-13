package com.palette.busi.project.tms.business.basic.role.service;

import com.palette.busi.project.tms.business.basic.role.dto.AddRoleReqDto;
import com.palette.busi.project.tms.business.basic.role.dto.UpdateRoleReqDto;
import com.palette.busi.project.tms.business.basic.role.dto.UpdateRoleResReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface RoleService {

	public void createRoleInfo(AddRoleReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updateRoleInfo(UpdateRoleReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void insertResRole(UpdateRoleResReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void deleteResRole(UpdateRoleResReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
