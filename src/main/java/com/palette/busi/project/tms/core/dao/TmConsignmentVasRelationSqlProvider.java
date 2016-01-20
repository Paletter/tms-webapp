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

import com.palette.busi.project.tms.core.entity.TmConsignmentVasRelation;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class TmConsignmentVasRelationSqlProvider extends BaseSqlProvider {

	public String update(TmConsignmentVasRelation record) {
		BEGIN();
        UPDATE("tm_consignment_vas_relation");
        if (record.getTmConsignmentVasRelationId() != null) {
            SET("TM_CONSIGNMENT_VAS_RELATION_ID = #{tmConsignmentVasRelationId}");
        }
        if (record.getRelationType() != null) {
            SET("RELATION_TYPE = #{relationType}");
        }
        if (record.getRelationId() != null) {
            SET("RELATION_ID = #{relationId}");
        }
        if (record.getTmConsignmentVasMstId() != null) {
            SET("TM_CONSIGNMENT_VAS_MST_ID = #{tmConsignmentVasMstId}");
        }
        if (record.getVasDescription() != null) {
            SET("VAS_DESCRIPTION = #{vasDescription}");
        }
        if (record.getQuantity() != null) {
            SET("QUANTITY = #{quantity}");
        }
        if (record.getPrice() != null) {
            SET("PRICE = #{price}");
        }
        if (record.getCompleteStatus() != null) {
            SET("COMPLETE_STATUS = #{completeStatus}");
        }
        if (record.getUpdatedDateTime() != null) {
            SET("UPDATED_DATE_TIME = #{updatedDateTime}");
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

        WHERE("tm_consignment_vas_relation_id = #{tmConsignmentVasRelationId}");

        return SQL();
	}

    public String selectAllByRecord(TmConsignmentVasRelation record) {
        BEGIN();
        SELECT("*");
        FROM("tm_consignment_vas_relation");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getTmConsignmentVasRelationId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_VAS_RELATION_ID = #{tmConsignmentVasRelationId}");
        }
        if (record.getRelationType() != null) {
            stringBuffer.append(" AND RELATION_TYPE = #{relationType}");
        }
        if (record.getRelationId() != null) {
            stringBuffer.append(" AND RELATION_ID = #{relationId}");
        }
        if (record.getTmConsignmentVasMstId() != null) {
            stringBuffer.append(" AND TM_CONSIGNMENT_VAS_MST_ID = #{tmConsignmentVasMstId}");
        }
        if (record.getVasDescription() != null) {
            stringBuffer.append(" AND VAS_DESCRIPTION = #{vasDescription}");
        }
        if (record.getQuantity() != null) {
            stringBuffer.append(" AND QUANTITY = #{quantity}");
        }
        if (record.getPrice() != null) {
            stringBuffer.append(" AND PRICE = #{price}");
        }
        if (record.getCompleteStatus() != null) {
            stringBuffer.append(" AND COMPLETE_STATUS = #{completeStatus}");
        }
        if (record.getUpdatedDateTime() != null) {
            stringBuffer.append(" AND UPDATED_DATE_TIME = #{updatedDateTime}");
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

        WHERE(stringBuffer.toString());

        return SQL();
    }
}
