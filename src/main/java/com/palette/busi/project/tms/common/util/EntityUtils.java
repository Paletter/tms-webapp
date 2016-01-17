package com.palette.busi.project.tms.common.util;

import java.lang.reflect.Method;
import java.util.Date;

import com.palette.busi.project.tms.web.exception.BusinessException;

public class EntityUtils {

	public static void setBasicDataForCreateEntity(Object obj, String user) {
		
		try {
			
			Method setCDTMethod = obj.getClass().getMethod("setCreateDateTime", Date.class);
			setCDTMethod.invoke(obj, DateUtils.getCurrentGMTDate());
			Method setCUCMethod = obj.getClass().getMethod("setCreateUserCode", String.class);
			setCUCMethod.invoke(obj, user);
			
			Method setUDTMethod = obj.getClass().getMethod("setUpdateDateTime", Date.class);
			setUDTMethod.invoke(obj, DateUtils.getCurrentGMTDate());
			Method setUUCMethod = obj.getClass().getMethod("setUpdateUserCode", String.class);
			setUUCMethod.invoke(obj, user);
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。数据创建时间戳设置错误");
		}
	}
	
	public static void setBasicDataForUpdateEntity(Object obj, String user) {
		
		try {
			
			Method setUDTMethod = obj.getClass().getMethod("setUpdateDateTime", Date.class);
			setUDTMethod.invoke(obj, DateUtils.getCurrentGMTDate());
			Method setUUCMethod = obj.getClass().getMethod("setUpdateUserCode", String.class);
			setUUCMethod.invoke(obj, user);
			
		} catch (Exception e) {
			throw new BusinessException("操作失败。数据更新时间戳设置错误");
		}
	}
}
