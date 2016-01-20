package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmConsignmentItem extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmConsignmentItemId;
    private Integer tmConsignmentId;
    private String consignmentNo;
    private Integer seq;
    private String goodsCode;
    private String goodsDescription;
    private String brandName;
    private BigDecimal actualWeight;
    private BigDecimal applyWeight;
    private BigDecimal volumeWeight;
    private BigDecimal piecesItemQty;
    private BigDecimal unitPrice;
    private String unitCode;
    private BigDecimal amount;
    private String currency;
    private String spec;
    private BigDecimal tariff;
    private String goodsUrl;
    private String tariffNumber;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getTmConsignmentItemId() {
        return tmConsignmentItemId;
    }
        
    public void setTmConsignmentItemId(Integer tmConsignmentItemId) {
        this.tmConsignmentItemId = tmConsignmentItemId;
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
        
    public Integer getSeq() {
        return seq;
    }
        
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
        
    public String getGoodsCode() {
        return goodsCode;
    }
        
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
        
    public String getGoodsDescription() {
        return goodsDescription;
    }
        
    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }
        
    public String getBrandName() {
        return brandName;
    }
        
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
        
    public BigDecimal getActualWeight() {
        return actualWeight;
    }
        
    public void setActualWeight(BigDecimal actualWeight) {
        this.actualWeight = actualWeight;
    }
        
    public BigDecimal getApplyWeight() {
        return applyWeight;
    }
        
    public void setApplyWeight(BigDecimal applyWeight) {
        this.applyWeight = applyWeight;
    }
        
    public BigDecimal getVolumeWeight() {
        return volumeWeight;
    }
        
    public void setVolumeWeight(BigDecimal volumeWeight) {
        this.volumeWeight = volumeWeight;
    }
        
    public BigDecimal getPiecesItemQty() {
        return piecesItemQty;
    }
        
    public void setPiecesItemQty(BigDecimal piecesItemQty) {
        this.piecesItemQty = piecesItemQty;
    }
        
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
        
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
        
    public String getUnitCode() {
        return unitCode;
    }
        
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }
        
    public BigDecimal getAmount() {
        return amount;
    }
        
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
        
    public String getCurrency() {
        return currency;
    }
        
    public void setCurrency(String currency) {
        this.currency = currency;
    }
        
    public String getSpec() {
        return spec;
    }
        
    public void setSpec(String spec) {
        this.spec = spec;
    }
        
    public BigDecimal getTariff() {
        return tariff;
    }
        
    public void setTariff(BigDecimal tariff) {
        this.tariff = tariff;
    }
        
    public String getGoodsUrl() {
        return goodsUrl;
    }
        
    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }
        
    public String getTariffNumber() {
        return tariffNumber;
    }
        
    public void setTariffNumber(String tariffNumber) {
        this.tariffNumber = tariffNumber;
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