package com.xinghuo.service.Impl;

import com.xinghuo.mapper.TbPatentMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.UserPatentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mypatent
 * @description: 用户专利service实现类
 * @author: Yuyue
 * @create: 2019-11-20 19:41
 **/
@Service
public class UserPatentServiceImpl implements UserPatentService {
   @Resource TbPatentMapper patentMapper;

    @Override
    public List<TbPatent> getPatentByUser(Integer userId) {
        System.out.println(userId+"cdcdcd");
        return patentMapper.getPatentByUser(userId);
    }

    @Override
    public TbPatent getPatentById(Integer patentId) {
        return patentMapper.getPatentById(patentId);
    }

    @Override
    public void updatePatentById(TbPatent tbPatent) {
        //修改专利的基本信息
        patentMapper.updatePatentById(tbPatent);
        if(tbPatent.getTbIndicators()!=null){
            //删除专利对应的指标
            System.out.println("删除啦"+tbPatent.getTbIndicators());
            patentMapper.deleteIndicatorsByPatentId(tbPatent.getPatentId());
            //添加修改的所有指标
            for(int i=0;i<tbPatent.getTbIndicators().size();i++){
                patentMapper.insertIndicatorsByPatentId(tbPatent.getTbIndicators().get(i));
            }

        }

    }
}
