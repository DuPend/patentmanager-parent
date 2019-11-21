package com.xinghuo.controller;

import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbUserService;
import com.xinghuo.target.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;
    @RequestMapping("/logincheck")
    @Action(name = "注解式拦截的add操作")
    @ResponseBody
    public String loginCheckController(TbUser tbUser, HttpServletRequest httpServletRequest) {
        tbUser.setUserName("杜鹏");
        tbUser.setPassword("123456");
        tbUser.setRole(1);
        TbUser tempUser = tbUserService.showUserByNameService(tbUser.getUserName());
        System.out.println(tempUser);
        if (tempUser != null ) {
            if (tempUser.getUserName().equals(tbUser.getUserName()) && tempUser.getPassword().equals(tbUser.getPassword())
                    && tempUser.getRole() == tbUser.getRole()) {
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("user", tbUser);
                return "success";
            }
            else {
                return "false";
            }
        } else {
            return "false";
        }
    }
    @RequestMapping("/login")
    public String loginController(TbUser tbUser, HttpServletRequest httpServletRequest) {
        return "index.html";
    }
    @RequestMapping("/changePass")
    public String changePassword(TbUser tbUser, HttpServletRequest httpServletRequest) {
        int result = tbUserService.updateUserService(tbUser);
        if (result > 0) {
            return "success";
        } else {
            return "false";
        }
    }
}
