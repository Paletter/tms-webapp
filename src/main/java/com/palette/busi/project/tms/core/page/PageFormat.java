package com.palette.busi.project.tms.core.page;

public class PageFormat 
{

	public static PageInfo dataFormat(Page page)
	{
		PageModel model = new PageModel();
		model.setEndRow(page.getEndRow());
		model.setPageNum(page.getPageNum());
		model.setPages(page.getPages());
		model.setPageSize(page.getPageSize());
		model.setStartRow(page.getStartRow());
		model.setTotal(page.getTotal());
		
		
		PageInfo info = new PageInfo();
		info.setData(page.getResult());
		info.setPageInfo(model);
		return info;
	}
}
