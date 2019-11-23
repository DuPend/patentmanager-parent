package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.PageInfo;
import com.xinghuo.pojo.TbIndicatorExcend;
import com.xinghuo.service.TbIndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description: 专利指标控制层
 * @author: dupeng
 * @date: 2019-11-20 17:24:42
 * @version: V1.0
 */
@RestController
@RequestMapping("/indicator")
public class TbIndicatorController {

    @Autowired
    private TbIndicatorService tbIndicatorService;

    /**
     * 管理员指标查询
     * @return
     */
    @GetMapping("/findAll")
    public PageInfo<TbIndicatorExcend> findAll(
            @RequestParam(defaultValue = "1",value = "currentPage")int page,
            @RequestParam(defaultValue = "10",value = "pageSize")int rows){
        Page<TbIndicatorExcend> indicatorList = tbIndicatorService.findAll(page,rows);
        PageInfo<TbIndicatorExcend> pageInfo = new PageInfo<>(indicatorList);
        return  pageInfo;
    }


    /**
     * 管理员专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    @GetMapping ("/findTerm")
    public PageInfo<TbIndicatorExcend> findTerm(TbIndicatorExcend tbIndicatorExcend,
                                            @RequestParam(defaultValue = "1",value = "currentPage")Integer page,
                                            @RequestParam(defaultValue = "10",value = "pageSize") Integer rows ){
        Page<TbIndicatorExcend> indicatorList = tbIndicatorService.findTerm(tbIndicatorExcend, page, rows);
        PageInfo<TbIndicatorExcend> pageInfo = new PageInfo<>(indicatorList);
        return  pageInfo;
    }


    /**
     * 用户指标查询
     * @return
     */
    @GetMapping("/findUserAll")
    public PageInfo<TbIndicatorExcend> findUserAll(
            @RequestParam(defaultValue = "1",value = "currentPage")int page,
            @RequestParam(defaultValue = "10",value = "pageSize")int rows){
        Page<TbIndicatorExcend> indicatorList = tbIndicatorService.findUserAll(page,rows);
        PageInfo<TbIndicatorExcend> pageInfo = new PageInfo<>(indicatorList);
        return  pageInfo;
    }


    /**
     * 用户专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    @GetMapping ("/findUserTerm")
    public PageInfo<TbIndicatorExcend> findUserTerm(TbIndicatorExcend tbIndicatorExcend,
                                                @RequestParam(defaultValue = "1",value = "currentPage")Integer page,
                                                @RequestParam(defaultValue = "10",value = "pageSize") Integer rows ){
        Page<TbIndicatorExcend> indicatorList = tbIndicatorService.findUserTerm(tbIndicatorExcend, page, rows);
        PageInfo<TbIndicatorExcend> pageInfo = new PageInfo<>(indicatorList);
        return  pageInfo;
    }



}
