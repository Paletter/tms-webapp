package com.palette.busi.project.tms.core.base;

import java.io.Serializable;

import com.palette.busi.project.tms.core.constants.EntityRowStatusConstant;
import com.palette.busi.project.tms.core.page.PageModel;

public class BasePo implements Serializable {
	
	private static final long serialVersionUID = 4669583386311063931L;
	
	private String rowStatus = EntityRowStatusConstant.ROW_STATUS_INITIAL;
	private String actionDesc;
	private PageModel pageInfo;

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
	
	public PageModel getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageModel pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public String getRowStatus() {
		return rowStatus;
	}

	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}
}
