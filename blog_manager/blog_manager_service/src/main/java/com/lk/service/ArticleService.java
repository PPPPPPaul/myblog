package com.lk.service;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.Article;
import com.lk.pojo.custom.ArticleCustomer;

import java.util.List;

public interface ArticleService {
    /**
     * 通过pageHelper获取全部文章
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ArticleCustomer> getAllArticle(int pageNum, int pageSize);

    /**
     * 批量删除文章信息
     * @param ids
     * @return
     */
    YHResult deleteArticle(int[] ids);

    /**
     * 获取最近更新的文章
     * @return
     */
    List<ArticleCustomer> getRecentArticle();

    /**
     * 根据文章id获取文章信息，用于编辑文章
     * @param aid
     * @return
     */
    ArticleCustomer getArticleById(int aid);

    /**
     * 编辑保存文章
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 项数据库保存新的文章
     * @param article
     */
    void saveNewArticle(Article article);
}
