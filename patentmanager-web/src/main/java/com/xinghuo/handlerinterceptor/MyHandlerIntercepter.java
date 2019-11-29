package com.xinghuo.handlerinterceptor;


import com.xinghuo.pojo.TbUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyHandlerIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user=request.getSession().getAttribute("user");
        if (user != null) {
            System.out.println("未被拦截");
            return true;
        } else {
            System.out.println("已被拦截");
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,  ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler,  Exception ex) throws Exception {

    }
}
