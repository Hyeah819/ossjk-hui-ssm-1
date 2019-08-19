package com.ossjk.ossjkssm.system.entity;

import com.ossjk.core.base.entity.BaseEntity;


public class FurnitureBookManage  extends BaseEntity {
    private Integer id;
    private String fbName;
    private String fbBrand;
    private String fbType;
    private String fbSpec;
    private Integer repairStatus;
    private Integer borrowStatus;
    private Integer damageStatus;
    private Integer maintainStatus;

    private String bsName;
    private String msName;
    private String dsName;
    private String rsName;

    private String borrowBy;
    private String borrowNumber;
    private String register;
    private String pipelineNumber;

    @Override
    public String toString() {
        return "FurnitureBookManage{" +
                "id=" + id +
                ", fbName='" + fbName + '\'' +
                ", fbBrand='" + fbBrand + '\'' +
                ", fbType='" + fbType + '\'' +
                ", fbSpec='" + fbSpec + '\'' +
                ", repairStatus=" + repairStatus +
                ", borrowStatus=" + borrowStatus +
                ", damageStatus=" + damageStatus +
                ", maintainStatus=" + maintainStatus +
                ", bsName='" + bsName + '\'' +
                ", msName='" + msName + '\'' +
                ", dsName='" + dsName + '\'' +
                ", rsName='" + rsName + '\'' +
                ", borrowBy='" + borrowBy + '\'' +
                ", borrowNumber='" + borrowNumber + '\'' +
                ", register='" + register + '\'' +
                ", PipelineNumber='" + pipelineNumber + '\'' +
                '}';
    }

    public FurnitureBookManage() {
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

    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
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

    public String getRsName() {
        return rsName;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName;
    }

    public String getBorrowBy() {
        return borrowBy;
    }

    public void setBorrowBy(String borrowBy) {
        this.borrowBy = borrowBy;
    }

    public String getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(String borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getPipelineNumber() {
        return pipelineNumber;
    }

    public void setPipelineNumber(String pipelineNumber) {
        this.pipelineNumber = pipelineNumber;
    }
}
