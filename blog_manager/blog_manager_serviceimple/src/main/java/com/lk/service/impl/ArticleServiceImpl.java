package com.lk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.mapper.ArticleMapper;
import com.lk.mapper.CategoryMapper;
import com.lk.mapper.TagMapper;
import com.lk.pojo.Article;
import com.lk.pojo.Category;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.ArticleCustomer;
import com.lk.service.ArticleService;
import com.lk.utils.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public PageInfo<ArticleCustomer> getAllArticle(int pageNum, int pageSize) {
        try{
            //1.从数据库查询所有文章封装到自定义文章对象中，返回所有文章集合，其中包含属性(文章id，文章标题，文章分类)
            PageHelper.startPage(pageNum,pageSize);
            List<ArticleCustomer> articleCustomers = articleMapper.selectCustomArticle();
            PageInfo<ArticleCustomer> pi = new PageInfo<>(articleCustomers);
            //2.从数据库查询所有文章所包含的标签
            for (ArticleCustomer articleCustomer :pi.getList()){
                //查询出文章的所有标签，放入自定义文章对象中
                String tagIds = articleCustomer.getArticleTagIds();
                int[] arrayTags = StringTool.stringToArray(tagIds);
                if (arrayTags !=null&&arrayTags.length>0) {
                    List<Tag> tags = tagMapper.selectTagsForArticle(arrayTags);
                    articleCustomer.setTagCustomList(tags);
                }
                //查询出文章的所有分类，放入自定义文章对象中
                int[] categoryIds = {articleCustomer.getArticleParentCategoryId(), articleCustomer.getArticleChildCategoryId()};
                if (categoryIds !=null&&categoryIds.length>0) {
                    List<Category> categories = categoryMapper.selectCategories(categoryIds);
                    articleCustomer.setCategoryCustomList(categories);
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
    public List<ArticleCustomer> getRecentArticle() {
        try {
            return articleMapper.selectCustomArticle();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ArticleCustomer getArticleById(int aid) {
        try {
            //1.根据传过来的文章id查询文章对象
            ArticleCustomer article = articleMapper.selectArticleById(aid);
            //查询出文章的所有标签，放入自定义文章对象中
            String tagIds = article.getArticleTagIds();
            int[] arrayTags = StringTool.stringToArray(tagIds);
            if (arrayTags !=null&&arrayTags.length>0) {
                List<Tag> tags = tagMapper.selectTagsForArticle(arrayTags);
                article.setTagCustomList(tags);
            }
            //查询出文章的所有分类，放入自定义文章对象中
            int[] categoryIds = {article.getArticleParentCategoryId(),article.getArticleChildCategoryId()};
            if (categoryIds !=null&&categoryIds.length>0) {
                List<Category> categories = categoryMapper.selectCategories(categoryIds);
                article.setCategoryCustomList(categories);
            }
            return article;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void updateArticle(Article article) {
        try {
            //修改文章信息，需要添加修改时间
            Date date = new Date();
            article.setArticleUpdateTime(date);
            articleMapper.updateArticle(article);
        }catch (Exception e){

        }
    }

    @Override
    public void saveNewArticle(Article article) {
        try {
            Date date = new Date();
            article.setArticlePostTime(date);
            article.setArticleUpdateTime(date);
            articleMapper.insertArticle(article);
        }catch (Exception e){
        }
    }
}
