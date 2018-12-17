package com.lk.service;

import com.lk.pojo.Page;

import java.util.List;

public interface PageService {
    List<Page> getPages();
    Page getPageById(int pid);
    void deletePageById(int pid);
    void savePage(Page page);
    void insertPage(Page page);
}
