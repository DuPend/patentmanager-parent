package com.xinghuo.service.Impl;


import com.xinghuo.mapper.UserPatentMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.pojo.TbPlan;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userPatentImpl implements UserPatentService {


    @Autowired
    private UserPatentMapper userPatentMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<TbPatent> findAll() {
        /*if((redisTemplate.boundSetOps("findAll").members()) != null) {
            List list = redisTemplate.boundListOps("findAll").range(0, 1);
            System.out.println("用上redis了！");
            System.out.println(list);
            return list;
        }else {*/
        List<TbPatent> list = userPatentMapper.findAll();
        /*redisTemplate.boundListOps("findAll").rightPush(list);
            System.out.println(list);*/
        return list;


}

    @Override
    public List<TbPatent> findDetail(Integer id) {
        List<TbPatent> list =userPatentMapper.findDetail(id);
        return list;
    }

    @Override public int update(Integer id) {
        return userPatentMapper.update(id);
    }
}
