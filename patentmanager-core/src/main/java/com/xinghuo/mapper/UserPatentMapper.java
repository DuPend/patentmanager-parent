package com.xinghuo.mapper;

import com.xinghuo.pojo.TbPatent;
import com.xinghuo.pojo.TbPlan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *@Author:段炼 on 2019/11/23 11:45
 *@param:
 *@return:
 *@description:
 */
@Mapper
@Repository
public interface UserPatentMapper {

    List<TbPatent> findAll();
    //通过id查询某专利的详细信息
    List<TbPatent> findDetail(Integer id);

    int update(Integer id);
}
