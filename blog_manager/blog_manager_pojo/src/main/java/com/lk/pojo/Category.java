package com.lk.pojo;


import java.io.Serializable;

public class Category implements Serializable {

  private Integer categoryId;
  private Integer categoryPid;
  private String categoryName;
  private String categoryDescription;
  private Integer categoryOrder;
  private String categoryIcon;
  private Integer categoryStatus;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getCategoryPid() {
    return categoryPid;
  }

  public void setCategoryPid(Integer categoryPid) {
    this.categoryPid = categoryPid;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryDescription() {
    return categoryDescription;
  }

  public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
  }

  public Integer getCategoryOrder() {
    return categoryOrder;
  }

  public void setCategoryOrder(Integer categoryOrder) {
    this.categoryOrder = categoryOrder;
  }

  public String getCategoryIcon() {
    return categoryIcon;
  }

  public void setCategoryIcon(String categoryIcon) {
    this.categoryIcon = categoryIcon;
  }

  public Integer getCategoryStatus() {
    return categoryStatus;
  }

  public void setCategoryStatus(Integer categoryStatus) {
    this.categoryStatus = categoryStatus;
  }
}
