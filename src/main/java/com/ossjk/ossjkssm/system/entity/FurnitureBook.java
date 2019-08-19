package com.ossjk.ossjkssm.system.entity;

import com.ossjk.core.base.entity.BaseEntity;

import java.util.Date;

public class FurnitureBook extends BaseEntity {
    private Integer id;
    private String fbName;
    private String fbBrand;
    private String fbType;
    private String fbSpec;
    private Integer borrowStatus;
    private Integer damageStatus;
    private Integer maintainStatus;

    private String bsName;
    private String msName;
    private String dsName;

    private String borrowBy;
    private Date borrowTime;

    public FurnitureBook() {
    }

    public FurnitureBook(Integer id, String fbName, String fbBrand, String fbType, String fbSpec, Integer borrowStatus, Integer damageStatus, Integer maintainStatus, String bsName, String msName, String dsName, String borrowBy, Date borrowTime) {
        this.id = id;
        this.fbName = fbName;
        this.fbBrand = fbBrand;
        this.fbType = fbType;
        this.fbSpec = fbSpec;
        this.borrowStatus = borrowStatus;
        this.damageStatus = damageStatus;
        this.maintainStatus = maintainStatus;
        this.bsName = bsName;
        this.msName = msName;
        this.dsName = dsName;
        this.borrowBy = borrowBy;
        this.borrowTime = borrowTime;
    }

    @Override
    public String toString() {
        return "FurnitureBook{" +
                "id=" + id +
                ", fbName='" + fbName + '\'' +
                ", fbBrand='" + fbBrand + '\'' +
                ", fbType='" + fbType + '\'' +
                ", fbSpec='" + fbSpec + '\'' +
                ", borrowStatus=" + borrowStatus +
                ", damageStatus=" + damageStatus +
                ", maintainStatus=" + maintainStatus +
                ", bsName='" + bsName + '\'' +
                ", msName='" + msName + '\'' +
                ", dsName='" + dsName + '\'' +
                ", borrowBy='" + borrowBy + '\'' +
                ", borrowTime=" + borrowTime +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFbName() {
        return fbName;
    }

    public void setFbName(String fbName) {
        this.fbName = fbName;
    }

    public String getFbBrand() {
        return fbBrand;
    }

    public void setFbBrand(String fbBrand) {
        this.fbBrand = fbBrand;
    }

    public String getFbType() {
        return fbType;
    }

    public void setFbType(String fbType) {
        this.fbType = fbType;
    }

    public String getFbSpec() {
        return fbSpec;
    }

    public void setFbSpec(String fbSpec) {
        this.fbSpec = fbSpec;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Integer getDamageStatus() {
        return damageStatus;
    }

    public void setDamageStatus(Integer damageStatus) {
        this.damageStatus = damageStatus;
    }

    public Integer getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(Integer maintainStatus) {
        this.maintainStatus = maintainStatus;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getBorrowBy() {
        return borrowBy;
    }

    public void setBorrowBy(String borrowBy) {
        this.borrowBy = borrowBy;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }
}
