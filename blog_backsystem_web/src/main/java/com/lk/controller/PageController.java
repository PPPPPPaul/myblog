package com.lk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String toIndex(){
        return "/Home/index";
    }
    @RequestMapping("/admin")
    public String toAdmin(){
        return "/Admin/index";
    }
    @RequestMapping("/admin/login")
    public String toLogin(){
        return "/Admin/login";
    }
    @RequestMapping("/admin/article/{page}")
    public String toArticle(@PathVariable String page){
        return "/Admin/Article/"+page;
    }
    @RequestMapping("/admin/category")
    public String toCategoryIndex(){
        return "/Admin/Article/index";
    }
    @RequestMapping("/admin/category/{page}")
    public String toCategory(@PathVariable String page){
        return "/Admin/Category/"+page;
    }
    @RequestMapping("/admin/tag")
    public String toTagIndex(){
        return "/Admin/Article/index";
    }
    @RequestMapping("/admin/tag/{page}")
    public String toTag(@PathVariable String page){
        return "/Admin/Tag/"+page;
    }
}