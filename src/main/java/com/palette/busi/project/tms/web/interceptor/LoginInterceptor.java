package com.palette.busi.project.tms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.palette.busi.project.tms.business.basic.login.vo.LoginUserResultVo;
import com.palette.busi.project.tms.common.util.SessionUtils;
import com.palette.busi.project.tms.web.exception.LoginException;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		LoginUserResultVo user = SessionUtils.getLoginUserSession(request.getSession().getId());
		if(user == null) {
			throw new LoginException("请重新登录");
		}
		
		return super.preHandle(request, response, handler);
	}
}
