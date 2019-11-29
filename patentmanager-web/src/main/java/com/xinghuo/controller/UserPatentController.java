package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.*;
import com.xinghuo.service.TbPlanService;
import com.xinghuo.service.UploadFileService;
import com.xinghuo.service.SearchService;
import com.xinghuo.service.UserPatentService;
import com.xinghuo.target.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:段炼 和于悦 on 2019/11/22 17:36
 * @param:
 * @return:
 * @description:专利的各种查询
 */
@RestController
public class UserPatentController {
    @Autowired
    private UserPatentService userPatentService;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private TbPlanService tbPlanService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @Author:Yuyue
     * @Description:查询当前用户认领的专利列表
     * @Date:21:06 2019/11/21
     * @Param: * @param Integer userId
     * @Return: 用户所有被认领的专利
     */
    @RequestMapping("UserPatent")
    public PageInfo<TbPatent> getPatentByUser(Integer userId,
                @RequestParam(defaultValue = "1", value = "currentPage")int page,
                @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> indicatorList = userPatentService.getPatentByUser(userId, page, rows);
        PageInfo<TbPatent> pageInfo = new PageInfo<>(indicatorList);
        return  pageInfo;

    }

    /**
     * @Author:Yuyue
     * @Description:查询用户撰写后，未通过的专利
     * @Date:15:19 2019/11/24
     * @Param:
     * @Return:
     */
    @GetMapping("FailPatent")
    public PageInfo<TbPatent> getFailPatentByUser(Integer userId,
                                              @RequestParam(defaultValue = "1", value = "currentPage")int page,
                                              @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        /* int userId = Integer.valueOf((String)httpServletRequest.getParameter("userId"));*/
        Page<TbPatent> indicatorList = userPatentService.getFailPatentByUser(userId, page, rows);
        PageInfo<TbPatent> pageInfo = new PageInfo<>(indicatorList);
        return  pageInfo;
    }

    /**
     * @Author:Yuyue
     * @Description:查询专利详情
     * @Date:21:07 2019/11/21
     * @Param: * @param 专利id
     * @Return:
     */
    @RequestMapping("PatentDetail")
    public TbPatent getPatentById(Integer patentId) {
        /*System.out.println("dasdasadad"+userPatentService.getPatentById(patentId).toString());*/
        System.out.println(patentId);
        return userPatentService.getPatentById(patentId);
    }

    /**
     * @Author:Yuyue
     * @Description:修改专利内容
     * @Date:21:12 2019/11/21
     * @Param:
     * @Return:
     */
    @RequestMapping("updatePatent")
    @Action(name = "change")
    public Result updatePatentById(@RequestBody TbPatent tbPatent) {
        System.out.println(tbPatent.toString());
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前专利的id
        httpSession.setAttribute("patentId", tbPatent.getPatentId().toString());
        System.out.println(tbPatent.getPatentId());
        Result result = new Result(false, null);
        if (tbPatent.getPatentId() != null) {
            try {
                userPatentService.updatePatentById(tbPatent);
                result.setSuccess(true);
                result.setMessage("修改成功！");
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage("修改失败!");
            }
        } else {
            result.setSuccess(false);
            result.setMessage("修改失败,专利id为空!");
        }
        return result;
    }

    @RequestMapping("uploadFile")
    @Action(name = "upfile")
    Result uploadFile(@RequestBody MultipartFile file, Integer patentId, Integer typeId,
                      HttpServletRequest request) {
        //上传文件
        Result result1 = uploadFileService.uploadFile(file, patentId, typeId, request);

        /*
         * @Author 姜爽
         * @Date 8:11 2019/11/28
         * @Description  将专利id存入session
         **/
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前专利的id
        httpSession.setAttribute("patentId", patentId.toString());
        //如果上传成功
        if (result1.isSuccess()) {
            //根据patentID查询当前进度
            int planId = userPatentService.findPatentById(patentId).getPlanId();
            //如果当前进度为交底书撰写中
            Result result2 = null;
            if (tbPlanService.findPlanByContent("交底书撰写中") == planId) {
                //修改进度为第一次审核;
                result2 = updatePatentPlan(tbPlanService.findPlanByContent("第一次审核"), patentId);
            } else {
                result2 = new Result(true, "上传该文件,不需要修改进度!");
            }
            return result2;
        } else {
            return result1;
        }
    }

    /**
     * @Author:Yuyue
     * @Description:用户查询文件信息，只显示所有类别最新的文件
     * @Date:17:42 2019/11/22
     * @Param: 专利id
     * @Return: 返回文件list
     */
    @RequestMapping("SelectLatestDocument") List<TbDocument> selectLatestDocumentById(Integer patentId) {
        return userPatentService.selectLatestDocumentById(patentId);
    }

    /**
     * @Author:Yuyue
     * @Description:管理员查询出所有当前专利的文件
     * @Date:17:42 2019/11/22
     * @Param: 专利id
     * @Return: 返回文件list
     */
    @RequestMapping("SelectAllDocument") List<TbDocument> selectAllDocumentById(Integer patentId) {
        return userPatentService.selectAllDocumentById(patentId);

    }

    //修改

    /**
     * @Author:Yuyue
     * @Description:修改专利的进度
     * @Date:14:53 2019/11/24
     * @Param: 应该修改为的专利进度id，专利id
     * @Return:
     */
    public Result updatePatentPlan(Integer planId, Integer patentId) {
        Result result = new Result(false, null);
        TbPatent tbPatent = new TbPatent();
        tbPatent.setPatentId(patentId);
        tbPatent.setPlanId(planId);
        try {
            userPatentService.updatePatentPlan(tbPatent);
            result.setSuccess(true);
            result.setMessage("修改进度成功！");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("修改进度失败！" + e.getMessage());
        }
        return result;
    }

    /**
     * @Author:Yuyue
     * @Description:修改专利的进度
     * @Date:14:53 2019/11/24
     * @Param: 应该修改为的专利进度id，专利id
     * @Return:
     */
    @RequestMapping("toBeJDBook") public Result updateBookPlan(Integer patentId) {
        Result result = new Result(false, null);
        TbPatent tbPatent = new TbPatent();
        tbPatent.setPatentId(patentId);
        tbPatent.setPlanId(tbPlanService.findPlanByContent("交底书撰写中"));
        try {
            userPatentService.updatePatentPlan(tbPatent);
            result.setSuccess(true);
            result.setMessage("修改进度成功为交底书撰写！");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("修改进度失败！" + e.getMessage());
        }
        return result;
    }

    @Autowired
    private SearchService searchService;

    //所有专利 段炼
    @RequestMapping("/findAll")
    public PageInfo<TbPatent> findAll(
            @RequestParam(defaultValue = "1", value = "currentPage")int page,
            @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> list = userPatentService.findAll(page, rows);
        PageInfo<TbPatent> pageInfo = new PageInfo<>(list);
        return  pageInfo;

    }

    //某专利的详细信息 段炼
    @RequestMapping("/findDetail")
    public List<TbPatent> findDetail(Integer id) {
        List<TbPatent> list = userPatentService.findDetail(id);
        return list;
    }

    //条件查询 段炼
    @RequestMapping("/findCondition")
    public List<TbPatent> findCondition(TbPatent patent) {
        List<TbPatent> list = searchService.findCondition(patent);
        return list;
    }

    //认领状态  段炼
    @RequestMapping("/updateCondition")
    @Action(name = "change")
    public Result update(@RequestBody TbPatent tbPatent) {
        int result = userPatentService.update(tbPatent);
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前专利的id
        httpSession.setAttribute("patentId", tbPatent.getPatentId().toString());
        if (result >= 1) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }


}
