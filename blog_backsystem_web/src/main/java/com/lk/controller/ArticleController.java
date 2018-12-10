package com.lk.controller;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.custom.CustomerArticle;
import com.lk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/admin/article")
    public String getFirstArticle(Model model, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        PageInfo<CustomerArticle> pageInfo = articleService.getAllArticle(pageNum,pageSize);
        model.addAttribute("pageinfo",pageInfo);
        return "Admin/Article/index";
    }
    /**
     * 点击全部文章从数据库拿取全部文章信息
     * @param model
     * @return
     */
}
