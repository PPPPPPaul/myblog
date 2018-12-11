package com.lk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.mapper.ArticleMapper;
import com.lk.pojo.Category;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.CustomerArticle;
import com.lk.service.ArticleService;
import com.lk.utils.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public PageInfo<CustomerArticle> getAllArticle(int pageNum,int pageSize) {
        try{
            //1.从数据库查询所有文章封装到自定义文章对象中，返回所有文章集合，其中包含属性(文章id，文章标题，文章分类)
            PageHelper.startPage(pageNum,pageSize);
            List<CustomerArticle> customerArticles = articleMapper.selectCustomArticle();
            PageInfo<CustomerArticle> pi = new PageInfo<>(customerArticles);
            //2.从数据库查询所有文章所包含的标签
            for (CustomerArticle customerArticle:pi.getList()){
                //查询出文章的所有标签，放入自定义文章对象中
                String tagIds = customerArticle.getArticleTagIds();
                int[] arrayTags = StringTool.stringToArray(tagIds);
                if (arrayTags !=null&&arrayTags.length>0) {
                    List<Tag> tags = articleMapper.selectTags(arrayTags);
                    customerArticle.setTagCustomList(tags);
                }
                //查询出文章的所有分类，放入自定义文章对象中
                int[] categoryIds = {customerArticle.getArticleParentCategoryId(),customerArticle.getArticleChildCategoryId()};
                if (categoryIds !=null&&categoryIds.length>0) {
                    List<Category> categories = articleMapper.selectCategories(categoryIds);
                    customerArticle.setCategoryCustomList(categories);
                }
            }
            return pi;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public YHResult deleteArticle(int[] ids) {
        try {
            if (ids.length > 0) {
                articleMapper.deleteArticle(ids);
                return YHResult.ok();
            }else {
                return YHResult.build(500,"未选中!");
            }
        }catch (Exception e){
            return YHResult.build(500,"删除错误!");
        }
    }

    @Override
    public CustomerArticle getArticleById(int aid) {
        try {
            //1.根据传过来的文章id查询文章对象
            CustomerArticle article = articleMapper.selectArticleById(aid);
            //查询出文章的所有标签，放入自定义文章对象中
            String tagIds = article.getArticleTagIds();
            int[] arrayTags = StringTool.stringToArray(tagIds);
            if (arrayTags !=null&&arrayTags.length>0) {
                List<Tag> tags = articleMapper.selectTags(arrayTags);
                article.setTagCustomList(tags);
            }
            //查询出文章的所有分类，放入自定义文章对象中
            int[] categoryIds = {article.getArticleParentCategoryId(),article.getArticleChildCategoryId()};
            if (categoryIds !=null&&categoryIds.length>0) {
                List<Category> categories = articleMapper.selectCategories(categoryIds);
                article.setCategoryCustomList(categories);
            }
            return article;
        }catch (Exception e){
            return null;
        }
    }
}
