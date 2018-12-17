package com.lk.controller;

import com.lk.pojo.Options;
import com.lk.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminOptionController {
    @Autowired
    private OptionService optionService;
    @RequestMapping("/admin/options")
    public String getOptions(Model model){
        Options options = optionService.getOptions();
        model.addAttribute("optionCustom",options);
        return "Admin/Options/index";
    }
    @RequestMapping("/admin/options/editSubmit")
    public String saveOptions(Options options){
        optionService.saveOptions(options);
        return "forward:/admin/options";
    }
}
