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
    @RequestMapping("/loginVerify")
    @ResponseBody
    public YHResult userVerify(User user, HttpServletRequest request){
        YHResult result = loginService.loginVerify(user);
        User dbuser = (User) result.getData();
        HttpSession session = request.getSession();
        session.setAttribute("username",dbuser.getUserName());
        session.setAttribute("loginUser",dbuser);
        return result;
    }
}