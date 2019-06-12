package com.my.ssm.sys.dto;

import java.util.List;

/**
 * 系统菜单表拓展
 *
 * @com.my.ssm.sys.dto.MenuDTO.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-30 10:14:36
 */
public class MenuDTO {
	
	private String title; // 菜单名称
	
	private String icon; // 菜单图标
	
	private String href; // 菜单链接
	
	private boolean spread = false; // 是否展开
	
	private List<MenuDTO> children; // 子菜单

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	public List<MenuDTO> getChildren() {
		return children;
	}

	public void setChildren(List<MenuDTO> children) {
		this.children = children;
	}
}