package com.patentmanager.service;

import com.patentmanager.entity.Dept;

import java.util.List;

public interface IndicatorService {

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> list();
}
