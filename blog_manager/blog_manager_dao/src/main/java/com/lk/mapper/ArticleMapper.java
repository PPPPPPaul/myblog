package com.lk.mapper;

import com.lk.pojo.Category;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.CustomerArticle;

import java.util.List;

public interface ArticleMapper {
    /**
     * 查询全部文章信息
     * @return
     */
    List<CustomerArticle> selectCustomArticle();

    /**
     * 根据类型id查询全部类型信息
     * @param cid
     * @return
     */
    List<Category> selectCategories(int[] cid);

    /**
     * 根据标签id查询全部标签信息
     * @param tid
     * @return
     */
    List<Tag> selectTags(int[] tid);
}
