package com.lk.mapper;

import com.lk.pojo.Link;

import java.util.List;

public interface LinkMapper {
    int deleteByPrimaryKey(Integer linkId);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Integer linkId);

    List<Link> selectLinkList();

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
}