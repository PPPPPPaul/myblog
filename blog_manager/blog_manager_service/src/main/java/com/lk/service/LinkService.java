package com.lk.service;

import com.lk.pojo.Link;

import java.util.List;

public interface LinkService {
    List<Link> getLinksList();
    Link getLinkById(int lid);
    void editLink(Link link);
    void deleteLinkById(int lid);
    void addLink(Link link);
}
