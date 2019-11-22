package com.xinghuo.pojo;


import java.util.Date;

public class TbFlow {
    private Integer flowId;

    private String editSelectioin;

    private String editUser;

    private Date flowDate;

    private Integer patent_id;

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

    public Integer getPatent_id() {
        return patent_id;
    }

    public void setPatent_id(Integer patent_id) {
        this.patent_id = patent_id;
    }
}
