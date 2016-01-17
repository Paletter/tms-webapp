package com.palette.busi.project.tms.web.vo;

import java.io.Serializable;

import com.palette.busi.project.tms.core.page.PageModel;

public class ViewJsonVo implements Serializable {

	private static final long serialVersionUID = 5426628546577087822L;

	/**
	 * 状态码：请求成功
	 */
	public static final int STATUS_SUCCESS = 0;
	
	/**
	 * 状态码：业务异常
	 */
	public static final int STATUS_BUSINESS_EXCEPTION = 1;
	
	/**
	 * 状态码：系统异常
	 */
	public static final int STATUS_SYSTEM_EXCEPTION = 2;
	
	/**
	 * 状态码：登录状态异常
	 */
	public static final int STATUS_LOGIN_EXCEPTION = 3;
	
	/**
	 * 信息：默认"请求成功"
	 */
	public static final String MSG_DEFAULT = "请求成功";

	private int status;
	private Object result;
	private PageModel pageInfo;
	private String msg;
	
	/**
	 * 
	 */
	public ViewJsonVo() {
		super();
		this.status = STATUS_SUCCESS;
		this.msg = MSG_DEFAULT;
	}
	
	/**
	 * 默认成功状态
	 * msg:"请求成功"
	 * status:0
	 * @param result
	 */
	public ViewJsonVo(Object result) {
		super();
		this.status = STATUS_SUCCESS;
		this.result = result;
		this.msg = MSG_DEFAULT;
	}
	
	/**
	 * 默认成功状态
	 * status:0
	 * @param result
	 * @param msg
	 */
	public ViewJsonVo(Object result, String msg) {
		super();
		this.status = STATUS_SUCCESS;
		this.result = result;
		this.msg = msg;
	}
	
	/**
	 * @param result 结果
	 * @param msg 返回信息
	 * @param status 状态
	 */
	public ViewJsonVo(Object result, String msg, Integer status) {
		super();
		this.status = status;
		this.result = result;
		this.msg = msg;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public PageModel getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageModel pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
