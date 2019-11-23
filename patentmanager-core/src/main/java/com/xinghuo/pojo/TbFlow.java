package com.xinghuo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFlow {
    private Integer flowId;

    private String editSelectioin;

    private String editUser;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date flowDate;

    private Integer patentId;

    private TbPatent tbPatent;

    public TbPatent getTbPatent() {
        return tbPatent;
    }

    public void setTbPatent(TbPatent tbPatent) {
        this.tbPatent = tbPatent;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getEditSelectioin() {
        return editSelectioin;
    }

    public void setEditSelectioin(String editSelectioin) {
        this.editSelectioin = editSelectioin;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(Date flowDate) {
        this.flowDate = flowDate;
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }
}
