package com.xinghuo.mapper;

import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatentMapper {

    List<TbPatent> getPatentByUser(Integer userId);
    TbPatent getPatentById(Integer patentId);

    void updatePatentById(TbPatent tbPatent);

    void deleteIndicatorsByPatentId(Integer patentId);

    void insertIndicatorsByPatentId(TbIndicator tbIndicator);
}
