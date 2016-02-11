package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmPieces extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmPiecesId;
    private String warehouseCode;
    private String countryCode;
    private String memberCode;
    private String piecesNo;
    private String logisticsNo;
    private BigDecimal actualWeight;
    private BigDecimal volumeWeight;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private Date checkDate;
    private String memo;
    private Date deliveryDate;
    private Integer isBindDelivery;
    private Integer tmConsignmentId;
    private String consignmentNo;
    private String serviceProductCode;
    private String unitNo;
    private Integer tmUnitId;
    private String sectorCode;
    private Integer tmSectorId;
    private String outBatchNo;
    private Integer tmOutBatchId;
    private String deliveryCode;
    private String deliveryNo;
    private String companyCode;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getTmPiecesId() {
        return tmPiecesId;
    }
        
    public void setTmPiecesId(Integer tmPiecesId) {
        this.tmPiecesId = tmPiecesId;
    }
        
    public String getWarehouseCode() {
        return warehouseCode;
    }
        
    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
        
    public String getCountryCode() {
        return countryCode;
    }
        
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
        
    public String getMemberCode() {
        return memberCode;
    }
        
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
        
    public String getPiecesNo() {
        return piecesNo;
    }
        
    public void setPiecesNo(String piecesNo) {
        this.piecesNo = piecesNo;
    }
        
    public String getLogisticsNo() {
        return logisticsNo;
    }
        
    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }
        
    public BigDecimal getActualWeight() {
        return actualWeight;
    }
        
    public void setActualWeight(BigDecimal actualWeight) {
        this.actualWeight = actualWeight;
    }
        
    public BigDecimal getVolumeWeight() {
        return volumeWeight;
    }
        
    public void setVolumeWeight(BigDecimal volumeWeight) {
        this.volumeWeight = volumeWeight;
    }
        
    public BigDecimal getLength() {
        return length;
    }
        
    public void setLength(BigDecimal length) {
        this.length = length;
    }
        
    public BigDecimal getWidth() {
        return width;
    }
        
    public void setWidth(BigDecimal width) {
        this.width = width;
    }
        
    public BigDecimal getHeight() {
        return height;
    }
        
    public void setHeight(BigDecimal height) {
        this.height = height;
    }
        
    public Date getCheckDate() {
        return checkDate;
    }
        
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
        
    public String getMemo() {
        return memo;
    }
        
    public void setMemo(String memo) {
        this.memo = memo;
    }
        
    public Date getDeliveryDate() {
        return deliveryDate;
    }
        
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
        
    public Integer getIsBindDelivery() {
        return isBindDelivery;
    }
        
    public void setIsBindDelivery(Integer isBindDelivery) {
        this.isBindDelivery = isBindDelivery;
    }
        
    public Integer getTmConsignmentId() {
        return tmConsignmentId;
    }
        
    public void setTmConsignmentId(Integer tmConsignmentId) {
        this.tmConsignmentId = tmConsignmentId;
    }
        
    public String getConsignmentNo() {
        return consignmentNo;
    }
        
    public void setConsignmentNo(String consignmentNo) {
        this.consignmentNo = consignmentNo;
    }
        
    public String getServiceProductCode() {
        return serviceProductCode;
    }
        
    public void setServiceProductCode(String serviceProductCode) {
        this.serviceProductCode = serviceProductCode;
    }
        
    public String getUnitNo() {
        return unitNo;
    }
        
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }
        
    public Integer getTmUnitId() {
        return tmUnitId;
    }
        
    public void setTmUnitId(Integer tmUnitId) {
        this.tmUnitId = tmUnitId;
    }
        
    public String getSectorCode() {
        return sectorCode;
    }
        
    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }
        
    public Integer getTmSectorId() {
        return tmSectorId;
    }
        
    public void setTmSectorId(Integer tmSectorId) {
        this.tmSectorId = tmSectorId;
    }
        
    public String getOutBatchNo() {
        return outBatchNo;
    }
        
    public void setOutBatchNo(String outBatchNo) {
        this.outBatchNo = outBatchNo;
    }
        
    public Integer getTmOutBatchId() {
        return tmOutBatchId;
    }
        
    public void setTmOutBatchId(Integer tmOutBatchId) {
        this.tmOutBatchId = tmOutBatchId;
    }
        
    public String getDeliveryCode() {
        return deliveryCode;
    }
        
    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }
        
    public String getDeliveryNo() {
        return deliveryNo;
    }
        
    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
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