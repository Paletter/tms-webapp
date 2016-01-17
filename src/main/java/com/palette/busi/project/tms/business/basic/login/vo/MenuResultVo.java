package com.palette.busi.project.tms.business.basic.login.vo;

import java.util.List;

public class MenuResultVo {

	private String category;
	private String menuCate;
	
	private List<MenuSubResultVo> menuSubList;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMenuCate() {
		return menuCate;
	}

	public void setMenuCate(String menuCate) {
		this.menuCate = menuCate;
	}

	public List<MenuSubResultVo> getMenuSubList() {
		return menuSubList;
	}

	public void setMenuSubList(List<MenuSubResultVo> menuSubList) {
		this.menuSubList = menuSubList;
	}
	
}
