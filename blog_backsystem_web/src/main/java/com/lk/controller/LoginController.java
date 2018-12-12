package com.lk.controller;

import com.lk.custom.result.YHResult;
import com.lk.pojo.User;
import com.lk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    /**
     * 用户登入
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/loginVerify")
    @ResponseBody
    public YHResult userVerify(User user, HttpServletRequest request){
        YHResult result = loginService.loginVerify(user);
        //将后台拿到的用户数据放入session域中
        User dbuser = (User) result.getData();
        HttpSession session = request.getSession();
        session.setAttribute("loginUser",dbuser);
        return result;
    }

    /**
     * 用户登出
     * @param request
     * @return
     */
    @RequestMapping("/admin/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        return "Admin/login";
    }
}