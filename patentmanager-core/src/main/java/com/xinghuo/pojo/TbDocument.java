package com.xinghuo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbDocument {
    private Integer docId;

    private TbDocumentType tbDocumentType;

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    private String docName;

    private String docAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date uploadDate;

    private Integer patentId;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public TbDocumentType getTbDocumentType() {
        return tbDocumentType;
    }

    public void setTbDocumentType(TbDocumentType tbDocumentType) {
        this.tbDocumentType = tbDocumentType;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getDocAddress() {
        return docAddress;
    }

    public void setDocAddress(String docAddress) {
        this.docAddress = docAddress == null ? null : docAddress.trim();
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

}
