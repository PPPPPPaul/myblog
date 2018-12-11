package com.lk.service;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.custom.CustomerArticle;

import java.util.List;

public interface ArticleService {
    /**
     * 通过pageHelper获取全部文章
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<CustomerArticle> getAllArticle(int pageNum,int pageSize);

    /**
     * 批量删除文章信息
     * @param ids
     * @return
     */
    YHResult deleteArticle(int[] ids);
    CustomerArticle getArticleById(int aid);
}
