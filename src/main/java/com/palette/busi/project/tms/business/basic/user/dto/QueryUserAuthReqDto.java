package com.palette.busi.project.tms.business.basic.user.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class QueryUserAuthReqDto extends BaseReqDto {

	private Integer cdUserId;

	public Integer getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(Integer cdUserId) {
		this.cdUserId = cdUserId;
	}
	
}
