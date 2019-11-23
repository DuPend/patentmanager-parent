package com.xinghuo.service;

import com.xinghuo.pojo.DataCount;

/**
 * @description: 数据统计服务接口层
 * @author: 杜鹏
 * @date: 2019-11-22 21:36:21
 * @version: V1.0
 */
public interface TbDataCountService {

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:33
     */
    DataCount findDataCount();
}
