package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmConsignment extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmConsignmentId;
    private String consignmentNo;
    private String memberCode;
    private String idcardNo;
    private String idcardFullName;
    private String idcardAddress;
    private String shipperMemberCode;
    private String shipperName;
    private String shipperCompanyName;
    private String shipperCountryCode;
    private String shipperStateCode;
    private String shipperCityCode;
    private String shipperPostCode;
    private String shipperStreet;
    private String shipperMobileNo;
    private String shipperPhoneNo;
    private String shipperOtherContactNo;
    private String shipperChineseFullAddress;
    private String shipperEnglishFullAddress;
    private String consigneeName;
    private String consigneeCompanyName;
    private String consigneeCountryCode;
    private String consigneeStateCode;
    private String consigneeCityCode;
    private String consigneeDistrictCode;
    private String consigneePostCode;
    private String consigneeStreet;
    private String consigneeMobileNo;
    private String consigneePhoneNo;
    private String consigneeOtherContactNo;
    private String consigneeChineseFullAddress;
    private String consigneeEnglishFullAddress;
    private String totalGoodsDescription;
    private BigDecimal totalGoodsValue;
    private String totalGoodsValueCurrency;
    private BigDecimal totalQty;
    private BigDecimal totalWeight;
    private String origPort;
    private String destPort;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal volumeWeight;
    private BigDecimal applyWeight;
    private String actualUnit;
    private BigDecimal actualWeight;
    private String sellerName;
    private String convertUnit;
    private String sellerOrderNo;
    private String logisticsVendor;
    private String logisticsNo;
    private String warehouseCode;
    private String mawbCode;
    private String sectorCode;
    private Integer tmSectorId;
    private String deliveryVendor;
    private String deliveryNo;
    private Integer transferType;
    private String memo;
    private Date createTime;
    private Integer crAddressId;
    private String acturalWarehouseCode;
    private String remark;
    private String locCode;
    private String principle;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String createTimeZone;
    private String updateUserCode;
    private Date updateDateTime;
    private String updateTimeZone;
    private String idcardFrontImg;
    private String idcardBackImg;
    private Integer mctApiRequestId;
    private String sourceRequestId;
    private String dataSource;
    private String refLogisticsNo;
    private String serviceProductCode;
    
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
        
    public String getMemberCode() {
        return memberCode;
    }
        
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
        
    public String getIdcardNo() {
        return idcardNo;
    }
        
    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }
        
    public String getIdcardFullName() {
        return idcardFullName;
    }
        
    public void setIdcardFullName(String idcardFullName) {
        this.idcardFullName = idcardFullName;
    }
        
    public String getIdcardAddress() {
        return idcardAddress;
    }
        
    public void setIdcardAddress(String idcardAddress) {
        this.idcardAddress = idcardAddress;
    }
        
    public String getShipperMemberCode() {
        return shipperMemberCode;
    }
        
    public void setShipperMemberCode(String shipperMemberCode) {
        this.shipperMemberCode = shipperMemberCode;
    }
        
    public String getShipperName() {
        return shipperName;
    }
        
    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }
        
    public String getShipperCompanyName() {
        return shipperCompanyName;
    }
        
    public void setShipperCompanyName(String shipperCompanyName) {
        this.shipperCompanyName = shipperCompanyName;
    }
        
    public String getShipperCountryCode() {
        return shipperCountryCode;
    }
        
    public void setShipperCountryCode(String shipperCountryCode) {
        this.shipperCountryCode = shipperCountryCode;
    }
        
    public String getShipperStateCode() {
        return shipperStateCode;
    }
        
    public void setShipperStateCode(String shipperStateCode) {
        this.shipperStateCode = shipperStateCode;
    }
        
    public String getShipperCityCode() {
        return shipperCityCode;
    }
        
    public void setShipperCityCode(String shipperCityCode) {
        this.shipperCityCode = shipperCityCode;
    }
        
    public String getShipperPostCode() {
        return shipperPostCode;
    }
        
    public void setShipperPostCode(String shipperPostCode) {
        this.shipperPostCode = shipperPostCode;
    }
        
    public String getShipperStreet() {
        return shipperStreet;
    }
        
    public void setShipperStreet(String shipperStreet) {
        this.shipperStreet = shipperStreet;
    }
        
    public String getShipperMobileNo() {
        return shipperMobileNo;
    }
        
    public void setShipperMobileNo(String shipperMobileNo) {
        this.shipperMobileNo = shipperMobileNo;
    }
        
    public String getShipperPhoneNo() {
        return shipperPhoneNo;
    }
        
    public void setShipperPhoneNo(String shipperPhoneNo) {
        this.shipperPhoneNo = shipperPhoneNo;
    }
        
    public String getShipperOtherContactNo() {
        return shipperOtherContactNo;
    }
        
    public void setShipperOtherContactNo(String shipperOtherContactNo) {
        this.shipperOtherContactNo = shipperOtherContactNo;
    }
        
    public String getShipperChineseFullAddress() {
        return shipperChineseFullAddress;
    }
        
    public void setShipperChineseFullAddress(String shipperChineseFullAddress) {
        this.shipperChineseFullAddress = shipperChineseFullAddress;
    }
        
    public String getShipperEnglishFullAddress() {
        return shipperEnglishFullAddress;
    }
        
    public void setShipperEnglishFullAddress(String shipperEnglishFullAddress) {
        this.shipperEnglishFullAddress = shipperEnglishFullAddress;
    }
        
    public String getConsigneeName() {
        return consigneeName;
    }
        
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }
        
    public String getConsigneeCompanyName() {
        return consigneeCompanyName;
    }
        
    public void setConsigneeCompanyName(String consigneeCompanyName) {
        this.consigneeCompanyName = consigneeCompanyName;
    }
        
    public String getConsigneeCountryCode() {
        return consigneeCountryCode;
    }
        
    public void setConsigneeCountryCode(String consigneeCountryCode) {
        this.consigneeCountryCode = consigneeCountryCode;
    }
        
    public String getConsigneeStateCode() {
        return consigneeStateCode;
    }
        
    public void setConsigneeStateCode(String consigneeStateCode) {
        this.consigneeStateCode = consigneeStateCode;
    }
        
    public String getConsigneeCityCode() {
        return consigneeCityCode;
    }
        
    public void setConsigneeCityCode(String consigneeCityCode) {
        this.consigneeCityCode = consigneeCityCode;
    }
        
    public String getConsigneeDistrictCode() {
        return consigneeDistrictCode;
    }
        
    public void setConsigneeDistrictCode(String consigneeDistrictCode) {
        this.consigneeDistrictCode = consigneeDistrictCode;
    }
        
    public String getConsigneePostCode() {
        return consigneePostCode;
    }
        
    public void setConsigneePostCode(String consigneePostCode) {
        this.consigneePostCode = consigneePostCode;
    }
        
    public String getConsigneeStreet() {
        return consigneeStreet;
    }
        
    public void setConsigneeStreet(String consigneeStreet) {
        this.consigneeStreet = consigneeStreet;
    }
        
    public String getConsigneeMobileNo() {
        return consigneeMobileNo;
    }
        
    public void setConsigneeMobileNo(String consigneeMobileNo) {
        this.consigneeMobileNo = consigneeMobileNo;
    }
        
    public String getConsigneePhoneNo() {
        return consigneePhoneNo;
    }
        
    public void setConsigneePhoneNo(String consigneePhoneNo) {
        this.consigneePhoneNo = consigneePhoneNo;
    }
        
    public String getConsigneeOtherContactNo() {
        return consigneeOtherContactNo;
    }
        
    public void setConsigneeOtherContactNo(String consigneeOtherContactNo) {
        this.consigneeOtherContactNo = consigneeOtherContactNo;
    }
        
    public String getConsigneeChineseFullAddress() {
        return consigneeChineseFullAddress;
    }
        
    public void setConsigneeChineseFullAddress(String consigneeChineseFullAddress) {
        this.consigneeChineseFullAddress = consigneeChineseFullAddress;
    }
        
    public String getConsigneeEnglishFullAddress() {
        return consigneeEnglishFullAddress;
    }
        
    public void setConsigneeEnglishFullAddress(String consigneeEnglishFullAddress) {
        this.consigneeEnglishFullAddress = consigneeEnglishFullAddress;
    }
        
    public String getTotalGoodsDescription() {
        return totalGoodsDescription;
    }
        
    public void setTotalGoodsDescription(String totalGoodsDescription) {
        this.totalGoodsDescription = totalGoodsDescription;
    }
        
    public BigDecimal getTotalGoodsValue() {
        return totalGoodsValue;
    }
        
    public void setTotalGoodsValue(BigDecimal totalGoodsValue) {
        this.totalGoodsValue = totalGoodsValue;
    }
        
    public String getTotalGoodsValueCurrency() {
        return totalGoodsValueCurrency;
    }
        
    public void setTotalGoodsValueCurrency(String totalGoodsValueCurrency) {
        this.totalGoodsValueCurrency = totalGoodsValueCurrency;
    }
        
    public BigDecimal getTotalQty() {
        return totalQty;
    }
        
    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }
        
    public BigDecimal getTotalWeight() {
        return totalWeight;
    }
        
    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }
        
    public String getOrigPort() {
        return origPort;
    }
        
    public void setOrigPort(String origPort) {
        this.origPort = origPort;
    }
        
    public String getDestPort() {
        return destPort;
    }
        
    public void setDestPort(String destPort) {
        this.destPort = destPort;
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
        
    public BigDecimal getVolumeWeight() {
        return volumeWeight;
    }
        
    public void setVolumeWeight(BigDecimal volumeWeight) {
        this.volumeWeight = volumeWeight;
    }
        
    public BigDecimal getApplyWeight() {
        return applyWeight;
    }
        
    public void setApplyWeight(BigDecimal applyWeight) {
        this.applyWeight = applyWeight;
    }
        
    public String getActualUnit() {
        return actualUnit;
    }
        
    public void setActualUnit(String actualUnit) {
        this.actualUnit = actualUnit;
    }
        
    public BigDecimal getActualWeight() {
        return actualWeight;
    }
        
    public void setActualWeight(BigDecimal actualWeight) {
        this.actualWeight = actualWeight;
    }
        
    public String getSellerName() {
        return sellerName;
    }
        
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
        
    public String getConvertUnit() {
        return convertUnit;
    }
        
    public void setConvertUnit(String convertUnit) {
        this.convertUnit = convertUnit;
    }
        
    public String getSellerOrderNo() {
        return sellerOrderNo;
    }
        
    public void setSellerOrderNo(String sellerOrderNo) {
        this.sellerOrderNo = sellerOrderNo;
    }
        
    public String getLogisticsVendor() {
        return logisticsVendor;
    }
        
    public void setLogisticsVendor(String logisticsVendor) {
        this.logisticsVendor = logisticsVendor;
    }
        
    public String getLogisticsNo() {
        return logisticsNo;
    }
        
    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }
        
    public String getWarehouseCode() {
        return warehouseCode;
    }
        
    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
        
    public String getMawbCode() {
        return mawbCode;
    }
        
    public void setMawbCode(String mawbCode) {
        this.mawbCode = mawbCode;
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
        
    public String getDeliveryVendor() {
        return deliveryVendor;
    }
        
    public void setDeliveryVendor(String deliveryVendor) {
        this.deliveryVendor = deliveryVendor;
    }
        
    public String getDeliveryNo() {
        return deliveryNo;
    }
        
    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }
        
    public Integer getTransferType() {
        return transferType;
    }
        
    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }
        
    public String getMemo() {
        return memo;
    }
        
    public void setMemo(String memo) {
        this.memo = memo;
    }
        
    public Date getCreateTime() {
        return createTime;
    }
        
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Integer getCrAddressId() {
        return crAddressId;
    }
        
    public void setCrAddressId(Integer crAddressId) {
        this.crAddressId = crAddressId;
    }
        
    public String getActuralWarehouseCode() {
        return acturalWarehouseCode;
    }
        
    public void setActuralWarehouseCode(String acturalWarehouseCode) {
        this.acturalWarehouseCode = acturalWarehouseCode;
    }
        
    public String getRemark() {
        return remark;
    }
        
    public void setRemark(String remark) {
        this.remark = remark;
    }
        
    public String getLocCode() {
        return locCode;
    }
        
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }
        
    public String getPrinciple() {
        return principle;
    }
        
    public void setPrinciple(String principle) {
        this.principle = principle;
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
        
    public String getIdcardFrontImg() {
        return idcardFrontImg;
    }
        
    public void setIdcardFrontImg(String idcardFrontImg) {
        this.idcardFrontImg = idcardFrontImg;
    }
        
    public String getIdcardBackImg() {
        return idcardBackImg;
    }
        
    public void setIdcardBackImg(String idcardBackImg) {
        this.idcardBackImg = idcardBackImg;
    }
        
    public Integer getMctApiRequestId() {
        return mctApiRequestId;
    }
        
    public void setMctApiRequestId(Integer mctApiRequestId) {
        this.mctApiRequestId = mctApiRequestId;
    }
        
    public String getSourceRequestId() {
        return sourceRequestId;
    }
        
    public void setSourceRequestId(String sourceRequestId) {
        this.sourceRequestId = sourceRequestId;
    }
        
    public String getDataSource() {
        return dataSource;
    }
        
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
        
    public String getRefLogisticsNo() {
        return refLogisticsNo;
    }
        
    public void setRefLogisticsNo(String refLogisticsNo) {
        this.refLogisticsNo = refLogisticsNo;
    }
        
    public String getServiceProductCode() {
        return serviceProductCode;
    }
        
    public void setServiceProductCode(String serviceProductCode) {
        this.serviceProductCode = serviceProductCode;
    }
        
}