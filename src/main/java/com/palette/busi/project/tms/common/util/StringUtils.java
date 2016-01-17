package com.palette.busi.project.tms.common.util;

import java.util.UUID;

import org.springframework.util.Assert;

public class StringUtils {
	
	public static final String BLANK = "";
	public static final String SPACE = " ";
	
	public static final String ESC_LINE_FEED = "\n";
	public static final String ESC_CARRIAGE_RETURN = "\r";
	public static final String ESC_SINGLE_QUOTES = "\'";
	public static final String ESC_DOUBLE_QUOTES = "\"";
	
	public static String getRandomCode(String firstChar, String additional) {
		StringBuilder sb = new StringBuilder();
		sb.append(firstChar).append("_");
		if("".equals(additional))
			sb.append(additional).append("_");
		sb.append(System.currentTimeMillis());
		return sb.toString();
	}

	public static boolean isRoot(String name) {
		if("root".equals(name.toLowerCase()))
			return true;
		return false;
	}

	public static boolean isNullOrEmpty(String str) {
		if(str == null || str.isEmpty())
			return true;
		return false;
	}
	
	public static boolean isNullOrEmpty(Integer i) {
		if(i == null)
			return true;
		return false;
	}
	
	public static boolean isNotNullOrEmpty(String str) {
		if(str != null && !str.isEmpty())
			return true;
		return false;
	}
	
	public static boolean isNotNullOrEmpty(Integer i) {
		if(i != null)
			return true;
		return false;
	}
	
	public static boolean isNullOrWhiteSpace(String str) {
		if(str == null || str == "") {
			return true;
		}
		return false;
	}
	
	public static String getValue(String str) {
		return str == null ? BLANK : str;
	}
	
	public static String concat(String ...strs) {
		String result = "";
		for(String str : strs) {
			result += getValue(str);
		}
		return result;
	}
	
    public static String getUUID(int length) {
        Assert.isTrue(length > 0 && length <= 32, "length must be > 0 and <= 32");
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replaceAll("-", "");
        return str.substring(0,length);
    }
}
