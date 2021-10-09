package com.csse.pms.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Delivery Log related implementation
 */

@Document
public class DeliveryLogModel {

    @Id
    private String id;
    private String referenceNo;
    private String siteManagerId;
    private String remark;
    private String status;

    public DeliveryLogModel() {
    }

    public DeliveryLogModel(String id, String referenceNo, String siteManagerId, String remark, String status) {
        this.id = id;
        this.referenceNo = referenceNo;
        this.siteManagerId = siteManagerId;
        this.remark = remark;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeliveryLogModel{" +
                "id='" + id + '\'' +
                ", referenceNo='" + referenceNo + '\'' +
                ", siteManagerId='" + siteManagerId + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSiteManagerId() {
        return siteManagerId;
    }

    public void setSiteManagerId(String siteManagerId) {
        this.siteManagerId = siteManagerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
