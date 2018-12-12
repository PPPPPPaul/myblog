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
}
