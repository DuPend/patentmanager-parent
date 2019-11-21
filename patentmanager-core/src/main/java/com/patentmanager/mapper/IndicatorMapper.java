package com.patentmanager.mapper;

import com.patentmanager.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-20 17:24
 * @version: V1.0
 */

@Mapper
public interface IndicatorMapper {
    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> findAll();
}
