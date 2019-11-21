package com.xinghuo.controller;

import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mypatent
 * @description: 个人专利控制层
 * @author: Yuyue
 * @create: 2019-11-20 19:23
 **/
@RestController
public class UserPatentController {

    @Autowired UserPatentService userPatentService;
    /**
     * /查询当前用户的专利基本信息
     * @param userId  用户id
     * @return  用户所有被认领的专利
     */
    @RequestMapping("/UserPatent")
    public List<TbPatent> getPatentByUser(Integer userId){
        System.out.println(userPatentService.getPatentByUser(userId).toString()+"oooocsvcvdsfcasvsz");
        return userPatentService.getPatentByUser(userId);
    }

    /**
     * 查询专利详情
     * @param patentId  专利id
     * @return  专利详情
     */
    @RequestMapping("/PatentDetail")
    public TbPatent getPatentById(Integer patentId){
        System.out.println("dasdasadad"+userPatentService.getPatentById(patentId).toString());
        return userPatentService.getPatentById(patentId);
    }

    /**
     * 接口解析没有完成，返回值没有完成
     * @return
     */
    @RequestMapping("/updatePatent")
    public boolean updatePatentById(){
        TbPatent tb=new TbPatent();
        tb.setPatentId(1);
        tb.setBatch("第3批");
        tb.setRemark("啦啦啦啦啦");
        TbIndicator ind=new TbIndicator();
        ind.setIndDetails("体重指标不超过180");
        ind.setPatentId(1);
        List<TbIndicator> indicators= new ArrayList<>();
        indicators.add(ind);
        tb.setTbIndicators(indicators);
            userPatentService.updatePatentById(tb);
            return false;
    }

    /**
     *  查询当前用户当前专利的历史进程
     * @param patentId 专利id
     * @return 专利进程
     */
   /* public List<TbFlow> getPatentFlow(Integer patentId){
        return userPatentService.getPatentFlow(patentId);
    }*/

    //文件显示，当前专利每一类别的文件的最新版
}
