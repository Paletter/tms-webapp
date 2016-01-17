package com.palette.busi.project.tms.web.exception;

import com.palette.busi.project.tms.core.base.BaseException;

public class BusinessException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message, Integer exceptionCode) {
		super(message);
	}
	
	public BusinessException(String message) {
		super(message);
	}
}
