package com.xinghuo.controller;

import com.xinghuo.pojo.TbPatent;

import com.xinghuo.service.SearchService;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author:段炼 on 2019/11/22 17:36
 *@param:
 *@return:
 *@description:专利的各种查询
 */
@RestController
public class UserPatentController {
    @Autowired
    private UserPatentService userPatentService;

    @Autowired
    private SearchService searchService;

    //所有专利
    @RequestMapping("/findAll")
    public List<TbPatent> index(){

        List<TbPatent> list = userPatentService.findAll();
        return list;
    }

    //某专利的详细信息
    @RequestMapping("/findDetail")
    public List<TbPatent> findDetail(Integer id){
        List<TbPatent> list = userPatentService.findDetail(id);
        return list;
    }

    //条件查询
    @RequestMapping("/findCondition")
    public List<TbPatent> findCondition(TbPatent patent){
        List<TbPatent> list = searchService.findCondition(patent);
        return list;
    }

    //认领状态  已完成
    @RequestMapping("/updateCondition")
    public String update(Integer id) {
        int result = userPatentService.update(id);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }
}
