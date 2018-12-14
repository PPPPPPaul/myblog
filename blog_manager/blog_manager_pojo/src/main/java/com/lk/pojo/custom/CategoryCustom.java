package com.lk.pojo.custom;

import com.lk.pojo.Category;

import java.io.Serializable;

public class CategoryCustom extends Category implements Serializable {
    private int articleCount;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
}
