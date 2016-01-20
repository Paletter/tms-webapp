package com.palette.busi.project.tms.common.util;

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
}
