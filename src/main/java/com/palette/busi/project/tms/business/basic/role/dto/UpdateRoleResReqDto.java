package com.palette.busi.project.tms.business.basic.role.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UpdateRoleResReqDto extends BaseReqDto {

	private Integer cdRoleId;
	private Integer cdResourceId;

	public Integer getCdRoleId() {
		return cdRoleId;
	}

	public void setCdRoleId(Integer cdRoleId) {
		this.cdRoleId = cdRoleId;
	}

	public Integer getCdResourceId() {
		return cdResourceId;
	}

	public void setCdResourceId(Integer cdResourceId) {
		this.cdResourceId = cdResourceId;
	}

}
