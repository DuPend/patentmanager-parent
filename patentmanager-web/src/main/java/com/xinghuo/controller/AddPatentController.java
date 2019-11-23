package com.xinghuo.controller;

import com.xinghuo.pojo.Result;
import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.TbIndicatorService;
import com.xinghuo.service.TbPlanService;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;



@RestController
@RequestMapping("/patent")
public class AddPatentController {

    @Autowired UserPatentService userPatentService;
    @Autowired TbIndicatorService tbIndicatorService;
    @Autowired TbPlanService tbPlanService;

    //添加专利
    @PostMapping("/addPatentIndicator")
    public Result addPatentIndicator(@RequestBody TbPatent tbPatent, HttpServletRequest httpServletRequest){
        /**
         * @Description: 新建专利
         * @Author: LiuJian
         * @Date: 2019/11/22 0022 11:47
         * @Param: [patent]
         * @Return: com.xinghuo.entity.Result
         */
        Result result = new Result(false,null);
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前登录用户的id
        String id =(String) httpSession.getAttribute("id");
        try{
            //查询专利名是否已存在
            TbPatent existPatent = userPatentService.findPatentByName(tbPatent.getPatentName());
            if(existPatent!=null){
                result.setMessage("专利名已存在");
            }else{
                //新增专利的进程默认为待审核
                tbPatent.setPlanId(tbPlanService.findPlanByContent("待审核"));
                //申请日期为当前日期
                tbPatent.setProposeDate(new Date());
                //添加创建人id
                tbPatent.setCreatorId(Integer.valueOf(id));
                //添加专利
                userPatentService.addPatent(tbPatent);
                //根据已添加的专利id查询专利信息id
                TbPatent existPatent1 = userPatentService.findPatentByName(tbPatent.getPatentName());

                //添加指标
                for (String ind:tbPatent.getIndDetails()) {
                    TbIndicator tbIndicator = new TbIndicator();
                    //将专利id设置到指标属性里
                    tbIndicator.setPatentId(existPatent1.getPatentId());
                    //将专利内容添加到指标属性
                    tbIndicator.setIndDetails(ind);
                    tbIndicatorService.addIndicator(tbIndicator);
                }
                result.setMessage("添加成功");
                result.setSuccess(true);
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
