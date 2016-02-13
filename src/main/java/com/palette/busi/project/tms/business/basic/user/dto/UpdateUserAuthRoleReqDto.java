package com.palette.busi.project.tms.business.basic.user.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class UpdateUserAuthRoleReqDto extends BaseReqDto {

	private Integer cdUserId;
	private Integer cdRoleId;

	public Integer getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(Integer cdUserId) {
		this.cdUserId = cdUserId;
	}

	public Integer getCdRoleId() {
		return cdRoleId;
	}

	public void setCdRoleId(Integer cdRoleId) {
		this.cdRoleId = cdRoleId;
	}
	
}
