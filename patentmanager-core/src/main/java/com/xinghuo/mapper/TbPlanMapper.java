package com.xinghuo.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: LiuJian
 * @Time: 2019/11/21 0021 17:08
 */
@Mapper
public interface TbPlanMapper {
    //根据进度内容查询进度id
    Integer findPlanByContent(String planContent);

}
