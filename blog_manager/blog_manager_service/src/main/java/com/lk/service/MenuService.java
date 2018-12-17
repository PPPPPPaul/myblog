package com.lk.service;

import com.lk.pojo.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList();
    Menu getMenuById(int mid);
    void deleteMenuById(int mid);
    void saveMenu(Menu menu);
    void addMenu(Menu menu);
}
