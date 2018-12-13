package com.lk.service;

import com.lk.pojo.Tag;
import com.lk.pojo.custom.TagCustom;

import java.util.List;

public interface TagService {
    /**
     * 获取全部的标签数据
     * @return
     */
    List<Tag> getTagsList();

    /**
     * 获取自定义标签集合
     * @return
     */
    List<TagCustom> getTagCustom();

    /**
     * 根据标签id查出自定义标签
     * @return
     */
    Tag getTagById(int tid);

    /**
     * 添加标签
     * @param tag
     */
    void addTag(Tag tag);
    /**
     * 根据标签id删除标签
     * @param tid
     */
    void deleteTag(int tid);

    /**
     * 保存编辑的标签信息
     */
    void updateTag(Tag tag);
}
