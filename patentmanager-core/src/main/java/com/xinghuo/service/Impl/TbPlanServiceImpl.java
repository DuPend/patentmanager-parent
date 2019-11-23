package com.xinghuo.service.Impl;

import com.xinghuo.mapper.TbPlanMapper;
import com.xinghuo.service.TbPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: LiuJian
 * @Date: 2019/11/22 0022 15:11
 * @Version: V1.0
 */

@Service
public class TbPlanServiceImpl implements TbPlanService {
    @Resource
    private TbPlanMapper tbPlanMapper;

    //根据进度内容查询进度id
    @Override public Integer findPlanByContent(String planContent) {
        return tbPlanMapper.findPlanByContent(planContent);
    }
}
