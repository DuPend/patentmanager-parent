package com.xinghuo.controller;
//import com.xinghuo.common.utils.SpringContextUtils;
import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbDocumentType;
import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbPatent;

import com.xinghuo.service.SearchService;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.java2d.pipe.AAShapePipe;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 *@Author:段炼 on 2019/11/22 17:36
 *@param:
 *@return:
 *@description:专利的各种查询
 */
@RestController
//@RequestMapping("patent")
public class UserPatentController {
    @Autowired UserPatentService userPatentService;

    /**
     *@Author:Yuyue
     *@Description:查询当前用户的专利基本信息
     *@Date:21:06  2019/11/21
     *@Param:  * @param Integer userId
     *@Return: 用户所有被认领的专利
     */
    @RequestMapping("/UserPatent")
    public List<TbPatent> getPatentByUser(Integer userId){
        System.out.println(userPatentService.getPatentByUser(userId).toString()+"oooocsvcvdsfcasvsz");
        return userPatentService.getPatentByUser(userId);
    }

    /**
     *@Author:Yuyue
     *@Description:查询专利详情
     *@Date:21:07  2019/11/21
     *@Param:  * @param 专利id
     *@Return:
     */
    @RequestMapping("/PatentDetail")
    public TbPatent getPatentById(Integer patentId){
        System.out.println("dasdasadad"+userPatentService.getPatentById(patentId).toString());
        return userPatentService.getPatentById(patentId);
    }

    /**
     *@Author:Yuyue
     *@Description:接口解析没有完成，返回值没有完成
     *@Date:21:12  2019/11/21
     *@Param:
     *@Return:
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
     *@Author:Yuyue
     *@Description:添加文件到数据库
     *@Date:15:16  2019/11/22
     *@Param: Integer patentId,Integer typeId,String docName,String docAddress
     *@Return:
     */
    @RequestMapping("/test")
    public void addFile(Integer patentId,Integer typeId,String docName,String docAddress){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        TbDocument tbDocument=new TbDocument();
        TbDocumentType tbDocumentType=new TbDocumentType();
        tbDocumentType.setDocTypeId(typeId);
        tbDocument.setTbDocumentType(tbDocumentType);
        tbDocument.setDocName(docName);
        tbDocument.setDocAddress(docAddress);
        tbDocument.setUploadDate(new Date());
        tbDocument.setPatentId(patentId);
        userPatentService.addFile(tbDocument);

    }

    /**
     *@Author:Yuyue
     *@Description:文件上传
     *@Date:11:43  2019/11/22
     *@Param: 文件
     *@Return:  返回是否成功
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,Integer patentId,Integer typeId) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            Calendar calendar = Calendar.getInstance();
            fileName = fileName +"-"+ calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1) + "" + calendar
                    .get(Calendar.DATE) + calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) + calendar
                    .get(Calendar.SECOND) + suffixName;
            System.out.println("上传的文件名为：" + fileName);
            //保存文件的绝对路径
            File curFile = new File("");
            String filePath = "";
            try {
                filePath = curFile.getCanonicalPath() +"\\"+ fileName;
                System.out.println("文件路径：" + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            File saveFile = new File(filePath);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                addFile(patentId,typeId,fileName,filePath);
                return saveFile.getName() + " 上传成功";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return"上传失败," ;
            } catch (IOException e) {
                e.printStackTrace();
                return"上传失败,";
            }
        } else {
            return "上传失败，因为文件为空.";
        }
    }
    /**
     *@Author:Yuyue
     *@Description:用户查询文件信息，只显示所有类别最新的文件
     *@Date:17:42  2019/11/22
     *@Param: 专利id
     *@Return: 返回文件list
     */
    @RequestMapping("SelectLatestDocument")
    List<TbDocument> selectLatestDocumentById(Integer patentId){
        return userPatentService.selectLatestDocumentById(patentId);
    }

    /**
     *@Author:Yuyue
     *@Description:管理员查询出所有当前专利的文件
     *@Date:17:42  2019/11/22
     *@Param: 专利id
     *@Return: 返回文件list
     */
    @RequestMapping("SelectAllDocument")
    List<TbDocument> selectAllDocumentById(Integer patentId) {
        return userPatentService.selectAllDocumentById(patentId);

    }
    @Autowired
    private SearchService searchService;

    //所有专利 段炼
    @RequestMapping("/findAll")
    public List<TbPatent> index(){

        List<TbPatent> list = userPatentService.findAll();
        return list;
    }

    //某专利的详细信息 段炼
    @RequestMapping("/findDetail")
    public List<TbPatent> findDetail(Integer id){
        List<TbPatent> list = userPatentService.findDetail(id);
        return list;
    }

    //条件查询 段炼
    @RequestMapping("/findCondition")
    public List<TbPatent> findCondition(TbPatent patent){
        List<TbPatent> list = searchService.findCondition(patent);
        return list;
    }

    //认领状态  段炼
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
