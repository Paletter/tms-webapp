package com.palette.busi.project.tms.business.basic.user.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UpdateUserAuthWareReqDto extends BaseReqDto {

	private Integer cdUserId;
	private Integer cdWarehouseId;

	public Integer getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(Integer cdUserId) {
		this.cdUserId = cdUserId;
	}

	public Integer getCdWarehouseId() {
		return cdWarehouseId;
	}

	public void setCdWarehouseId(Integer cdWarehouseId) {
		this.cdWarehouseId = cdWarehouseId;
	}
	
}
