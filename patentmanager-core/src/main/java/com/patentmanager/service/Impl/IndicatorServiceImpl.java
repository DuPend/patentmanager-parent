package com.patentmanager.service.Impl;

import com.patentmanager.entity.Dept;
import com.patentmanager.mapper.IndicatorMapper;
import com.patentmanager.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-20 16:13
 * @version: V1.0
 */
@Service
public class IndicatorServiceImpl  implements IndicatorService {

    @Autowired
    private IndicatorMapper indicatorMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Dept> list() {
        List<Dept> list = indicatorMapper.findAll();
        redisTemplate.boundListOps("one").rightPush(list);
        return indicatorMapper.findAll();
    }
}

