package com.lk.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 未登录不得访问内部页面的拦截器
 */
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求地址
        String uri = request.getRequestURI();
        //请求地址包含login则为登陆界面
        if(uri.indexOf("login")>=0){
            return true;
        }
        //否则请求不是登陆界面，需要查看session中是否有登录用户信息
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");
        if (user!=null){
            return true;
        }
        //没有用户信息则请求转发至登陆界面
        request.getRequestDispatcher("/WEB-INF/view/Admin/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
