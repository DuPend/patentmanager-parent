package com.xinghuo.service;

import com.xinghuo.pojo.TbPatent;

import java.util.List;

/**
 * @author zhou_gc@suixingpay.com
 * @description   管理员根据条件查询相关专利信息（包含认领和未认领）
 * @date 2019/11/22 10:08
 */



public interface AdminPatentListService {



      List<TbPatent>  selectByPatentInfo(TbPatent patent);

       TbPatent  selectByPatentId(Integer  patent_id);

}
