package com.xinghuo.service;

import com.xinghuo.pojo.TbPatent;
import com.xinghuo.pojo.TbPlan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.List;

/**
 * @program: mypatent
 * @description: 用户专利服务层
 * @author: Yuyue and  duanlian
 * @create: 2019-11-20 19:35
 **/

@Service
public interface UserPatentService {
    List<TbPatent> findAll();
    List<TbPatent> findDetail(Integer id);
    int update(Integer id);
    List<TbPatent> getPatentByUser(Integer userId);

    TbPatent getPatentById(Integer patentId);

    void  updatePatentById(TbPatent tbPatent);
}




