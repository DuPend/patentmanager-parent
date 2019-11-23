package com.xinghuo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description: 数据统计表
 * @author: 杜鹏
 * @date: 2019-11-22 22:09
 * @version: V1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class DataCount implements Serializable {
    /**
     * 专利总数
     */
    private Long patentTotal;

    /**
     * 已成功申请专利总数
     */
    private Long successNumber;

    /**
     * 申请专利失败数量
     */
    private Long falseNumber;

    /**
     * 申请中专利数
     */
    private Long applyNumber;
}
