package com.palette.busi.project.tms.core.page;

import java.util.List;

public class PageInfo<T> 
{
	private List<?> data;
	
	private PageModel pageInfo;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public PageModel getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageModel pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
