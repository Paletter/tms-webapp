package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmConsignmentCurrent extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmConsignmentCurrentId;
    private String consignmentNo;
    private Integer tmConsignmentId;
    private Integer payStatus;
    private Integer auditStatus;
    private Integer combinationStatus;
    private Integer disassemblyStatus;
    private Integer autoDisassembleStatus;
    private Integer isAutoDisassemble;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getTmConsignmentCurrentId() {
        return tmConsignmentCurrentId;
    }
        
    public void setTmConsignmentCurrentId(Integer tmConsignmentCurrentId) {
        this.tmConsignmentCurrentId = tmConsignmentCurrentId;
    }
        
    public String getConsignmentNo() {
        return consignmentNo;
    }
        
    public void setConsignmentNo(String consignmentNo) {
        this.consignmentNo = consignmentNo;
    }
        
    public Integer getTmConsignmentId() {
        return tmConsignmentId;
    }
        
    public void setTmConsignmentId(Integer tmConsignmentId) {
        this.tmConsignmentId = tmConsignmentId;
    }
        
    public Integer getPayStatus() {
        return payStatus;
    }
        
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
        
    public Integer getAuditStatus() {
        return auditStatus;
    }
        
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }
        
    public Integer getCombinationStatus() {
        return combinationStatus;
    }
        
    public void setCombinationStatus(Integer combinationStatus) {
        this.combinationStatus = combinationStatus;
    }
        
    public Integer getDisassemblyStatus() {
        return disassemblyStatus;
    }
        
    public void setDisassemblyStatus(Integer disassemblyStatus) {
        this.disassemblyStatus = disassemblyStatus;
    }
        
    public Integer getAutoDisassembleStatus() {
        return autoDisassembleStatus;
    }
        
    public void setAutoDisassembleStatus(Integer autoDisassembleStatus) {
        this.autoDisassembleStatus = autoDisassembleStatus;
    }
        
    public Integer getIsAutoDisassemble() {
        return isAutoDisassemble;
    }
        
    public void setIsAutoDisassemble(Integer isAutoDisassemble) {
        this.isAutoDisassemble = isAutoDisassemble;
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