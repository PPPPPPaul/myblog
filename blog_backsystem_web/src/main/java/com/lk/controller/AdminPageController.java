package com.lk.controller;

import com.lk.pojo.Page;
import com.lk.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminPageController {
    @Autowired
    private PageService pageService;
    @RequestMapping("/admin/page")
    public String getPages(Model model){
        List<Page> pages = pageService.getPages();
        model.addAttribute("pageCustomList",pages);
        return "Admin/Page/index";
    }
    @RequestMapping("/admin/page/edit/{pageId}")
    public String getPage(Model model,@PathVariable int pageId){
        Page pageById = pageService.getPageById(pageId);
        model.addAttribute("pageCustom",pageById);
        return "Admin/Page/edit";
    }
    @RequestMapping("/admin/page/editSubmit")
    public String savePage(Page page){
        pageService.savePage(page);
        return "forward:/admin/page";
    }
    @RequestMapping("/admin/page/delete/{pageId}")
    public String deletePageById(@PathVariable int pageId){
        pageService.deletePageById(pageId);
        return "forward:/admin/page";
    }
    @RequestMapping("/admin/page/insertSubmit")
    public String addPage(Page page){
        pageService.insertPage(page);
        return "forward:/admin/page";
    }
}