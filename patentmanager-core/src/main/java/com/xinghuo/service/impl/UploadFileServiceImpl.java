package com.xinghuo.service.impl;
import com.xinghuo.mapper.TbPatentMapper;
import com.xinghuo.pojo.Result;
import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbDocumentType;
import com.xinghuo.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: patentmanager-parent
 * @description: 文件上传controller
 * @author: Yuyue
 * @create: 2019-11-25 10:45
 **/


@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private TbPatentMapper patentMapper;
    @Value("${visualPath}")
    private String downfile; //下載文件時的ip路徑
    @Value("${savepath}")
    private String savepath; //服務器上的文件實際存儲位置

    /**
     * @Author:Yuyue
     * @Description:添加文件到数据库
     * @Date:15:16 2019/11/22
     * @Param: Integer patentId,Integer typeId,String docName,String docAddress
     * @Return:
     */
    public Result addFile(Integer patentId, Integer typeId, String docName, String docAddress) {
        Result result = new Result(false, null);
        TbDocument tbDocument = new TbDocument();
        TbDocumentType tbDocumentType = new TbDocumentType();
        tbDocumentType.setDocTypeId(typeId);
        tbDocument.setTbDocumentType(tbDocumentType);
        tbDocument.setDocName(docName);
        tbDocument.setDocAddress(docAddress);
        tbDocument.setPatentId(patentId);
        try {
            patentMapper.addFile(tbDocument);
            result.setSuccess(true);
            result.setMessage("上传文件成功!");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("上传文件失败" + e.getMessage());
        }
        return result;
    }


    @Override
    public Result uploadFile(MultipartFile file, Integer patentId, Integer typeId, HttpServletRequest request) {

        Result result = new Result(false, null);

        if (file.isEmpty()) {
            result.setMessage("文件为空，上传失败");
            result.setSuccess(false);
            return result;
        }
        String fileName = file.getOriginalFilename();
        //java.util.Date转换为String
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str  =  format.format(date);
        fileName = fileName + "-" + str + suffixName;

        int size = (int) file.getSize();
//        String projectUrl = request.getSession().getServletContext().getRealPath("/") + "\\upfile" ;
//        System.out.println("projectUrl:" + projectUrl);
        String path = savepath + "upfile/" + fileName;
        String url = downfile + "upfile/" + fileName;
        File dest = new File(path);
        System.out.println(downfile);
        System.out.println("url:" + url);
        System.out.println("path:" + path);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
            out.write(file.getBytes());
            out.flush();
            out.close();

        } catch (IllegalStateException e) {
            e.printStackTrace();
            result.setMessage("文件上传失败!" + e.getMessage());
            result.setSuccess(false);
            return result;
        } catch (IOException e) {
            result.setMessage("文件上传失败!" + e.getMessage());
            result.setSuccess(false);
            return result;
        }

        return addFile(patentId, typeId, fileName, url);
    }
}
