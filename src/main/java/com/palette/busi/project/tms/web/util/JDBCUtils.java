package com.palette.busi.project.tms.web.util;

import com.palette.busi.project.tms.common.util.MD5Utils;

public class JDBCUtils {

	private final static String salt = "0b2f505363d2dfcf5e06879d529d7a7a";
	
	protected String getSalt(){
		return salt;
	}
	
	public static String encrypt(String str){
		return MD5Utils.encrypt(MD5Utils.encrypt(MD5Utils.encrypt(MD5Utils.encrypt(str, salt), salt), salt), salt);
	}
}

