package com.lk.controller;

import com.lk.pojo.Link;
import com.lk.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminLinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/admin/link")
    public String getLinksList(Model model){
        List<Link> linksList = linkService.getLinksList();
        model.addAttribute("linkCustomList",linksList);
        return "Admin/Link/index";
    }


    @RequestMapping("/admin/link/edit/{linkId}")
    public String getLink(Model model,@PathVariable int linkId){
        Link linkById = linkService.getLinkById(linkId);
        List<Link> linksList = linkService.getLinksList();
        model.addAttribute("linkCustom",linkById);
        model.addAttribute("linkCustomList",linksList);
        return "Admin/Link/edit";
    }

    @RequestMapping("/admin/link/editSubmit")
    public String editLink(Link link){
        linkService.editLink(link);
        return "forward:/admin/link";
    }

    @RequestMapping("/admin/link/delete/{linkId}")
    public String deleteLink(@PathVariable int linkId){
        linkService.deleteLinkById(linkId);
        return "forward:/admin/link";
    }


    @RequestMapping("/admin/link/insertSubmit")
    public String addLink(Link link){
        linkService.addLink(link);
        return "forward:/admin/link";
    }

}
