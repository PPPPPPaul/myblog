package com.lk.mapper;

import com.lk.pojo.Tag;
import com.lk.pojo.custom.TagCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    /**
     * 获取全部的标签
     *
     * @return
     */
    List<Tag> selectTags();

    /**
     * 根据标签id获取一个标签对象
     * @param tid
     * @return
     */

    Tag selectTag(int tid);
    /**
     * 根据文章信息中的多个标签id查询全部标签信息
     *
     * @param tid
     * @return
     */
    List<Tag> selectTagsForArticle(int[] tid);

    /**
     * 遍历全部标签，然后通过这个mapper一个一个根据标签id查找自定义标签对象
     * @param tagId
     * @return
     */
    TagCustom selectTagCustom(@Param("tagId") Integer tagId);

    /**
     * 插入新的标签
     * @param tag
     */
    void insertTag(Tag tag);

    /**
     * 根据标签id删除标签
     * @param tid
     */
    void deleteTagById(int tid);

    /**
     * 保存编辑的标签信息
     * @param tag
     */
    void updateTag(Tag tag);
}