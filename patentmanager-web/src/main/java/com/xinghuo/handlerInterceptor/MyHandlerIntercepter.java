package com.xinghuo.handlerInterceptor;//package com.xinghuo.handlerInterceptor;
//
//import com.sun.istack.internal.Nullable;
//import com.xinghuo.pojo.TbUser;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Component
//public class MyHandlerIntercepter implements HandlerInterceptor {
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        HttpSession session = request.getSession();
//        TbUser user = (TbUser) session.getAttribute("user");
//        if(user != null){
//            return true;
//        }else {
//            return false;
//        }
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//
//    }
//}
