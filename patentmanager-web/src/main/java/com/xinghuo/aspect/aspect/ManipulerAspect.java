package com.xinghuo.aspect.aspect;

import com.xinghuo.service.TbLogService;
import com.xinghuo.target.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ManipulerAspect {

    @Autowired
    private TbLogService tbLogService;

    @Pointcut("@annotation(com.xinghuo.target.Action)")
    public void manipuler() {

    }
    /**
     * 前置通知：在连接点之前执行的通知
     */

    @After("manipuler()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 "+action.name());
    }

}

