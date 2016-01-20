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

import com.palette.busi.project.tms.core.entity.TmConsignmentItem;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class TmConsignmentItemSqlProvider extends BaseSqlProvider {

	public String update(TmConsignmentItem record) {
		BEGIN();
        UPDATE("tm_consignment_item");
        if (record.getTmConsignmentItemId() != null) {
            SET("TM_CONSIGNMENT_ITEM_ID = #{tmConsignmentItemId}");
        }
        if (record.getTmConsignmentId() != null) {
            SET("TM_CONSIGNMENT_ID = #{tmConsignmentId}");
        }
        if (record.getConsignmentNo() != null) {
            SET("CONSIGNMENT_NO = #{consignmentNo}");
        }
        if (record.getSeq() != null) {
            SET("SEQ = #{seq}");
        }
        if (record.getGoodsCode() != null) {
            SET("GOODS_CODE = #{goodsCode}");
        }
        if (record.getGoodsDescription() != null) {
            SET("GOODS_DESCRIPTION = #{goodsDescription}");
        }
        if (record.getBrandName() != null) {
            SET("BRAND_NAME = #{brandName}");
        }
        if (record.getActualWeight() != null) {
            SET("ACTUAL_WEIGHT = #{actualWeight}");
        }
        if (record.getApplyWeight() != null) {
            SET("APPLY_WEIGHT = #{applyWeight}");
        }
        if (record.getVolumeWeight() != null) {
            SET("VOLUME_WEIGHT = #{volumeWeight}");
        }
        if (record.getPiecesItemQty() != null) {
            SET("PIECES_ITEM_QTY = #{piecesItemQty}");
        }
        if (record.getUnitPrice() != null) {
            SET("UNIT_PRICE = #{unitPrice}");
        }
        if (record.getUnitCode() != null) {
            SET("UNIT_CODE = #{unitCode}");
        }
        if (record.getAmount() != null) {
            SET("AMOUNT = #{amount}");
        }
        if (record.getCurrency() != null) {
            SET("CURRENCY = #{currency}");
        }
        if (record.getSpec() != null) {
            SET("SPEC = #{spec}");
        }
        if (record.getTariff() != null) {
            SET("TARIFF = #{tariff}");
        }
        if (record.getGoodsUrl() != null) {
            SET("GOODS_URL = #{goodsUrl}");
        }
        if (record.getTariffNumber() != null) {
            SET("TARIFF_NUMBER = #{tariffNumber}");
        }
        if (record.getRecordVersion() != null) {
            SET("RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCreateUserCode() != null) {
            SET("CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getCreateDateTime() != null) {
            SET("CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getUpdateUserCode() != null) {
            SET("UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            SET("UPDATE_DATE_TIME = #{updateDateTime}");
        }

        WHERE("tm_consignment_item_id = #{tmConsignmentItemId}");

        return SQL();
	}

    public String selectAllByRecord(TmConsignmentItem record) {
        BEGIN();
        SELECT("*");
        FROM("tm_consignment_item");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getTmConsignmentItemId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_ITEM_ID = #{tmConsignmentItemId}");
        }
        if (record.getTmConsignmentId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_ID = #{tmConsignmentId}");
        }
        if (record.getConsignmentNo() != null) {
            stringBuffer.append(" AND CONSIGNMENT_NO = #{consignmentNo}");
        }
        if (record.getSeq() != null) {
            stringBuffer.append(" AND SEQ = #{seq}");
        }
        if (record.getGoodsCode() != null) {
            stringBuffer.append(" AND GOODS_CODE = #{goodsCode}");
        }
        if (record.getGoodsDescription() != null) {
            stringBuffer.append(" AND GOODS_DESCRIPTION = #{goodsDescription}");
        }
        if (record.getBrandName() != null) {
            stringBuffer.append(" AND BRAND_NAME = #{brandName}");
        }
        if (record.getActualWeight() != null) {
            stringBuffer.append(" AND ACTUAL_WEIGHT = #{actualWeight}");
        }
        if (record.getApplyWeight() != null) {
            stringBuffer.append(" AND APPLY_WEIGHT = #{applyWeight}");
        }
        if (record.getVolumeWeight() != null) {
            stringBuffer.append(" AND VOLUME_WEIGHT = #{volumeWeight}");
        }
        if (record.getPiecesItemQty() != null) {
            stringBuffer.append(" AND PIECES_ITEM_QTY = #{piecesItemQty}");
        }
        if (record.getUnitPrice() != null) {
            stringBuffer.append(" AND UNIT_PRICE = #{unitPrice}");
        }
        if (record.getUnitCode() != null) {
            stringBuffer.append(" AND UNIT_CODE = #{unitCode}");
        }
        if (record.getAmount() != null) {
            stringBuffer.append(" AND AMOUNT = #{amount}");
        }
        if (record.getCurrency() != null) {
            stringBuffer.append(" AND CURRENCY = #{currency}");
        }
        if (record.getSpec() != null) {
            stringBuffer.append(" AND SPEC = #{spec}");
        }
        if (record.getTariff() != null) {
            stringBuffer.append(" AND TARIFF = #{tariff}");
        }
        if (record.getGoodsUrl() != null) {
            stringBuffer.append(" AND GOODS_URL = #{goodsUrl}");
        }
        if (record.getTariffNumber() != null) {
            stringBuffer.append(" AND TARIFF_NUMBER = #{tariffNumber}");
        }
        if (record.getRecordVersion() != null) {
            stringBuffer.append(" AND RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCreateUserCode() != null) {
            stringBuffer.append(" AND CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getCreateDateTime() != null) {
            stringBuffer.append(" AND CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getUpdateUserCode() != null) {
            stringBuffer.append(" AND UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            stringBuffer.append(" AND UPDATE_DATE_TIME = #{updateDateTime}");
        }

        WHERE(stringBuffer.toString());

        return SQL();
    }
}
