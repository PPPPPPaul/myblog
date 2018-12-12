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
}