package com.xinghuo.service.Impl;

import com.xinghuo.mapper.TbDataCountMapper;
import com.xinghuo.pojo.DataCount;
import com.xinghuo.service.TbDataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 数据统计服务实现层
 * @author: 杜鹏
 * @date: 2019-11-22 21:33:14
 * @version: V1.0
 */
@Service
public class TbDataCountServiceImpl implements TbDataCountService {
    @Autowired
    private TbDataCountMapper dataCountMapper;

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:34
     */
    @Override
    public DataCount findDataCount() {
        return dataCountMapper.findDataCount();
    }
}
