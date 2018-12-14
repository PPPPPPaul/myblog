package com.lk.controller;

import com.lk.pojo.Notice;
import com.lk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/admin/notice")
    public String getNoticeList(Model model){
        List<Notice> notices = noticeService.selectNoticesList();
        model.addAttribute("noticeCustomList",notices);
        return "Admin/Notice/index";
    }


    @RequestMapping("/admin/notice/delete/{noticeId}")
    public String deleteNoticeById(@PathVariable int noticeId){
        noticeService.deleteNoticeById(noticeId);
        return "forward:/admin/notice";
    }


    @RequestMapping("/admin/notice/edit/{noticeId}")
    public String getNoticeById(Model model,@PathVariable int noticeId){
        Notice notice = noticeService.selectNoticeById(noticeId);
        model.addAttribute("noticeCustom",notice);
        return "Admin/Notice/edit";
    }

    @RequestMapping("/admin/notice/editSubmit")
    public String saveNoticeById(Notice notice){
        noticeService.updateNotice(notice);
        return "forward:/admin/notice";
    }


    @RequestMapping("/admin/notice/insertSubmit")
    public String addNotice(Notice notice){
        noticeService.insertNotice(notice);
        return "forward:/admin/notice";
    }
}