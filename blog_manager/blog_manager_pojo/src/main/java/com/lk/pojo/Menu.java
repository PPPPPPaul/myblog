package com.lk.pojo;

import java.io.Serializable;

public class Menu implements Serializable {
    /**
	* 
	*/
    private Integer menuId;

    /**
	* 
	*/
    private String menuName;

    /**
	* 
	*/
    private String menuUrl;

    /**
	* 
	*/
    private Integer menuLevel;

    /**
	* 
	*/
    private String menuIcon;

    /**
	* 
	*/
    private Integer menuOrder;

    /**
	* 
	*/
    private Integer menuStatus;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }
}