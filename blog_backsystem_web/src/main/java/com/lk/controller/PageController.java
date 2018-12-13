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


    /*
    * 后台页面跳转
    * */
    @RequestMapping("/admin/article/{page}")
    public String toAdminArticle(){
        return "/Admin/Article/{page}";
    }
    @RequestMapping("/admin/login")
    public String toLogin(){
        return "/Admin/login";
    }
}