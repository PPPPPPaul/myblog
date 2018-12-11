package com.lk.service;

import com.lk.pojo.Tag;

import java.util.List;

public interface TagService {
    /**
     * 获取全部的标签数据
     * @return
     */
    List<Tag> getTagsList();
}
