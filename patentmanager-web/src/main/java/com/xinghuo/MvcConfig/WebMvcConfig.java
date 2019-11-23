package com.xinghuo.MvcConfig;//package com.xinghuo.MvcConfig;
//
//import com.xinghuo.handlerInterceptor.MyHandlerIntercepter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//
//    @Autowired
//    MyHandlerIntercepter myHandlerIntercepter;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myHandlerIntercepter).addPathPatterns("/**");
//    }
//
//}
