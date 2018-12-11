package com.lk.service.impl;

import com.lk.mapper.TagMapper;
import com.lk.pojo.Tag;
import com.lk.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
