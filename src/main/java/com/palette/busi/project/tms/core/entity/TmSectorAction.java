package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmSectorAction extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmSectorActionId;
    private String actionCode;
    private String actionDesc;
    private Integer userViewNo;
    private String userViewCode;
    private Integer isActivity;
    private Integer recordVersion;
    private String companyCode;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getTmSectorActionId() {
        return tmSectorActionId;
    }
        
    public void setTmSectorActionId(Integer tmSectorActionId) {
        this.tmSectorActionId = tmSectorActionId;
    }
        
    public String getActionCode() {
        return actionCode;
    }
        
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
        
    public String getActionDesc() {
        return actionDesc;
    }
        
    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }
        
    public Integer getUserViewNo() {
        return userViewNo;
    }
        
    public void setUserViewNo(Integer userViewNo) {
        this.userViewNo = userViewNo;
    }
        
    public String getUserViewCode() {
        return userViewCode;
    }
        
    public void setUserViewCode(String userViewCode) {
        this.userViewCode = userViewCode;
    }
        
    public Integer getIsActivity() {
        return isActivity;
    }
        
    public void setIsActivity(Integer isActivity) {
        this.isActivity = isActivity;
    }
        
    public Integer getRecordVersion() {
        return recordVersion;
    }
        
    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }
        
    public String getCompanyCode() {
        return companyCode;
    }
        
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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