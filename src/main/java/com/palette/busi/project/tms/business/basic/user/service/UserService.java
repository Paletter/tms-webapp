package com.palette.busi.project.tms.business.basic.user.service;

import com.palette.busi.project.tms.business.basic.user.dto.AddUserReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.ResetPwdReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserAuthRoleReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserAuthWareReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.CdUser;
import com.palette.busi.project.tms.core.entity.CdUserWarehouse;

public interface UserService {

	public CdUser createUserInfo(AddUserReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public CdUser updateUserInfo(UpdateUserReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void resetPwd(ResetPwdReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public CdUserWarehouse insertUserWarehouse(UpdateUserAuthWareReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void deleteUserWarehouse(UpdateUserAuthWareReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updateUserRole(UpdateUserAuthRoleReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
