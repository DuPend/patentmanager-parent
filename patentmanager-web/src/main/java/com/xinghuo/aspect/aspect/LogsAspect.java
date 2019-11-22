package com.xinghuo.aspect.aspect;

import com.xinghuo.common.utils.FileUtil;
import com.xinghuo.pojo.TbLog;
import com.xinghuo.service.TbLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

//@Aspect
@Component
public class LogsAspect {

    private final String  filePath = "E:/file";
    @Autowired
    private TbLogService tbLogService;
    /*
    定义切点，切入点为com.xinghuo.controller下的所有函数
     */
    @Pointcut("execution(public * com.xinghuo.controller..*.*(..))")
    public void webLog() {

    }
    /**
     * 前置通知：在连接点之前执行的通知
     */

    @After("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取当前登陆的用户名和时间
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");
        // 记录下请求内容,首先获取当前日期的log日志文件名称并查询数据库是否存在文件
//        userName != null
        if (true) { //用户登陆成功，执行日志记录
            //不存在
            String fileName = FileUtil.getFileName();
            TbLog tbLog = tbLogService.selectLogByNameService(fileName);
            System.out.println(tbLog);
            if (tbLog == null) {
                tbLog = new TbLog();
                tbLog.setLogName(fileName);
                tbLog.setLogAddress(filePath);
                tbLogService.addLogService(tbLog);
            }

            File file = FileUtil.createFile(fileName);
            String url = request.getRequestURL().toString();
            String httpMethod = request.getMethod();
            String classMethod = joinPoint.getSignature().
                    getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());
            String message = "访问路径:" + url + ";访问方式:" + httpMethod + ";访问的方法:"
                    + classMethod + ";传递的参数为:" + args + ":当前登陆用户为(" + userName + ")" + new Date();
            FileUtil.appendMethod(filePath + "/" + fileName, message);
        }

    }

}

