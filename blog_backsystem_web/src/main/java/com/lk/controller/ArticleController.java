package com.lk.controller;

import com.lk.pojo.custom.CustomerArticle;
import com.lk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/admin/article")
    public String getAllArticle(Model model){
        List<CustomerArticle> allArticle = articleService.getAllArticle();
        model.addAttribute("publishedArticleListVoList",allArticle);
        return "/Admin/Article/index";
    }
}
