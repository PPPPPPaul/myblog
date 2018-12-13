package com.lk.service.impl;

import com.lk.mapper.TagMapper;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.TagCustom;
import com.lk.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> getTagsList() {
        try {
            return tagMapper.selectTags();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<TagCustom> getTagCustom() {
        try {
            //获取全部的标签
            List<Tag> tags = tagMapper.selectTags();
            if (tags!=null&&tags.size()>0){
                //定义一个新的集合存放后面带有文章总和的自定义标签
                List tagCustoms = new ArrayList();
                //遍历全部标签集合，通过标签id获取到自定义标签对象，每个自定义标签对象中放有该标签含有的文章总和
                for (Tag tag:tags){
                    //从遍历的标签中获取到标签id
                    Integer tid = tag.getTagId();
                    //根据标签id查询文章总和
                    TagCustom tagCustom = tagMapper.selectTagCustom(tid);
                    tagCustoms.add(tagCustom);
                }
                return tagCustoms;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Tag getTagById(int tid) {
        try {
            return tagMapper.selectTag(tid);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void addTag(Tag tag) {
        try {
            tagMapper.insertTag(tag);
        }catch (Exception e){}
    }

    @Override
    public void deleteTag(int tid) {
        try {
            tagMapper.deleteTagById(tid);
        }catch (Exception e){

        }
    }

    @Override
    public void updateTag(Tag tag) {
        try {
            tagMapper.updateTag(tag);
        }catch (Exception e){
        }
    }
}
