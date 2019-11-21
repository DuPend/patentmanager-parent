package com.xinghuo.controller;

import com.xinghuo.pojo.Dept;
import com.xinghuo.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-20 17:24
 * @version: V1.0
 */

@RestController
@RequestMapping("/dept")
public class IndicatorController {

    @Autowired
    private IndicatorService indicatorService;

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public List<Dept> list(){

        return indicatorService.list();
    }

}
