package com.xinghuo.controller;

import com.xinghuo.pojo.DataCount;
import com.xinghuo.service.TbDataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 数据统计控制层
 * @author: 杜鹏
 * @date: 2019-11-22 21:36:24
 * @version: V1.0
 */
@RestController
@RequestMapping("/data")
public class TbDataCountController {
    @Autowired
    private TbDataCountService dataCountService;

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:33
     */
    @RequestMapping("/findDataCount")
    public DataCount findDataCount(){
        return dataCountService.findDataCount();
    }

}
