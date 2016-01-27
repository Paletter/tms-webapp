package com.palette.busi.project.tms.core.dao;

import java.util.List;
import java.math.BigDecimal;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.palette.busi.project.tms.core.entity.TmConsignment;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class TmConsignmentSqlProvider extends BaseSqlProvider {

	public String update(TmConsignment record) {
		BEGIN();
        UPDATE("tm_consignment");
        if (record.getTmConsignmentId() != null) {
            SET("TM_CONSIGNMENT_ID = #{tmConsignmentId}");
        }
        if (record.getConsignmentNo() != null) {
            SET("CONSIGNMENT_NO = #{consignmentNo}");
        }
        if (record.getMemberCode() != null) {
            SET("MEMBER_CODE = #{memberCode}");
        }
        if (record.getIdcardNo() != null) {
            SET("IDCARD_NO = #{idcardNo}");
        }
        if (record.getIdcardFullName() != null) {
            SET("IDCARD_FULL_NAME = #{idcardFullName}");
        }
        if (record.getIdcardAddress() != null) {
            SET("IDCARD_ADDRESS = #{idcardAddress}");
        }
        if (record.getShipperMemberCode() != null) {
            SET("SHIPPER_MEMBER_CODE = #{shipperMemberCode}");
        }
        if (record.getShipperName() != null) {
            SET("SHIPPER_NAME = #{shipperName}");
        }
        if (record.getShipperCompanyName() != null) {
            SET("SHIPPER_COMPANY_NAME = #{shipperCompanyName}");
        }
        if (record.getShipperCountryCode() != null) {
            SET("SHIPPER_COUNTRY_CODE = #{shipperCountryCode}");
        }
        if (record.getShipperStateCode() != null) {
            SET("SHIPPER_STATE_CODE = #{shipperStateCode}");
        }
        if (record.getShipperCityCode() != null) {
            SET("SHIPPER_CITY_CODE = #{shipperCityCode}");
        }
        if (record.getShipperPostCode() != null) {
            SET("SHIPPER_POST_CODE = #{shipperPostCode}");
        }
        if (record.getShipperStreet() != null) {
            SET("SHIPPER_STREET = #{shipperStreet}");
        }
        if (record.getShipperMobileNo() != null) {
            SET("SHIPPER_MOBILE_NO = #{shipperMobileNo}");
        }
        if (record.getShipperPhoneNo() != null) {
            SET("SHIPPER_PHONE_NO = #{shipperPhoneNo}");
        }
        if (record.getShipperOtherContactNo() != null) {
            SET("SHIPPER_OTHER_CONTACT_NO = #{shipperOtherContactNo}");
        }
        if (record.getShipperChineseFullAddress() != null) {
            SET("SHIPPER_CHINESE_FULL_ADDRESS = #{shipperChineseFullAddress}");
        }
        if (record.getShipperEnglishFullAddress() != null) {
            SET("SHIPPER_ENGLISH_FULL_ADDRESS = #{shipperEnglishFullAddress}");
        }
        if (record.getConsigneeName() != null) {
            SET("CONSIGNEE_NAME = #{consigneeName}");
        }
        if (record.getConsigneeCompanyName() != null) {
            SET("CONSIGNEE_COMPANY_NAME = #{consigneeCompanyName}");
        }
        if (record.getConsigneeCountryCode() != null) {
            SET("CONSIGNEE_COUNTRY_CODE = #{consigneeCountryCode}");
        }
        if (record.getConsigneeStateCode() != null) {
            SET("CONSIGNEE_STATE_CODE = #{consigneeStateCode}");
        }
        if (record.getConsigneeCityCode() != null) {
            SET("CONSIGNEE_CITY_CODE = #{consigneeCityCode}");
        }
        if (record.getConsigneeDistrictCode() != null) {
            SET("CONSIGNEE_DISTRICT_CODE = #{consigneeDistrictCode}");
        }
        if (record.getConsigneePostCode() != null) {
            SET("CONSIGNEE_POST_CODE = #{consigneePostCode}");
        }
        if (record.getConsigneeStreet() != null) {
            SET("CONSIGNEE_STREET = #{consigneeStreet}");
        }
        if (record.getConsigneeMobileNo() != null) {
            SET("CONSIGNEE_MOBILE_NO = #{consigneeMobileNo}");
        }
        if (record.getConsigneePhoneNo() != null) {
            SET("CONSIGNEE_PHONE_NO = #{consigneePhoneNo}");
        }
        if (record.getConsigneeOtherContactNo() != null) {
            SET("CONSIGNEE_OTHER_CONTACT_NO = #{consigneeOtherContactNo}");
        }
        if (record.getConsigneeChineseFullAddress() != null) {
            SET("CONSIGNEE_CHINESE_FULL_ADDRESS = #{consigneeChineseFullAddress}");
        }
        if (record.getConsigneeEnglishFullAddress() != null) {
            SET("CONSIGNEE_ENGLISH_FULL_ADDRESS = #{consigneeEnglishFullAddress}");
        }
        if (record.getTotalGoodsDescription() != null) {
            SET("TOTAL_GOODS_DESCRIPTION = #{totalGoodsDescription}");
        }
        if (record.getTotalGoodsValue() != null) {
            SET("TOTAL_GOODS_VALUE = #{totalGoodsValue}");
        }
        if (record.getTotalGoodsValueCurrency() != null) {
            SET("TOTAL_GOODS_VALUE_CURRENCY = #{totalGoodsValueCurrency}");
        }
        if (record.getTotalQty() != null) {
            SET("TOTAL_QTY = #{totalQty}");
        }
        if (record.getTotalWeight() != null) {
            SET("TOTAL_WEIGHT = #{totalWeight}");
        }
        if (record.getOrigPort() != null) {
            SET("ORIG_PORT = #{origPort}");
        }
        if (record.getDestPort() != null) {
            SET("DEST_PORT = #{destPort}");
        }
        if (record.getLength() != null) {
            SET("LENGTH = #{length}");
        }
        if (record.getWidth() != null) {
            SET("WIDTH = #{width}");
        }
        if (record.getHeight() != null) {
            SET("HEIGHT = #{height}");
        }
        if (record.getVolumeWeight() != null) {
            SET("VOLUME_WEIGHT = #{volumeWeight}");
        }
        if (record.getApplyWeight() != null) {
            SET("APPLY_WEIGHT = #{applyWeight}");
        }
        if (record.getActualUnit() != null) {
            SET("ACTUAL_UNIT = #{actualUnit}");
        }
        if (record.getActualWeight() != null) {
            SET("ACTUAL_WEIGHT = #{actualWeight}");
        }
        if (record.getSellerName() != null) {
            SET("SELLER_NAME = #{sellerName}");
        }
        if (record.getConvertUnit() != null) {
            SET("CONVERT_UNIT = #{convertUnit}");
        }
        if (record.getSellerOrderNo() != null) {
            SET("SELLER_ORDER_NO = #{sellerOrderNo}");
        }
        if (record.getLogisticsVendor() != null) {
            SET("LOGISTICS_VENDOR = #{logisticsVendor}");
        }
        if (record.getLogisticsNo() != null) {
            SET("LOGISTICS_NO = #{logisticsNo}");
        }
        if (record.getWarehouseCode() != null) {
            SET("WAREHOUSE_CODE = #{warehouseCode}");
        }
        if (record.getMawbCode() != null) {
            SET("MAWB_CODE = #{mawbCode}");
        }
        if (record.getSectorCode() != null) {
            SET("SECTOR_CODE = #{sectorCode}");
        }
        if (record.getTmSectorId() != null) {
            SET("TM_SECTOR_ID = #{tmSectorId}");
        }
        if (record.getDeliveryVendor() != null) {
            SET("DELIVERY_VENDOR = #{deliveryVendor}");
        }
        if (record.getDeliveryNo() != null) {
            SET("DELIVERY_NO = #{deliveryNo}");
        }
        if (record.getTransferType() != null) {
            SET("TRANSFER_TYPE = #{transferType}");
        }
        if (record.getMemo() != null) {
            SET("MEMO = #{memo}");
        }
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime}");
        }
        if (record.getCrAddressId() != null) {
            SET("CR_ADDRESS_ID = #{crAddressId}");
        }
        if (record.getActuralWarehouseCode() != null) {
            SET("ACTURAL_WAREHOUSE_CODE = #{acturalWarehouseCode}");
        }
        if (record.getRemark() != null) {
            SET("REMARK = #{remark}");
        }
        if (record.getLocCode() != null) {
            SET("LOC_CODE = #{locCode}");
        }
        if (record.getPrinciple() != null) {
            SET("PRINCIPLE = #{principle}");
        }
        if (record.getRecordVersion() != null) {
            SET("RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCompanyCode() != null) {
            SET("COMPANY_CODE = #{companyCode}");
        }
        if (record.getCreateUserCode() != null) {
            SET("CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getCreateDateTime() != null) {
            SET("CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getCreateTimeZone() != null) {
            SET("CREATE_TIME_ZONE = #{createTimeZone}");
        }
        if (record.getUpdateUserCode() != null) {
            SET("UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            SET("UPDATE_DATE_TIME = #{updateDateTime}");
        }
        if (record.getUpdateTimeZone() != null) {
            SET("UPDATE_TIME_ZONE = #{updateTimeZone}");
        }
        if (record.getIdcardFrontImg() != null) {
            SET("IDCARD_FRONT_IMG = #{idcardFrontImg}");
        }
        if (record.getIdcardBackImg() != null) {
            SET("IDCARD_BACK_IMG = #{idcardBackImg}");
        }
        if (record.getMctApiRequestId() != null) {
            SET("MCT_API_REQUEST_ID = #{mctApiRequestId}");
        }
        if (record.getSourceRequestId() != null) {
            SET("SOURCE_REQUEST_ID = #{sourceRequestId}");
        }
        if (record.getDataSource() != null) {
            SET("DATA_SOURCE = #{dataSource}");
        }
        if (record.getRefLogisticsNo() != null) {
            SET("REF_LOGISTICS_NO = #{refLogisticsNo}");
        }
        if (record.getServiceProductCode() != null) {
            SET("SERVICE_PRODUCT_CODE = #{serviceProductCode}");
        }

        WHERE("tm_consignment_id = #{tmConsignmentId}");

        return SQL();
	}

    public String selectAllByRecord(TmConsignment record) {
        BEGIN();
        SELECT("*");
        FROM("tm_consignment");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getTmConsignmentId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_ID = #{tmConsignmentId}");
        }
        if (record.getConsignmentNo() != null) {
            stringBuffer.append(" AND CONSIGNMENT_NO = #{consignmentNo}");
        }
        if (record.getMemberCode() != null) {
            stringBuffer.append(" AND MEMBER_CODE = #{memberCode}");
        }
        if (record.getIdcardNo() != null) {
            stringBuffer.append(" AND IDCARD_NO = #{idcardNo}");
        }
        if (record.getIdcardFullName() != null) {
            stringBuffer.append(" AND IDCARD_FULL_NAME = #{idcardFullName}");
        }
        if (record.getIdcardAddress() != null) {
            stringBuffer.append(" AND IDCARD_ADDRESS = #{idcardAddress}");
        }
        if (record.getShipperMemberCode() != null) {
            stringBuffer.append(" AND SHIPPER_MEMBER_CODE = #{shipperMemberCode}");
        }
        if (record.getShipperName() != null) {
            stringBuffer.append(" AND SHIPPER_NAME = #{shipperName}");
        }
        if (record.getShipperCompanyName() != null) {
            stringBuffer.append(" AND SHIPPER_COMPANY_NAME = #{shipperCompanyName}");
        }
        if (record.getShipperCountryCode() != null) {
            stringBuffer.append(" AND SHIPPER_COUNTRY_CODE = #{shipperCountryCode}");
        }
        if (record.getShipperStateCode() != null) {
            stringBuffer.append(" AND SHIPPER_STATE_CODE = #{shipperStateCode}");
        }
        if (record.getShipperCityCode() != null) {
            stringBuffer.append(" AND SHIPPER_CITY_CODE = #{shipperCityCode}");
        }
        if (record.getShipperPostCode() != null) {
            stringBuffer.append(" AND SHIPPER_POST_CODE = #{shipperPostCode}");
        }
        if (record.getShipperStreet() != null) {
            stringBuffer.append(" AND SHIPPER_STREET = #{shipperStreet}");
        }
        if (record.getShipperMobileNo() != null) {
            stringBuffer.append(" AND SHIPPER_MOBILE_NO = #{shipperMobileNo}");
        }
        if (record.getShipperPhoneNo() != null) {
            stringBuffer.append(" AND SHIPPER_PHONE_NO = #{shipperPhoneNo}");
        }
        if (record.getShipperOtherContactNo() != null) {
            stringBuffer.append(" AND SHIPPER_OTHER_CONTACT_NO = #{shipperOtherContactNo}");
        }
        if (record.getShipperChineseFullAddress() != null) {
            stringBuffer.append(" AND SHIPPER_CHINESE_FULL_ADDRESS = #{shipperChineseFullAddress}");
        }
        if (record.getShipperEnglishFullAddress() != null) {
            stringBuffer.append(" AND SHIPPER_ENGLISH_FULL_ADDRESS = #{shipperEnglishFullAddress}");
        }
        if (record.getConsigneeName() != null) {
            stringBuffer.append(" AND CONSIGNEE_NAME = #{consigneeName}");
        }
        if (record.getConsigneeCompanyName() != null) {
            stringBuffer.append(" AND CONSIGNEE_COMPANY_NAME = #{consigneeCompanyName}");
        }
        if (record.getConsigneeCountryCode() != null) {
            stringBuffer.append(" AND CONSIGNEE_COUNTRY_CODE = #{consigneeCountryCode}");
        }
        if (record.getConsigneeStateCode() != null) {
            stringBuffer.append(" AND CONSIGNEE_STATE_CODE = #{consigneeStateCode}");
        }
        if (record.getConsigneeCityCode() != null) {
            stringBuffer.append(" AND CONSIGNEE_CITY_CODE = #{consigneeCityCode}");
        }
        if (record.getConsigneeDistrictCode() != null) {
            stringBuffer.append(" AND CONSIGNEE_DISTRICT_CODE = #{consigneeDistrictCode}");
        }
        if (record.getConsigneePostCode() != null) {
            stringBuffer.append(" AND CONSIGNEE_POST_CODE = #{consigneePostCode}");
        }
        if (record.getConsigneeStreet() != null) {
            stringBuffer.append(" AND CONSIGNEE_STREET = #{consigneeStreet}");
        }
        if (record.getConsigneeMobileNo() != null) {
            stringBuffer.append(" AND CONSIGNEE_MOBILE_NO = #{consigneeMobileNo}");
        }
        if (record.getConsigneePhoneNo() != null) {
            stringBuffer.append(" AND CONSIGNEE_PHONE_NO = #{consigneePhoneNo}");
        }
        if (record.getConsigneeOtherContactNo() != null) {
            stringBuffer.append(" AND CONSIGNEE_OTHER_CONTACT_NO = #{consigneeOtherContactNo}");
        }
        if (record.getConsigneeChineseFullAddress() != null) {
            stringBuffer.append(" AND CONSIGNEE_CHINESE_FULL_ADDRESS = #{consigneeChineseFullAddress}");
        }
        if (record.getConsigneeEnglishFullAddress() != null) {
            stringBuffer.append(" AND CONSIGNEE_ENGLISH_FULL_ADDRESS = #{consigneeEnglishFullAddress}");
        }
        if (record.getTotalGoodsDescription() != null) {
            stringBuffer.append(" AND TOTAL_GOODS_DESCRIPTION = #{totalGoodsDescription}");
        }
        if (record.getTotalGoodsValue() != null) {
            stringBuffer.append(" AND TOTAL_GOODS_VALUE = #{totalGoodsValue}");
        }
        if (record.getTotalGoodsValueCurrency() != null) {
            stringBuffer.append(" AND TOTAL_GOODS_VALUE_CURRENCY = #{totalGoodsValueCurrency}");
        }
        if (record.getTotalQty() != null) {
            stringBuffer.append(" AND TOTAL_QTY = #{totalQty}");
        }
        if (record.getTotalWeight() != null) {
            stringBuffer.append(" AND TOTAL_WEIGHT = #{totalWeight}");
        }
        if (record.getOrigPort() != null) {
            stringBuffer.append(" AND ORIG_PORT = #{origPort}");
        }
        if (record.getDestPort() != null) {
            stringBuffer.append(" AND DEST_PORT = #{destPort}");
        }
        if (record.getLength() != null) {
            stringBuffer.append(" AND LENGTH = #{length}");
        }
        if (record.getWidth() != null) {
            stringBuffer.append(" AND WIDTH = #{width}");
        }
        if (record.getHeight() != null) {
            stringBuffer.append(" AND HEIGHT = #{height}");
        }
        if (record.getVolumeWeight() != null) {
            stringBuffer.append(" AND VOLUME_WEIGHT = #{volumeWeight}");
        }
        if (record.getApplyWeight() != null) {
            stringBuffer.append(" AND APPLY_WEIGHT = #{applyWeight}");
        }
        if (record.getActualUnit() != null) {
            stringBuffer.append(" AND ACTUAL_UNIT = #{actualUnit}");
        }
        if (record.getActualWeight() != null) {
            stringBuffer.append(" AND ACTUAL_WEIGHT = #{actualWeight}");
        }
        if (record.getSellerName() != null) {
            stringBuffer.append(" AND SELLER_NAME = #{sellerName}");
        }
        if (record.getConvertUnit() != null) {
            stringBuffer.append(" AND CONVERT_UNIT = #{convertUnit}");
        }
        if (record.getSellerOrderNo() != null) {
            stringBuffer.append(" AND SELLER_ORDER_NO = #{sellerOrderNo}");
        }
        if (record.getLogisticsVendor() != null) {
            stringBuffer.append(" AND LOGISTICS_VENDOR = #{logisticsVendor}");
        }
        if (record.getLogisticsNo() != null) {
            stringBuffer.append(" AND LOGISTICS_NO = #{logisticsNo}");
        }
        if (record.getWarehouseCode() != null) {
            stringBuffer.append(" AND WAREHOUSE_CODE = #{warehouseCode}");
        }
        if (record.getMawbCode() != null) {
            stringBuffer.append(" AND MAWB_CODE = #{mawbCode}");
        }
        if (record.getSectorCode() != null) {
            stringBuffer.append(" AND SECTOR_CODE = #{sectorCode}");
        }
        if (record.getTmSectorId() != null) {
            stringBuffer.append(" AND TM_SECTOR_ID = #{tmSectorId}");
        }
        if (record.getDeliveryVendor() != null) {
            stringBuffer.append(" AND DELIVERY_VENDOR = #{deliveryVendor}");
        }
        if (record.getDeliveryNo() != null) {
            stringBuffer.append(" AND DELIVERY_NO = #{deliveryNo}");
        }
        if (record.getTransferType() != null) {
            stringBuffer.append(" AND TRANSFER_TYPE = #{transferType}");
        }
        if (record.getMemo() != null) {
            stringBuffer.append(" AND MEMO = #{memo}");
        }
        if (record.getCreateTime() != null) {
            stringBuffer.append(" AND CREATE_TIME = #{createTime}");
        }
        if (record.getCrAddressId() != null) {
            stringBuffer.append(" AND CR_ADDRESS_ID = #{crAddressId}");
        }
        if (record.getActuralWarehouseCode() != null) {
            stringBuffer.append(" AND ACTURAL_WAREHOUSE_CODE = #{acturalWarehouseCode}");
        }
        if (record.getRemark() != null) {
            stringBuffer.append(" AND REMARK = #{remark}");
        }
        if (record.getLocCode() != null) {
            stringBuffer.append(" AND LOC_CODE = #{locCode}");
        }
        if (record.getPrinciple() != null) {
            stringBuffer.append(" AND PRINCIPLE = #{principle}");
        }
        if (record.getRecordVersion() != null) {
            stringBuffer.append(" AND RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCompanyCode() != null) {
            stringBuffer.append(" AND COMPANY_CODE = #{companyCode}");
        }
        if (record.getCreateUserCode() != null) {
            stringBuffer.append(" AND CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getCreateDateTime() != null) {
            stringBuffer.append(" AND CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getCreateTimeZone() != null) {
            stringBuffer.append(" AND CREATE_TIME_ZONE = #{createTimeZone}");
        }
        if (record.getUpdateUserCode() != null) {
            stringBuffer.append(" AND UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            stringBuffer.append(" AND UPDATE_DATE_TIME = #{updateDateTime}");
        }
        if (record.getUpdateTimeZone() != null) {
            stringBuffer.append(" AND UPDATE_TIME_ZONE = #{updateTimeZone}");
        }
        if (record.getIdcardFrontImg() != null) {
            stringBuffer.append(" AND IDCARD_FRONT_IMG = #{idcardFrontImg}");
        }
        if (record.getIdcardBackImg() != null) {
            stringBuffer.append(" AND IDCARD_BACK_IMG = #{idcardBackImg}");
        }
        if (record.getMctApiRequestId() != null) {
            stringBuffer.append(" AND MCT_API_REQUEST_ID = #{mctApiRequestId}");
        }
        if (record.getSourceRequestId() != null) {
            stringBuffer.append(" AND SOURCE_REQUEST_ID = #{sourceRequestId}");
        }
        if (record.getDataSource() != null) {
            stringBuffer.append(" AND DATA_SOURCE = #{dataSource}");
        }
        if (record.getRefLogisticsNo() != null) {
            stringBuffer.append(" AND REF_LOGISTICS_NO = #{refLogisticsNo}");
        }
        if (record.getServiceProductCode() != null) {
            stringBuffer.append(" AND SERVICE_PRODUCT_CODE = #{serviceProductCode}");
        }

        WHERE(stringBuffer.toString());

        return SQL();
    }
}
