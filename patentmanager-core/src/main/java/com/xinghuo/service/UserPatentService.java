package com.xinghuo.service;

import com.xinghuo.pojo.TbPatent;

import java.util.List;

/**
 * @program: mypatent
 * @description: 用户专利服务层
 * @author: Yuyue
 * @create: 2019-11-20 19:35
 **/

public interface UserPatentService {
    List<TbPatent> getPatentByUser(Integer userId);

    TbPatent getPatentById(Integer patentId);

    void  updatePatentById(TbPatent tbPatent);
}
