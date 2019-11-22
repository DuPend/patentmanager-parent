package com.xinghuo.pojo;

import java.util.List;

public class TbIndicator {
    private Integer indId;

    private String indDetails;

    private Integer patentId;




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
}
