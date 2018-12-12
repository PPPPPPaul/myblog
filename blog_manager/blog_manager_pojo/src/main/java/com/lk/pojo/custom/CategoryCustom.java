package com.lk.pojo.custom;

import com.lk.pojo.Category;

public class CategoryCustom extends Category {
    private int articleCount;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
}
