package com.lk.mapper;

import com.lk.pojo.Category;
import com.lk.pojo.custom.CategoryCustom;

import java.util.List;

public interface CategoryMapper {
    /**
     * 获取全部的类别信息
     * @return
     */
    List<Category> selectCategoryList();
    /**
     * 根据类型id查询全部类型信息
     * @param cid
     * @return
     */
    List<Category> selectCategories(int[] cid);

    /**
     * 查询自定义类别集合
     * @return
     */
    List<CategoryCustom> selectCategoryCustom();

    /**
     * 根据类别id查询类别对象
     * @param cid
     * @return
     */
    Category selectCategory(int cid);

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
     * 删除类别
     * @param cid
     */
    void deleteCategory(int cid);
}