package com.palette.busi.project.tms.common.base;

public class BaseUpdateVo {

	protected String userName;
	protected String controllerId;

	public BaseUpdateVo(String userName, String controllerId) {
		super();
		this.userName = userName;
		this.controllerId = controllerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getControllerId() {
		return controllerId;
	}

	public void setControllerId(String controllerId) {
		this.controllerId = controllerId;
	}
	
}
