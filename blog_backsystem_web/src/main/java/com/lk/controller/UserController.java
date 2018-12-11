package com.lk.controller;

import com.lk.pojo.User;
import com.lk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/admin/user")
    public String getUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("userCustomList",users);
        return "Admin/User/index";
    }
    @RequestMapping("/admin/user/profile/{uid}")
    public String getMyporfile(Model model,@PathVariable int uid){
        User user = userService.getMyProfile(uid);
        model.addAttribute("userCustom",user);
        return "Admin/User/profile";
    }
}
