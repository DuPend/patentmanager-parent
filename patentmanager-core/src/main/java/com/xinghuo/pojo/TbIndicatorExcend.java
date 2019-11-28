package com.xinghuo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description: 指标扩展类
 * @author: 杜鹏
 * @date: 2019-11-21 18:47
 * @version: V1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class TbIndicatorExcend extends TbIndicator {
    /**
     * 专利类
     */
    //private TbPatent tbPatent;
    /**
     * 专利名称
      */
    private String patentName;

    /**
     * 专利进度
     */
    private String planContent;

    /**
     * 申请日
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date proposeDate;

    /**
     * 发明人中文名称
     */
    private String proposerName;

    /**
     * 撰写人
     */
    private String userName;

    /**
     * 申请号
     */
    private String proposeNumber;

    /**
     * 进度id
     */
    private Integer planId;
}
