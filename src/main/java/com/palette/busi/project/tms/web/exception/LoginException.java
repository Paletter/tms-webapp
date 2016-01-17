package com.palette.busi.project.tms.web.exception;

import com.palette.busi.project.tms.core.base.BaseException;

public class LoginException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public LoginException(String message, Integer exceptionCode) {
		super(message);
	}
	
	public LoginException(String message) {
		super(message);
	}
}
