package com.xinghuo.service.Impl;

import com.xinghuo.mapper.TbFlowMapper;
import com.xinghuo.pojo.TbFlow;
import com.xinghuo.service.TbFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:36
 * @version: V1.0
 */
@Service
public class TbFlowServiceImpl implements TbFlowService {
    //注入mapper层
    @Autowired
    private TbFlowMapper tbFlowMapper;
    @Override
    public int addTbFlowService(TbFlow tbFlow) {
        return tbFlowMapper.addTbFlow(tbFlow);
    }

    @Override
    public List<TbFlow> showTbFlowService() {
        return tbFlowMapper.showTbFlow();
    }

    @Override
    public List<TbFlow> showTbFlowByIdService(Integer patentId) {
        return tbFlowMapper.showTbFlowById(patentId);
    }
}