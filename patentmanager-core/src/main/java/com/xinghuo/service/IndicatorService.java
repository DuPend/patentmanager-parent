package com.xinghuo.service;

import com.xinghuo.pojo.Dept;

import java.util.List;

public interface IndicatorService {

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> list();
}
