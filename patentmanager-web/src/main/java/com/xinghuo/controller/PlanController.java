package com.xinghuo.controller;

import com.xinghuo.pojo.Result;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.TbPlanService;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:管理员审核专利
 * @Author: LiuJian
 * @Date: 2019/11/21 0021 17:24
 * @Version: V1.0
 */
@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired UserPatentService userPatentService;

    @Autowired TbPlanService planService;

    //根据进度内容查询进度id
    public Integer selectPlanId(String planContent){
        /**
         * @Description:根据进度内容查询进度id
         * @Author: LiuJian
         * @Date: 2019/11/22 0022 10:51
         * @Param: [planContent]
         * @Return: java.lang.Integer
         */
        return planService.findPlanByContent(planContent);
    }

    //审核专利
    @RequestMapping("/checkPatent")
    public Result checkPatent(Integer patentId,Integer flag){
       /**
        * @Description: 管理员对专利各个阶段的审核
        * @Author: LiuJian
        * @Date: 2019/11/22 0022 11:29
        * @Param: [patentId, flag]
        * @Return: com.xinghuo.entity.Result
        */
        Result result = new Result(false,null);
        //根据专利id查询专利信息
        TbPatent tbPatent = userPatentService.findPatentById(patentId);
        //查询当前专利的进度id
        int planId = tbPatent.getPlanId();

        //判断是否通过
        try{
            //新建专利后的审核
            if(planId==selectPlanId("待审核")){
                //flag==0时为通过
                if (flag==0){
                    //查询进度Id并设置在专利属性中
                    tbPatent.setPlanId(selectPlanId("待认领"));
                    result.setMessage("通过");
                }else {
                    tbPatent.setPlanId(selectPlanId("未通过"));
                    result.setMessage("未通过");
                }
            }

            //提交撰写书申请书后的初审
            if(planId==selectPlanId("待初审")){
                //flag==0时为通过
                if (flag==0){
                    //查询进度Id并设置在专利属性中
                    tbPatent.setPlanId(selectPlanId("公布及进入实审"));
                    result.setMessage("通过");
                }else {
                    tbPatent.setPlanId(selectPlanId("申请文件撰写中"));
                    result.setMessage("未通过");
                }
            }

            //最后的实审
            if(planId==selectPlanId("公布及进入实审")){
                //flag==0时为通过
                if (flag==0){
                    //查询进度Id并设置在专利属性中
                    tbPatent.setPlanId(selectPlanId("审查意见及答复"));
                    result.setMessage("通过");
                }else {
                    tbPatent.setPlanId(selectPlanId("待初审"));
                    result.setMessage("未通过");
                }
            }
            result.setSuccess(true);
            //修改专利的进度状态
            userPatentService.updPlan(tbPatent);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
