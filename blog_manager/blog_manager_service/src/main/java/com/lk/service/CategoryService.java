package com.lk.service;

import com.lk.pojo.Category;
import com.lk.pojo.custom.CategoryCustom;

import java.util.List;

public interface CategoryService {
    /**
     * 获取全部的类别数据
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 获取自定义类别集合
     * @return
     */
    List<CategoryCustom> getCategoryCustom();

    /**
     * 根据类别id获取类别对象
     * @param cid
     * @return
     */
    Category getCategory(int cid);
    /**
     * 添加新的类别
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 修改类别信息
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 删除类别信息
     * @param cid
     */
    void deleteCateGory(int cid);
}
