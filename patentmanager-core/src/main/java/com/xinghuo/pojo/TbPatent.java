package com.xinghuo.pojo;

/**
 * @program: mypatent
 * @description: 专利实体类
 * @author: Yuyue
 * @create: 2019-11-20 19:36
 **/

import java.util.Date;
import java.util.List;

public class TbPatent {
    private Integer patentId;

    private String batch;



    private String patentName;

    private String caseNumber;

    private String proposeNumber;

    private String proposerName;

    private String lawStatus;

    private String patentType;

    private String inventorName;

    private Date proposeDate;

    private String technicalContact;

    private TbPlan tbplan;

    private String remark;

    private List<TbIndicator> tbIndicators;

    private  Integer planId;

    private String[] indDetails;



    private TbUser creator;

    private TbPlan tbPlan;


    public String[] getIndDetails() {
        return indDetails;
    }

    public void setIndDetails(String[] indDetails) {
        this.indDetails = indDetails;
    }



    public TbPlan getTbplan() {
        return tbplan;
    }

    public void setTbplan(TbPlan tbplan) {
        this.tbplan = tbplan;
    }




    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public TbUser getCreator() {
        return creator;
    }

    public void setCreator(TbUser creator) {
        this.creator = creator;
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getProposeNumber() {
        return proposeNumber;
    }

    public void setProposeNumber(String proposeNumber) {
        this.proposeNumber = proposeNumber;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getLawStatus() {
        return lawStatus;
    }

    public void setLawStatus(String lawStatus) {
        this.lawStatus = lawStatus;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getInventorName() {
        return inventorName;
    }

    public void setInventorName(String inventorName) {
        this.inventorName = inventorName;
    }

    public Date getProposeDate() {
        return proposeDate;
    }

    public void setProposeDate(Date proposeDate) {
        this.proposeDate = proposeDate;
    }

    public String getTechnicalContact() {
        return technicalContact;
    }

    public void setTechnicalContact(String technicalContact) {
        this.technicalContact = technicalContact;
    }



    public TbPlan getTbPlan() {
        return tbPlan;
    }

    public void setTbPlan(TbPlan tbPlan) {
        this.tbPlan = tbPlan;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
