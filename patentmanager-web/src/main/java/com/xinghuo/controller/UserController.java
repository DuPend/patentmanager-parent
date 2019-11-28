package com.xinghuo.controller;

import com.xinghuo.service.TbIndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-28 15:06
 * @version: V1.0
 */

@RestController
public class UserController {
    @Autowired
    private TbIndicatorService tbIndicatorService;

}
