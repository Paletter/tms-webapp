package com.palette.busi.project.tms.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.ResultType;

import com.palette.busi.project.tms.core.entity.TmConsignmentVasRelation;
import com.palette.busi.project.tms.core.dao.TmConsignmentVasRelationSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmConsignmentVasRelationIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_CONSIGNMENT_VAS_RELATION_ID  AS tmConsignmentVasRelationId, RELATION_TYPE  AS relationType, RELATION_ID  AS relationId, TM_CONSIGNMENT_VAS_MST_ID  AS tmConsignmentVasMstId, VAS_DESCRIPTION  AS vasDescription, QUANTITY  AS quantity, PRICE  AS price, COMPLETE_STATUS  AS completeStatus, UPDATED_DATE_TIME  AS updatedDateTime, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, CREATE_TIME_ZONE  AS createTimeZone, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime, UPDATE_TIME_ZONE  AS updateTimeZone FROM tm_consignment_vas_relation WHERE tm_consignment_vas_relation_id=#{tmConsignmentVasRelationId}")
	public TmConsignmentVasRelation selectTmConsignmentVasRelationById(@Param("tmConsignmentVasRelationId") int tmConsignmentVasRelationId);
	
	@Select("SELECT  TM_CONSIGNMENT_VAS_RELATION_ID  AS tmConsignmentVasRelationId, RELATION_TYPE  AS relationType, RELATION_ID  AS relationId, TM_CONSIGNMENT_VAS_MST_ID  AS tmConsignmentVasMstId, VAS_DESCRIPTION  AS vasDescription, QUANTITY  AS quantity, PRICE  AS price, COMPLETE_STATUS  AS completeStatus, UPDATED_DATE_TIME  AS updatedDateTime, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, CREATE_TIME_ZONE  AS createTimeZone, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime, UPDATE_TIME_ZONE  AS updateTimeZone FROM tm_consignment_vas_relation")
	public List<TmConsignmentVasRelation> selectAllTmConsignmentVasRelation();
	
	@Insert("insert into tm_consignment_vas_relation ( TM_CONSIGNMENT_VAS_RELATION_ID, RELATION_TYPE, RELATION_ID, TM_CONSIGNMENT_VAS_MST_ID, VAS_DESCRIPTION, QUANTITY, PRICE, COMPLETE_STATUS, UPDATED_DATE_TIME, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, CREATE_TIME_ZONE, UPDATE_USER_CODE, UPDATE_DATE_TIME, UPDATE_TIME_ZONE ) values (#{tmConsignmentVasRelationId},#{relationType},#{relationId},#{tmConsignmentVasMstId},#{vasDescription},#{quantity},#{price},#{completeStatus},#{updatedDateTime},#{recordVersion},#{createUserCode},#{createDateTime},#{createTimeZone},#{updateUserCode},#{updateDateTime},#{updateTimeZone})")
	public int insertTmConsignmentVasRelation(TmConsignmentVasRelation tmConsignmentVasRelation);

	@UpdateProvider(type=TmConsignmentVasRelationSqlProvider.class, method="update")
	public int updateTmConsignmentVasRelation(TmConsignmentVasRelation tmConsignmentVasRelation);
	
	@Delete("delete from tm_consignment_vas_relation where tm_consignment_vas_relation_id = #{tmConsignmentVasRelationId}")
	public int deleteTmConsignmentVasRelation(@Param("tmConsignmentVasRelationId") int tmConsignmentVasRelationId);

    @SelectProvider(type=TmConsignmentVasRelationSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmConsignmentVasRelation.class)
    public List<TmConsignmentVasRelation> selectAllByRecord(TmConsignmentVasRelation record);
    
}