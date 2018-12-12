package com.lk.mapper;

import com.lk.pojo.Article;
import com.lk.pojo.custom.ArticleCustomer;

import java.util.List;

public interface ArticleMapper {
    /**
     * 查询全部文章信息
     * @return
     */
    List<ArticleCustomer> selectCustomArticle();

    /**
     * 根据文章id查询单个文章信息
     * @param aid
     * @return
     */
    ArticleCustomer selectArticleById(int aid);

    /**
     * 批量删除文章
     * @param ids
     */
    void deleteArticle(int[] ids);

    /**
     * 项数据库插入新的文章信息
     * @param article
     */
    void insertArticle(Article article);

    /**
     * 修改文章的数据库信息
     * @param article
     */
    void updateArticle(Article article);
}
