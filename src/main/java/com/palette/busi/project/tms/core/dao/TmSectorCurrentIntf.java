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

import com.palette.busi.project.tms.core.entity.TmSectorCurrent;
import com.palette.busi.project.tms.core.dao.TmSectorCurrentSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmSectorCurrentIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_SECTOR_CURRENT_ID  AS tmSectorCurrentId, TM_SECTOR_ID  AS tmSectorId, SECTOR_CODE  AS sectorCode, ACTION_CODE  AS actionCode, MEMO  AS memo, ACTION_PLACE  AS actionPlace, ACTION_DATE_TIME  AS actionDateTime, ACTION_USER_NAME  AS actionUserName, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_sector_current WHERE tm_sector_current_id=#{tmSectorCurrentId}")
	public TmSectorCurrent selectTmSectorCurrentById(@Param("tmSectorCurrentId") int tmSectorCurrentId);
	
	@Select("SELECT  TM_SECTOR_CURRENT_ID  AS tmSectorCurrentId, TM_SECTOR_ID  AS tmSectorId, SECTOR_CODE  AS sectorCode, ACTION_CODE  AS actionCode, MEMO  AS memo, ACTION_PLACE  AS actionPlace, ACTION_DATE_TIME  AS actionDateTime, ACTION_USER_NAME  AS actionUserName, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_sector_current")
	public List<TmSectorCurrent> selectAllTmSectorCurrent();
	
	@Insert("insert into tm_sector_current ( TM_SECTOR_CURRENT_ID, TM_SECTOR_ID, SECTOR_CODE, ACTION_CODE, MEMO, ACTION_PLACE, ACTION_DATE_TIME, ACTION_USER_NAME, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{tmSectorCurrentId},#{tmSectorId},#{sectorCode},#{actionCode},#{memo},#{actionPlace},#{actionDateTime},#{actionUserName},#{recordVersion},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertTmSectorCurrent(TmSectorCurrent tmSectorCurrent);

	@UpdateProvider(type=TmSectorCurrentSqlProvider.class, method="update")
	public int updateTmSectorCurrent(TmSectorCurrent tmSectorCurrent);
	
	@Delete("delete from tm_sector_current where tm_sector_current_id = #{tmSectorCurrentId}")
	public int deleteTmSectorCurrent(@Param("tmSectorCurrentId") int tmSectorCurrentId);

    @SelectProvider(type=TmSectorCurrentSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmSectorCurrent.class)
    public List<TmSectorCurrent> selectAllByRecord(TmSectorCurrent record);
    
}