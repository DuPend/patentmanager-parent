package com.xinghuo.pojo;

public class TbIndicator {
    private Integer indId;

    private String indDetails;

    private Integer patentId;

    private TbPatent tbPatent;


    public Integer getIndId() {
        return indId;
    }

    public void setIndId(Integer indId) {
        this.indId = indId;
    }

    public String getIndDetails() {
        return indDetails;
    }

    public void setIndDetails(String indDetails) {
        this.indDetails = indDetails == null ? null : indDetails.trim();
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public TbPatent getTbPatent() {
        return tbPatent;
    }

    public void setTbPatent(TbPatent tbPatent) {
        this.tbPatent = tbPatent;
    }

}
