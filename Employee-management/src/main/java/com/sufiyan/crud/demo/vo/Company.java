package com.sufiyan.crud.demo.vo;

public class Company {

    private long companyId;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String companyCode;

    public Company(long companyId, String companyName, String companyAddress, String companyEmail, String companyCode) {
        super();
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
        this.companyCode = companyCode;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
