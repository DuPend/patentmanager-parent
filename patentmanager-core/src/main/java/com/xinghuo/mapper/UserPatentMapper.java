package com.xinghuo.mapper;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbPatent;
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

    Page<TbPatent> findAll();
    //通过id查询某专利的详细信息
    List<TbPatent> findDetail(Integer id);

    int update(TbPatent tbPatent);

}
