package com.lk.mapper;

import com.lk.pojo.Tag;
import com.lk.pojo.custom.CustomerArticle;

import java.util.List;

public interface ArticleMapper {
    List<CustomerArticle> selectAllArticle();
    List<Tag> selectTags(int[] tid);
}
