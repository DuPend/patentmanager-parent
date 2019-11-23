package com.xinghuo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description 部门实体类
 * @author dupeng
 * @date 2019-11-17 11:44:52
 * @version V1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class TbDept implements Serializable {

    /**
     * 主键
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 上级部门id
     */
    private Long parentId;



}