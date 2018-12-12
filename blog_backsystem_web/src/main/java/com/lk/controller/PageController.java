package com.lk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String toIndex(){
        return "/Home/index";
    }
    @RequestMapping("/admin/article/{page}")
    public String toArticle(){
        return "/Admin/Article/{page}";
    }
    @RequestMapping("/admin/login")
    public String toLogin(){
        return "/Admin/login";
    }
}