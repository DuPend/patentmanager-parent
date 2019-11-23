package com.xinghuo.mapper;

import com.xinghuo.pojo.DataCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-22 21:34
 * @version: V1.0
 */
@Mapper
@Repository
public interface TbDataCountMapper {

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:34
     */
    DataCount findDataCount();



}
