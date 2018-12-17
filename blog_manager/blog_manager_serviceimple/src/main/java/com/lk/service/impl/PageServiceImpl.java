package com.lk.service.impl;

import com.lk.mapper.PageMapper;
import com.lk.pojo.Page;
import com.lk.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageMapper pageMapper;
    @Override
    public List<Page> getPages() {
        return pageMapper.selectPages();
    }

    @Override
    public Page getPageById(int pid) {
        return pageMapper.selectByPrimaryKey(pid);
    }

    @Override
    public void deletePageById(int pid) {
        pageMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public void savePage(Page page) {
        pageMapper.updateByPrimaryKeyWithBLOBs(page);
    }

    @Override
    public void insertPage(Page page) {
        pageMapper.insertSelective(page);
    }
}
