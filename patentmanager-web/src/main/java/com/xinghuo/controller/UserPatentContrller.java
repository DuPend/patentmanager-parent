package com.xinghuo.controller;

import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.SearchService;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户专利
 */
@RestController
public class UserPatentContrller {
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
    public List<TbPatent> detailIndex(Integer id){
        List<TbPatent> list = userPatentService.findDetail(id);
        return list;
    }

    //条件查询
    @RequestMapping("/search")
    public List<TbPatent> searchIndex(TbPatent patent){
        List<TbPatent> list = searchService.findCondition(patent);
        return list;
    }

}
