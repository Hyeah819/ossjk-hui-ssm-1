package com.ossjk.ossjkssm.system.entity;

public class FbDictionary {
    private Integer id;
    private String typeName;
    private Integer fbKey;
    private String fbValue;

    @Override
    public String toString() {
        return "FbDictionary{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", fbkey=" + fbKey +
                ", faValue='" + fbValue + '\'' +
                '}';
    }

    public FbDictionary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getFbKey() {
        return fbKey;
    }

    public void setFbKey(Integer fbKey) {
        this.fbKey = fbKey;
    }

    public String getFbValue() {
        return fbValue;
    }

    public void setFbValue(String fbValue) {
        this.fbValue = fbValue;
    }
}
