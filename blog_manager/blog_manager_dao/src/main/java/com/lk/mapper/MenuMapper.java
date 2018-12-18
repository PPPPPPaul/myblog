package com.lk.mapper;

import com.lk.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    List<Menu> selectMeunsList();

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}