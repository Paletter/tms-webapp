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

import com.palette.busi.project.tms.core.entity.TmOutBatch;
import com.palette.busi.project.tms.core.dao.TmOutBatchSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmOutBatchIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_OUT_BATCH_ID  AS tmOutBatchId, OUT_BATCH_NO  AS outBatchNo, OUT_DATE  AS outDate, COUNTRY_CODE  AS countryCode, WAREHOUSE_CODE  AS warehouseCode, STATUS  AS status, TYPE  AS type, RECORD_VERSION  AS recordVersion, COMPANY_CODE  AS companyCode, CREATE_DATE_TIME  AS createDateTime, CREATE_USER_CODE  AS createUserCode, UPDATE_DATE_TIME  AS updateDateTime, UPDATE_USER_CODE  AS updateUserCode FROM tm_out_batch WHERE tm_out_batch_id=#{tmOutBatchId}")
	public TmOutBatch selectTmOutBatchById(@Param("tmOutBatchId") int tmOutBatchId);
	
	@Select("SELECT  TM_OUT_BATCH_ID  AS tmOutBatchId, OUT_BATCH_NO  AS outBatchNo, OUT_DATE  AS outDate, COUNTRY_CODE  AS countryCode, WAREHOUSE_CODE  AS warehouseCode, STATUS  AS status, TYPE  AS type, RECORD_VERSION  AS recordVersion, COMPANY_CODE  AS companyCode, CREATE_DATE_TIME  AS createDateTime, CREATE_USER_CODE  AS createUserCode, UPDATE_DATE_TIME  AS updateDateTime, UPDATE_USER_CODE  AS updateUserCode FROM tm_out_batch")
	public List<TmOutBatch> selectAllTmOutBatch();
	
	@Insert("insert into tm_out_batch ( TM_OUT_BATCH_ID, OUT_BATCH_NO, OUT_DATE, COUNTRY_CODE, WAREHOUSE_CODE, STATUS, TYPE, RECORD_VERSION, COMPANY_CODE, CREATE_DATE_TIME, CREATE_USER_CODE, UPDATE_DATE_TIME, UPDATE_USER_CODE ) values (#{tmOutBatchId},#{outBatchNo},#{outDate},#{countryCode},#{warehouseCode},#{status},#{type},#{recordVersion},#{companyCode},#{createDateTime},#{createUserCode},#{updateDateTime},#{updateUserCode})")
	public int insertTmOutBatch(TmOutBatch tmOutBatch);

	@UpdateProvider(type=TmOutBatchSqlProvider.class, method="update")
	public int updateTmOutBatch(TmOutBatch tmOutBatch);
	
	@Delete("delete from tm_out_batch where tm_out_batch_id = #{tmOutBatchId}")
	public int deleteTmOutBatch(@Param("tmOutBatchId") int tmOutBatchId);

    @SelectProvider(type=TmOutBatchSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmOutBatch.class)
    public List<TmOutBatch> selectAllByRecord(TmOutBatch record);
    
}