package com.xinghuo.controller;

import com.xinghuo.pojo.TbFlow;
import com.xinghuo.service.TbFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:41
 * @version: V1.0
 */
@RestController
public class TbFlowController {
    //注入TbFlowService层
    @Autowired
    private TbFlowService tbFlowService;
    //查询所有的操作日志
    @RequestMapping("/showTbFlow")
//    @Action(name = "add")
    List<TbFlow> showTbFlowController() {
        System.out.println(tbFlowService.showTbFlowService());
        return  tbFlowService.showTbFlowService();
    }
    //根据专利ID查询操作日志
    @RequestMapping("/showTbFlowById")
    List<TbFlow> showTbFlowByIdController(HttpServletRequest httpServletRequest) {
        return tbFlowService.showTbFlowByIdService(Integer.valueOf((String)httpServletRequest.getParameter("patentId")));
    }
}