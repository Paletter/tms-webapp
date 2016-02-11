package com.palette.busi.project.tms.common.base;

import com.palette.busi.project.tms.core.constants.EntityRowStatusConstant;

public class BaseRowVo {
	
	private String rowStatus = EntityRowStatusConstant.ROW_STATUS_INITIAL;
	
	public boolean isInitilRow() {
		return rowStatus != null && rowStatus.equals(EntityRowStatusConstant.ROW_STATUS_INITIAL);
	}
	
	public boolean isAddRow() {
		return rowStatus != null && rowStatus.equals(EntityRowStatusConstant.ROW_STATUS_ADD);
	}
	
	public boolean isModifyRow() {
		return rowStatus != null && rowStatus.equals(EntityRowStatusConstant.ROW_STATUS_MODIFY);
	}
	
	public boolean isDeletedRow() {
		return rowStatus != null && rowStatus.equals(EntityRowStatusConstant.ROW_STATUS_REMOVE);
	}

	public String getRowStatus() {
		return rowStatus;
	}

	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}
	
}
