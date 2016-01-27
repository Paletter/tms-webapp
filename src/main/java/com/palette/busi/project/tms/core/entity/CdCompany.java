package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdCompany extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer cdCompanyId;
    private String companyName;
    private String companyCode;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getCdCompanyId() {
        return cdCompanyId;
    }
        
    public void setCdCompanyId(Integer cdCompanyId) {
        this.cdCompanyId = cdCompanyId;
    }
        
    public String getCompanyName() {
        return companyName;
    }
        
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
        
    public String getCompanyCode() {
        return companyCode;
    }
        
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
        
    public Integer getRecordVersion() {
        return recordVersion;
    }
        
    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }
        
    public String getCreateUserCode() {
        return createUserCode;
    }
        
    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }
        
    public Date getCreateDateTime() {
        return createDateTime;
    }
        
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
        
    public String getUpdateUserCode() {
        return updateUserCode;
    }
        
    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode;
    }
        
    public Date getUpdateDateTime() {
        return updateDateTime;
    }
        
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
        
}