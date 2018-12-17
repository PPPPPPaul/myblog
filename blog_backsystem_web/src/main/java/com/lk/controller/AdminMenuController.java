package com.lk.controller;

import com.lk.pojo.Menu;
import com.lk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminMenuController {

    @Autowired
    private MenuService menuService;
    @RequestMapping("/admin/menu")
    public String getMenusList(Model model){
        List<Menu> menuList = menuService.getMenuList();
        model.addAttribute("menuCustomList",menuList);
        return "Admin/Menu/index";
    }

    @RequestMapping("/admin/menu/edit/{menuId}")
    public String getMenuById(Model model, @PathVariable int menuId){
        Menu menuById = menuService.getMenuById(menuId);
        model.addAttribute("menuCustom",menuById);
        return "Admin/Menu/edit";
    }

    @RequestMapping("/admin/menu/delete/{menuId}")
    public String deleteMenuById(@PathVariable int menuId){
        menuService.deleteMenuById(menuId);
        return "forward:/admin/menu";
    }


    @RequestMapping("/admin/menu/editSubmit")
    public String saveMenu(Menu menu){
        menuService.saveMenu(menu);
        return "forward:/admin/menu";
    }
    @RequestMapping("/admin/menu/insertSubmit")
    public String addMenu(Menu menu){
        menuService.addMenu(menu);
        return "forward:/admin/menu";
    }

}
