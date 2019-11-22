package com.xinghuo.mapper;

import com.xinghuo.pojo.TbPatent;
import com.xinghuo.pojo.TbPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPatentMapper {

    List<TbPatent> findAll();
    //通过id查询某专利的详细信息
    List<TbPatent> findDetail(Integer id);

    int update(Integer id);
}
