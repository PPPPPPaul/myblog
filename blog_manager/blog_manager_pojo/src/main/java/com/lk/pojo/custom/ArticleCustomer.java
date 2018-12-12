package com.lk.pojo.custom;

import com.lk.pojo.Article;
import com.lk.pojo.Category;
import com.lk.pojo.Tag;

import java.io.Serializable;
import java.util.List;

public class ArticleCustomer extends Article implements Serializable {
    private List<Category> categoryCustomList;
    private List<Tag> tagCustomList;

    public List<Category> getCategoryCustomList() {
        return categoryCustomList;
    }

    public void setCategoryCustomList(List<Category> categoryCustomList) {
        this.categoryCustomList = categoryCustomList;
    }

    public List<Tag> getTagCustomList() {
        return tagCustomList;
    }

    public void setTagCustomList(List<Tag> tagCustomList) {
        this.tagCustomList = tagCustomList;
    }
}
