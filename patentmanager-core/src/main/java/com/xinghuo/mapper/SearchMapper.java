package com.xinghuo.mapper;

import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    List<TbPatent> findCondition(TbPatent patent);
}
