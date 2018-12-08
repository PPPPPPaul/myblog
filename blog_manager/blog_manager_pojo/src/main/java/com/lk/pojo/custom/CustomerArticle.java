package com.lk.pojo.custom;

import com.lk.pojo.Article;
import com.lk.pojo.Tag;

import java.io.Serializable;
import java.util.List;

public class CustomerArticle extends Article implements Serializable {
    private String category_parent_name;
    private String category_child_name;
    private List<Tag> tags;

    public String getCategory_parent_name() {
        return category_parent_name;
    }

    public void setCategory_parent_name(String category_parent_name) {
        this.category_parent_name = category_parent_name;
    }

    public String getCategory_child_name() {
        return category_child_name;
    }

    public void setCategory_child_name(String category_child_name) {
        this.category_child_name = category_child_name;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
