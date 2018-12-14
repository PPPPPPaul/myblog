package com.lk.service.impl;

import com.lk.mapper.LinkMapper;
import com.lk.pojo.Link;
import com.lk.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<Link> getLinksList() {
        return linkMapper.selectLinkList();
    }

    @Override
    public Link getLinkById(int lid) {
        return linkMapper.selectByPrimaryKey(lid);
    }

    @Override
    public void editLink(Link link) {
        Date date = new Date();
        link.setLinkUpdateTime(date);
        linkMapper.updateByPrimaryKeySelective(link);
    }

    @Override
    public void deleteLinkById(int lid) {
        linkMapper.deleteByPrimaryKey(lid);
    }

    @Override
    public void addLink(Link link) {
        Date date = new Date();
        link.setLinkCreateTime(date);
        link.setLinkUpdateTime(date);
        link.setLinkStatus(1);
        linkMapper.insertSelective(link);
    }
}
