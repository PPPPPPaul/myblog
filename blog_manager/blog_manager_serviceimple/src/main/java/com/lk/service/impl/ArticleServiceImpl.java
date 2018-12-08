package com.lk.service.impl;

import com.github.pagehelper.PageHelper;
import com.lk.mapper.ArticleMapper;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.CustomerArticle;
import com.lk.service.ArticleService;
import com.lk.utils.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<CustomerArticle> getAllArticle() {
        try {
            List<CustomerArticle> articles = articleMapper.selectAllArticle();
            for (CustomerArticle customerArticle:articles){
                String tagIds = customerArticle.getArticleTagIds();
                int[] arrayTags = StringTool.stringToArray(tagIds);
                if (arrayTags !=null&&arrayTags.length>0) {
                    List<Tag> tags = articleMapper.selectTags(arrayTags);
                    customerArticle.setTags(tags);
                }
            }

            List<CustomerArticle> ar = articles;
            return articles;
        }catch (Exception e){
            return null;
        }
    }
}
