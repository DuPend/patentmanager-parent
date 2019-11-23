package com.xinghuo.pojo;

public class TbDocumentType {
    private Integer docTypeId;

    private String docTypeName;

    public Integer getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(Integer docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName == null ? null : docTypeName.trim();
    }
}