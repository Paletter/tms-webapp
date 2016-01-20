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

import com.palette.busi.project.tms.core.entity.TmConsignmentCurrent;
import com.palette.busi.project.tms.core.dao.TmConsignmentCurrentSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmConsignmentCurrentIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_CONSIGNMENT_CURRENT_ID  AS tmConsignmentCurrentId, CONSIGNMENT_NO  AS consignmentNo, TM_CONSIGNMENT_ID  AS tmConsignmentId, PAY_STATUS  AS payStatus, AUDIT_STATUS  AS auditStatus, COMBINATION_STATUS  AS combinationStatus, DISASSEMBLY_STATUS  AS disassemblyStatus, AUTO_DISASSEMBLE_STATUS  AS autoDisassembleStatus, IS_AUTO_DISASSEMBLE  AS isAutoDisassemble, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_consignment_current WHERE tm_consignment_current_id=#{tmConsignmentCurrentId}")
	public TmConsignmentCurrent selectTmConsignmentCurrentById(@Param("tmConsignmentCurrentId") int tmConsignmentCurrentId);
	
	@Select("SELECT  TM_CONSIGNMENT_CURRENT_ID  AS tmConsignmentCurrentId, CONSIGNMENT_NO  AS consignmentNo, TM_CONSIGNMENT_ID  AS tmConsignmentId, PAY_STATUS  AS payStatus, AUDIT_STATUS  AS auditStatus, COMBINATION_STATUS  AS combinationStatus, DISASSEMBLY_STATUS  AS disassemblyStatus, AUTO_DISASSEMBLE_STATUS  AS autoDisassembleStatus, IS_AUTO_DISASSEMBLE  AS isAutoDisassemble, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_consignment_current")
	public List<TmConsignmentCurrent> selectAllTmConsignmentCurrent();
	
	@Insert("insert into tm_consignment_current ( TM_CONSIGNMENT_CURRENT_ID, CONSIGNMENT_NO, TM_CONSIGNMENT_ID, PAY_STATUS, AUDIT_STATUS, COMBINATION_STATUS, DISASSEMBLY_STATUS, AUTO_DISASSEMBLE_STATUS, IS_AUTO_DISASSEMBLE, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{tmConsignmentCurrentId},#{consignmentNo},#{tmConsignmentId},#{payStatus},#{auditStatus},#{combinationStatus},#{disassemblyStatus},#{autoDisassembleStatus},#{isAutoDisassemble},#{recordVersion},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertTmConsignmentCurrent(TmConsignmentCurrent tmConsignmentCurrent);

	@UpdateProvider(type=TmConsignmentCurrentSqlProvider.class, method="update")
	public int updateTmConsignmentCurrent(TmConsignmentCurrent tmConsignmentCurrent);
	
	@Delete("delete from tm_consignment_current where tm_consignment_current_id = #{tmConsignmentCurrentId}")
	public int deleteTmConsignmentCurrent(@Param("tmConsignmentCurrentId") int tmConsignmentCurrentId);

    @SelectProvider(type=TmConsignmentCurrentSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmConsignmentCurrent.class)
    public List<TmConsignmentCurrent> selectAllByRecord(TmConsignmentCurrent record);
    
}