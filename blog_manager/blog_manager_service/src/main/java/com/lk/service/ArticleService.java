package com.lk.service;

import com.github.pagehelper.PageInfo;
import com.lk.pojo.custom.CustomerArticle;

import java.util.List;

public interface ArticleService {
    PageInfo<CustomerArticle> getAllArticle(int pageNum,int pageSize);
}
