package com.palette.busi.project.tms.common.util;

import java.util.HashMap;
import java.util.Map;

import com.palette.busi.project.tms.business.basic.login.vo.LoginUserResultVo;

public class SessionUtils {

	private static Map<String, Object> sessionCache = new HashMap<String, Object>();
	
	public static void saveSession(String sessionId, Object obj) {
		sessionCache.put(sessionId, obj);
	}
	
	public static LoginUserResultVo getLoginUserSession(String sessionId) {
		return (LoginUserResultVo) sessionCache.get(sessionId);
	}
	
	public static void clearLoginUserSession(String sessionId) {
		sessionCache.remove(sessionId);
	}
}
