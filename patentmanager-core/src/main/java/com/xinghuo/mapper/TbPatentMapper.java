package com.xinghuo.mapper;

import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository

public interface TbPatentMapper {

    List<TbPatent> getPatentByUser(Integer userId);
    TbPatent getPatentById(Integer patentId);

    void updatePatentById(TbPatent tbPatent);

    void deleteIndicatorsByPatentId(Integer patentId);

    void insertIndicatorsByPatentId(TbIndicator tbIndicator);


    //根据相关专利信息查询所有专利包含认领和未被认领（管理员） zhou_gc
    List<TbPatent>  getPatentList(TbPatent tbPatent);

    //根据专利id查询相关专利信息  zhou_gc
    TbPatent  getPatentByPatentId(Integer patent_id);


}
