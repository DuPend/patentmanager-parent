package com.xinghuo.controller;

import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbUserService;
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
    @ResponseBody
    public String loginCheckController(TbUser tbUser, HttpServletRequest httpServletRequest) {
        tbUser.setUserName("admin");
        tbUser.setPassword("admin");
        tbUser.setRole(0);
        TbUser tempUser = tbUserService.showUserByNameService(tbUser.getUserName());
        if (tbUser != null && tempUser.getUserName().equals(tbUser.getUserName())
                && tempUser.getPassword().equals(tbUser.getPassword())) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", tbUser);
            return "success";
        } else {
            return "redirect:/login";
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
