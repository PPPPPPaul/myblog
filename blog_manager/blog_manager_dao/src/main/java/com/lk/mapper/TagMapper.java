package com.lk.mapper;

import com.lk.pojo.Tag;

import java.util.List;

public interface TagMapper {
    /**
     * 获取全部的标签
     * @return
     */
    List<Tag> selectTags();
    /**
     * 根据标签id查询全部标签信息
     * @param tid
     * @return
     */
    List<Tag> selectTagsForArticle(int[] tid);

}
