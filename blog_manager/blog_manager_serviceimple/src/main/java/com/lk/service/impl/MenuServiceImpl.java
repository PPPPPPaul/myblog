package com.lk.service.impl;

import com.lk.mapper.MenuMapper;
import com.lk.pojo.Menu;
import com.lk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getMenuList() {
        return menuMapper.selectMeunsList();
    }

    @Override
    public Menu getMenuById(int mid) {
        return menuMapper.selectByPrimaryKey(mid);
    }

    @Override
    public void deleteMenuById(int mid) {
        menuMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void addMenu(Menu menu) {
        menuMapper.insertSelective(menu);
    }

}
