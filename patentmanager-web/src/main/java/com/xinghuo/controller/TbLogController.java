package com.xinghuo.controller;

import com.xinghuo.pojo.TbLog;
import com.xinghuo.service.TbLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/log")
public class TbLogController {

    @Autowired
    private TbLogService tbLogService;

    @RequestMapping("/showLog")
    @ResponseBody
    public List<TbLog> showAllLog(HttpServletRequest httpServletRequest) {
        List<TbLog> tbLogs = tbLogService.selectAllLogService();
        return tbLogs;
    }
    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("logName"); // 设置文件名，根据业务需要替换成要下载的文件名
        return null;
    }
}
