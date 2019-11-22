package com.xinghuo.mapper;

import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchMapper {
    List<TbPatent> findCondition(TbPatent patent);
}
