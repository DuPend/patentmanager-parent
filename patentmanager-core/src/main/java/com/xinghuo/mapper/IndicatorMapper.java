package com.xinghuo.mapper;

import com.xinghuo.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-20 17:24
 * @version: V1.0
 */

@Mapper
@Repository

public interface IndicatorMapper {
    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> findAll();
}
