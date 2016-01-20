package com.palette.busi.project.tms.common.util;

import java.util.List;

public class CallDbSpUtils {

	public static <T> T getSubResultListFirstValue(List<Object> resultList, Integer index) {
		List<Object> list = (List<Object>) resultList.get(index);
		return list != null && list.size() > 0 ? (T) list.get(0) : null;
	}
}
