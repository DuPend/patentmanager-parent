package com.xinghuo.service;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:33
 * @version: V1.0
 */

import com.xinghuo.pojo.TbFlow;

import java.util.List;

public interface TbFlowService {
    // 增加操作日志
    int addTbFlowService(TbFlow tbFlow);
    //查询所有的操作日志
    List<TbFlow> showTbFlowService();
    //根据专利ID查询操作日志
    List<TbFlow> showTbFlowByIdService(Integer patentId);
}