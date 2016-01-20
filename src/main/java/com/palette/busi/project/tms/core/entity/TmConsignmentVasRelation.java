package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmConsignmentVasRelation extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmConsignmentVasRelationId;
    private String relationType;
    private Integer relationId;
    private Integer tmConsignmentVasMstId;
    private String vasDescription;
    private BigDecimal quantity;
    private BigDecimal price;
    private Integer completeStatus;
    private Date updatedDateTime;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String createTimeZone;
    private String updateUserCode;
    private Date updateDateTime;
    private String updateTimeZone;
    
    public Integer getTmConsignmentVasRelationId() {
        return tmConsignmentVasRelationId;
    }
        
    public void setTmConsignmentVasRelationId(Integer tmConsignmentVasRelationId) {
        this.tmConsignmentVasRelationId = tmConsignmentVasRelationId;
    }
        
    public String getRelationType() {
        return relationType;
    }
        
    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
        
    public Integer getRelationId() {
        return relationId;
    }
        
    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }
        
    public Integer getTmConsignmentVasMstId() {
        return tmConsignmentVasMstId;
    }
        
    public void setTmConsignmentVasMstId(Integer tmConsignmentVasMstId) {
        this.tmConsignmentVasMstId = tmConsignmentVasMstId;
    }
        
    public String getVasDescription() {
        return vasDescription;
    }
        
    public void setVasDescription(String vasDescription) {
        this.vasDescription = vasDescription;
    }
        
    public BigDecimal getQuantity() {
        return quantity;
    }
        
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
        
    public BigDecimal getPrice() {
        return price;
    }
        
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
        
    public Integer getCompleteStatus() {
        return completeStatus;
    }
        
    public void setCompleteStatus(Integer completeStatus) {
        this.completeStatus = completeStatus;
    }
        
    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }
        
    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
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
        
    public String getCreateTimeZone() {
        return createTimeZone;
    }
        
    public void setCreateTimeZone(String createTimeZone) {
        this.createTimeZone = createTimeZone;
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
        
    public String getUpdateTimeZone() {
        return updateTimeZone;
    }
        
    public void setUpdateTimeZone(String updateTimeZone) {
        this.updateTimeZone = updateTimeZone;
    }
        
}