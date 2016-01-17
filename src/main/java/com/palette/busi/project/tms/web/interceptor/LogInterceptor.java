package com.palette.busi.project.tms.web.interceptor;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.palette.busi.project.tms.business.basic.login.vo.LoginUserResultVo;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.SessionUtils;
import com.palette.busi.project.tms.core.dao.SysLogDao;
import com.palette.busi.project.tms.core.entity.SysLog;

public class LogInterceptor extends HandlerInterceptorAdapter {

	public Logger log = LoggerFactory.getLogger(LogInterceptor.class);
	
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		try {
			
			if(handler instanceof HandlerMethod) {
			    HandlerMethod handlerMethod = (HandlerMethod) handler;
			    String classPathName = handlerMethod.getBeanType().getName();
			    
			    if(classPathName.contains("com.udfexpress.oso.business")) {
			    	
					SysLog sysLog = new SysLog();
					
				    sysLog.setClassPathName(handlerMethod.getBeanType().getName());
				    sysLog.setClassName(handlerMethod.getBeanType().getSimpleName());
				    sysLog.setMethodName(handlerMethod.getMethod().getName());
					
					// Request parameters
					if(request.getMethod() != null && request.getMethod().equals("POST")) {
						BufferedReader reader = request.getReader();
						String bodyParamter = "";
						String line;
						while ((line = reader.readLine()) != null) {
							bodyParamter += line;
						}
						
						sysLog.setParameters(bodyParamter);
					}
					
					if(request.getMethod() != null && request.getMethod().equals("GET")) {
						if(request.getParameterMap() != null) {
							sysLog.setParameters(JSONObject.toJSONString(request.getParameterMap()));
						}
					}
					
					String sessionId = request.getSession().getId();
					sysLog.setSeesionId(sessionId);
					sysLog.setIp(request.getRemoteAddr());
					LoginUserResultVo user = SessionUtils.getLoginUserSession(sessionId);
					if(user != null && user.getCdUser() != null) {
						sysLog.setActionUserCode(user.getCdUser().getUserName());
					}
					
					sysLog.setActionDateTime(DateUtils.getCurrentGMTDate());
					
					sysLogDao.insertSysLog(sysLog);
			    }
			}
		} catch (Exception e) {
			
			log.error(e.getMessage());
		}
		
		return super.preHandle(request, response, handler);
	}

}
