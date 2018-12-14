package com.lk.pojo.custom;

import com.lk.pojo.Tag;

import java.io.Serializable;

public class TagCustom extends Tag implements Serializable {
    private int articleCount;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
}
