package com.palette.busi.project.tms.business.basic.role.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UpdateRoleReqDto extends BaseReqDto {

	private Integer cdRoleId;
    private String roleName;
    private String descpt;
    private String category;

	public Integer getCdRoleId() {
		return cdRoleId;
	}

	public void setCdRoleId(Integer cdRoleId) {
		this.cdRoleId = cdRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescpt() {
		return descpt;
	}

	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
}
