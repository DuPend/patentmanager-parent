package com.xinghuo.service;

import com.xinghuo.pojo.TbPatent;
import com.xinghuo.pojo.TbPlan;

import java.util.List;

public interface UserPatentService {
    List<TbPatent> findAll();
    List<TbPatent> findDetail(Integer id);
    int update(Integer id);
}