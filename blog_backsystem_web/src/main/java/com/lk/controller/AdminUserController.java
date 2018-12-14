package com.lk.controller;

import com.lk.pojo.User;
import com.lk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到用户中心管理
     * @param model
     * @return
     */
    @RequestMapping("/admin/user")
    public String getUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("userCustomList",users);
        return "Admin/User/index";
    }

    /**
     * 获取到用户的基本资料
     * @param model
     * @param path
     * @param uid
     * @return
     */
    @RequestMapping("/admin/user/{path}/{uid}")
    public String getMyporfile(Model model,@PathVariable String path,@PathVariable int uid){
        User user = userService.getMyProfile(uid);
        model.addAttribute("userCustom",user);
        return "Admin/User/"+path;
    }

    /**
     * 编辑更新用户信息
     * @param model
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/admin/user/editSubmit")
    public String editUser(Model model,User user, HttpServletRequest request){
        User editUser = userService.editUser(user);
        //将返回的新用户登陆信息放入session中
        HttpSession session = request.getSession();
        session.setAttribute("loginUser",editUser);
        //返回到基本资料页面需要在放一份数据到model中
        model.addAttribute("userCustom",editUser);
        return "Admin/User/profile";
    }
}
