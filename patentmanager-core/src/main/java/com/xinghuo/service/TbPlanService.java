package com.xinghuo.service;

/**
 * @Description:
 * @Author: LiuJian
 * @Time: 2019/11/22 0022 15:09
 */
public interface TbPlanService {
    //根据进度内容查询进度id
    Integer findPlanByContent(String planContent);
}
