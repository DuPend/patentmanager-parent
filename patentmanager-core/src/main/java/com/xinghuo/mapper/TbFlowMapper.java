package com.xinghuo.mapper;

import com.xinghuo.pojo.TbFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbFlowMapper {
    /**
     * @ Author     ：姜爽
     * @ Description：
     */
// 增加操作日志
    int addTbFlow(TbFlow tbFlow);
//查询所有的操作日志
    List<TbFlow> showTbFlow();
//根据专利ID查询操作日志
    List<TbFlow> showTbFlowById(Integer patentId);
}