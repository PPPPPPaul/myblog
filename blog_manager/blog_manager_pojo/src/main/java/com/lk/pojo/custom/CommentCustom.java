package com.lk.pojo.custom;

import com.lk.pojo.Article;
import com.lk.pojo.Comment;
import com.lk.pojo.User;

import java.io.Serializable;

public class CommentCustom extends Comment implements Serializable {
    private Article article;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
