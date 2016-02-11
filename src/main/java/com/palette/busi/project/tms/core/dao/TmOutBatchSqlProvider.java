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

import com.palette.busi.project.tms.core.entity.TmOutBatch;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class TmOutBatchSqlProvider extends BaseSqlProvider {

	public String update(TmOutBatch record) {
		BEGIN();
        UPDATE("tm_out_batch");
        if (record.getTmOutBatchId() != null) {
            SET("TM_OUT_BATCH_ID = #{tmOutBatchId}");
        }
        if (record.getOutBatchNo() != null) {
            SET("OUT_BATCH_NO = #{outBatchNo}");
        }
        if (record.getOutDate() != null) {
            SET("OUT_DATE = #{outDate}");
        }
        if (record.getCountryCode() != null) {
            SET("COUNTRY_CODE = #{countryCode}");
        }
        if (record.getWarehouseCode() != null) {
            SET("WAREHOUSE_CODE = #{warehouseCode}");
        }
        if (record.getStatus() != null) {
            SET("STATUS = #{status}");
        }
        if (record.getType() != null) {
            SET("TYPE = #{type}");
        }
        if (record.getRecordVersion() != null) {
            SET("RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCompanyCode() != null) {
            SET("COMPANY_CODE = #{companyCode}");
        }
        if (record.getCreateDateTime() != null) {
            SET("CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getCreateUserCode() != null) {
            SET("CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            SET("UPDATE_DATE_TIME = #{updateDateTime}");
        }
        if (record.getUpdateUserCode() != null) {
            SET("UPDATE_USER_CODE = #{updateUserCode}");
        }

        WHERE("tm_out_batch_id = #{tmOutBatchId}");

        return SQL();
	}

    public String selectAllByRecord(TmOutBatch record) {
        BEGIN();
        SELECT("*");
        FROM("tm_out_batch");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getTmOutBatchId() != null) {
            stringBuffer.append(" AND TM_OUT_BATCH_ID = #{tmOutBatchId}");
        }
        if (record.getOutBatchNo() != null) {
            stringBuffer.append(" AND OUT_BATCH_NO = #{outBatchNo}");
        }
        if (record.getOutDate() != null) {
            stringBuffer.append(" AND OUT_DATE = #{outDate}");
        }
        if (record.getCountryCode() != null) {
            stringBuffer.append(" AND COUNTRY_CODE = #{countryCode}");
        }
        if (record.getWarehouseCode() != null) {
            stringBuffer.append(" AND WAREHOUSE_CODE = #{warehouseCode}");
        }
        if (record.getStatus() != null) {
            stringBuffer.append(" AND STATUS = #{status}");
        }
        if (record.getType() != null) {
            stringBuffer.append(" AND TYPE = #{type}");
        }
        if (record.getRecordVersion() != null) {
            stringBuffer.append(" AND RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCompanyCode() != null) {
            stringBuffer.append(" AND COMPANY_CODE = #{companyCode}");
        }
        if (record.getCreateDateTime() != null) {
            stringBuffer.append(" AND CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getCreateUserCode() != null) {
            stringBuffer.append(" AND CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            stringBuffer.append(" AND UPDATE_DATE_TIME = #{updateDateTime}");
        }
        if (record.getUpdateUserCode() != null) {
            stringBuffer.append(" AND UPDATE_USER_CODE = #{updateUserCode}");
        }

        WHERE(stringBuffer.toString());

        return SQL();
    }
}
