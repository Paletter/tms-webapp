package com.palette.busi.project.tms.common.util;

import java.util.Collection;

import com.palette.busi.project.tms.web.exception.BusinessException;

public class ThrowExp {

	public static void isTrue(boolean b, String message) {
		if(b) throw new BusinessException(message);
	}
	
    public static void isNull(Object object, String message) {
        if (object == null) throw new BusinessException(message);
    }
    
    public static void isNullOrEmpty(String str, String message) {
    	if (StringUtils.isNullOrEmpty(str)) throw new BusinessException(message);
    }
    
    public static void isNotNull(Object object, String message) {
    	if (object != null) throw new BusinessException(message);
    }
    
    public static void isNotEmpty(Collection c, String message) {
    	if (c != null && c.size() > 0) throw new BusinessException(message);
    }
    
    public static void isEmpty(Collection c, String message) {
    	if (c == null || c.size() > 0) throw new BusinessException(message);
    }
}
