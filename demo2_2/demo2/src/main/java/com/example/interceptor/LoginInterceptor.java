package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//具体拦截暂未增加::::://
//具体拦截暂未增加::::://
//具体拦截暂未增加:::::////具体拦截暂未增加::::://
//具体拦截暂未增加::::://
//具体拦截暂未增加::::://
//具体拦截暂未增加::::://
//具体拦截暂未增加::::://
//具体拦截暂未增加::::://
//具体拦截暂未增加::::://


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Object obj=request.getSession().getAttribute("userId");
        if(obj==null){
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}
