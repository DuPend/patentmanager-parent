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

    private TbUser writer;

    private TbUser creator;

    private Date proposeDate;

    private String technicalContact;

    public TbPlan getTbplan() {
        return tbplan;
    }

    public void setTbplan(TbPlan tbplan) {
        this.tbplan = tbplan;
    }

    private TbPlan tbplan;

    private String remark;

    private List<TbIndicator> tbIndicators;

    public TbUser getWriter() {
        return writer;
    }

    public void setWriter(TbUser writer) {
        this.writer = writer;
    }

    public TbUser getCreator() {
        return creator;
    }

    public void setCreator(TbUser creator) {
        this.creator = creator;
    }

    public List<TbIndicator> getTbIndicators() {
        return tbIndicators;
    }

    public void setTbIndicators(List<TbIndicator> tbIndicators) {
        this.tbIndicators = tbIndicators;
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
        this.batch = batch == null ? null : batch.trim();
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName == null ? null : patentName.trim();
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber == null ? null : caseNumber.trim();
    }

    public String getProposeNumber() {
        return proposeNumber;
    }

    public void setProposeNumber(String proposeNumber) {
        this.proposeNumber = proposeNumber == null ? null : proposeNumber.trim();
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName == null ? null : proposerName.trim();
    }

    public String getLawStatus() {
        return lawStatus;
    }

    public void setLawStatus(String lawStatus) {
        this.lawStatus = lawStatus == null ? null : lawStatus.trim();
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType == null ? null : patentType.trim();
    }

    public String getInventorName() {
        return inventorName;
    }

    public void setInventorName(String inventorName) {
        this.inventorName = inventorName == null ? null : inventorName.trim();
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
        this.technicalContact = technicalContact == null ? null : technicalContact.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}