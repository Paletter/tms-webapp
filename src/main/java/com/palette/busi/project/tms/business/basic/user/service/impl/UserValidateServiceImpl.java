package com.palette.busi.project.tms.business.basic.user.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.basic.user.dto.AddUserReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserReqDto;
import com.palette.busi.project.tms.business.basic.user.service.UserValidateService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.CdUser;

@Service
public class UserValidateServiceImpl extends BaseServiceImpl implements UserValidateService {

	@Override
	public void validateAddUser(AddUserReqDto reqDto) {
		
		ThrowExp.isNullOrEmpty(reqDto.getUserName(), "操作失败。用户名不能为空");
		ThrowExp.isNullOrEmpty(reqDto.getFullName(), "操作失败。用户姓名不能为空");
		ThrowExp.isNullOrEmpty(reqDto.getPwd(), "操作失败。密码不能为空");
		ThrowExp.isNullOrEmpty(reqDto.getCompanyCode(), "操作失败。所属公司不能为空");
		
		CdUser cdUserQuery = new CdUser();
		cdUserQuery.setUserName(reqDto.getUserName());
		CdUser cdUser = querier.selectCdUserOneByRecord(cdUserQuery);
		ThrowExp.isNotNull(cdUser, "操作失败。用户名已存在");
	}
	
	@Override
	public void validateUpdateUser(UpdateUserReqDto reqDto) {
		
		ThrowExp.isNull(querier.selectCdUserById(reqDto.getCdUserId()), "操作失败。查询不到用户信息");
		ThrowExp.isNullOrEmpty(reqDto.getUserName(), "操作失败。用户名不能为空");
		ThrowExp.isNullOrEmpty(reqDto.getFullName(), "操作失败。用户姓名不能为空");
		ThrowExp.isNullOrEmpty(reqDto.getCompanyCode(), "操作失败。所属公司不能为空");
		ThrowExp.isNull(reqDto.getIsActive(), "操作失败。用户有效性不能为空");
		
		CdUser cdUserQuery = new CdUser();
		cdUserQuery.setUserName(reqDto.getUserName());
		CdUser cdUser = querier.selectCdUserOneByRecord(cdUserQuery);
		ThrowExp.isTrue(cdUser != null && !cdUser.getCdUserId().equals(reqDto.getCdUserId()), "操作失败。用户名已存在");
	}
}
