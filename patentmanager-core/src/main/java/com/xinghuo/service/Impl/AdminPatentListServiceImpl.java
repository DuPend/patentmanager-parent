package com.xinghuo.service.Impl;

import com.xinghuo.mapper.TbPatentMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.AdminPatentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou_gc@suixingpay.com
 * @description
 * @date 2019/11/22 10:15
 */


@Service
public class AdminPatentListServiceImpl implements AdminPatentListService {

    @Autowired
    private TbPatentMapper tbPatentMapper;

    @Override public List<TbPatent> selectByPatentInfo(TbPatent patent) {
        return tbPatentMapper.getPatentList(patent);
    }

    @Override public TbPatent selectByPatentId(Integer patent_id) {
        return tbPatentMapper.getPatentById(patent_id);
    }
}
