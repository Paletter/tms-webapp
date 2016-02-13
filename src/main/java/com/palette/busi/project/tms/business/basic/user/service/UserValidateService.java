package com.palette.busi.project.tms.business.basic.user.service;

import com.palette.busi.project.tms.business.basic.user.dto.AddUserReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserReqDto;

public interface UserValidateService {

	public void validateAddUser(AddUserReqDto reqDto);
	public void validateUpdateUser(UpdateUserReqDto reqDto);

}
