package com.lk.service;

import com.lk.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 获取全部的类别数据
     * @return
     */
    List<Category> getCategoryList();
}
