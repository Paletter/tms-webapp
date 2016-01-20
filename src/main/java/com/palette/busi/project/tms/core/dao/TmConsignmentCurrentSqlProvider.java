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

import com.palette.busi.project.tms.core.entity.TmConsignmentCurrent;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class TmConsignmentCurrentSqlProvider extends BaseSqlProvider {

	public String update(TmConsignmentCurrent record) {
		BEGIN();
        UPDATE("tm_consignment_current");
        if (record.getTmConsignmentCurrentId() != null) {
            SET("TM_CONSIGNMENT_CURRENT_ID = #{tmConsignmentCurrentId}");
        }
        if (record.getConsignmentNo() != null) {
            SET("CONSIGNMENT_NO = #{consignmentNo}");
        }
        if (record.getTmConsignmentId() != null) {
            SET("TM_CONSIGNMENT_ID = #{tmConsignmentId}");
        }
        if (record.getPayStatus() != null) {
            SET("PAY_STATUS = #{payStatus}");
        }
        if (record.getAuditStatus() != null) {
            SET("AUDIT_STATUS = #{auditStatus}");
        }
        if (record.getCombinationStatus() != null) {
            SET("COMBINATION_STATUS = #{combinationStatus}");
        }
        if (record.getDisassemblyStatus() != null) {
            SET("DISASSEMBLY_STATUS = #{disassemblyStatus}");
        }
        if (record.getAutoDisassembleStatus() != null) {
            SET("AUTO_DISASSEMBLE_STATUS = #{autoDisassembleStatus}");
        }
        if (record.getIsAutoDisassemble() != null) {
            SET("IS_AUTO_DISASSEMBLE = #{isAutoDisassemble}");
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

        WHERE("tm_consignment_current_id = #{tmConsignmentCurrentId}");

        return SQL();
	}

    public String selectAllByRecord(TmConsignmentCurrent record) {
        BEGIN();
        SELECT("*");
        FROM("tm_consignment_current");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getTmConsignmentCurrentId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_CURRENT_ID = #{tmConsignmentCurrentId}");
        }
        if (record.getConsignmentNo() != null) {
            stringBuffer.append(" AND CONSIGNMENT_NO = #{consignmentNo}");
        }
        if (record.getTmConsignmentId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_ID = #{tmConsignmentId}");
        }
        if (record.getPayStatus() != null) {
            stringBuffer.append(" AND PAY_STATUS = #{payStatus}");
        }
        if (record.getAuditStatus() != null) {
            stringBuffer.append(" AND AUDIT_STATUS = #{auditStatus}");
        }
        if (record.getCombinationStatus() != null) {
            stringBuffer.append(" AND COMBINATION_STATUS = #{combinationStatus}");
        }
        if (record.getDisassemblyStatus() != null) {
            stringBuffer.append(" AND DISASSEMBLY_STATUS = #{disassemblyStatus}");
        }
        if (record.getAutoDisassembleStatus() != null) {
            stringBuffer.append(" AND AUTO_DISASSEMBLE_STATUS = #{autoDisassembleStatus}");
        }
        if (record.getIsAutoDisassemble() != null) {
            stringBuffer.append(" AND IS_AUTO_DISASSEMBLE = #{isAutoDisassemble}");
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
