package com.lk.mapper;

import com.lk.pojo.Options;

import java.util.List;

public interface OptionsMapper {
    int deleteByPrimaryKey(Integer optionId);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Integer optionId);

    Options selectOptions();

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}