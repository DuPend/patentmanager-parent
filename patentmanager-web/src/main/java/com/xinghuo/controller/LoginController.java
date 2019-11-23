package com.xinghuo.controller;

import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;
    @RequestMapping("/logincheck")
    @ResponseBody
    public TbUser loginCheckController(@RequestBody TbUser tbUser) {
        TbUser tempUser = tbUserService.showUserByNameService(tbUser.getUserName());
        System.out.println(tempUser);
        if (tempUser != null ) {
            if (tempUser.getUserName().equals(tbUser.getUserName()) && tempUser.getPassword().equals(tbUser.getPassword())
                    && tempUser.getRole() == tbUser.getRole()) {
                return tbUser;
            }
            else {
                return null;
            }
        } else {
            return null;
        }
    }
    @RequestMapping("/login")
    public String loginController(@RequestBody TbUser tbUser) {
        return "index.html";
    }
    @RequestMapping("/changePass")
    @ResponseBody
    public String changePassword(@RequestBody TbUser tbUser) {
        int result = tbUserService.updateUserService(tbUser);
        if (result > 0) {
            return "success";
        } else {
            return "false";
        }
    }
}
