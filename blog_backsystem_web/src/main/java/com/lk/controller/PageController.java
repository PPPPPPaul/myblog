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
    public String toPage(){
        return "/Admin/login";
    }
}
