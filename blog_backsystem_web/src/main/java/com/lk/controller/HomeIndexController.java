package com.lk.controller;

import com.github.pagehelper.PageInfo;
import com.lk.pojo.Link;
import com.lk.pojo.Notice;
import com.lk.pojo.custom.ArticleCustomer;
import com.lk.service.ArticleService;
import com.lk.service.LinkService;
import com.lk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeIndexController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private LinkService linkService;

    @RequestMapping("/")
    public String toIndex(Model model,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<ArticleCustomer> articles = articleService.getAllArticle(pageNum, pageSize);
        List<Notice> notices = noticeService.selectNoticesList();
        List<Link> linksList = linkService.getLinksList();
        model.addAttribute("noticeCustomList",notices);
        model.addAttribute("linkCustomList",linksList);
        model.addAttribute("pi",articles);
        return "/Home/index";
    }

    @RequestMapping("")
    public String to(){
        return "";
    }
}
