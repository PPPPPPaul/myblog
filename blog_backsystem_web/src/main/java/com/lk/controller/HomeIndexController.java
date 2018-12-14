package com.lk.controller;

import com.lk.pojo.Link;
import com.lk.pojo.Notice;
import com.lk.service.ArticleService;
import com.lk.service.LinkService;
import com.lk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toIndex(Model model){
        List<Notice> notices = noticeService.selectNoticesList();
        List<Link> linksList = linkService.getLinksList();
        model.addAttribute("noticeCustomList",notices);
        model.addAttribute("linkCustomList",linksList);
        return "/Home/index";
    }

    @RequestMapping("")
    public String to(){
        return "";
    }
}
