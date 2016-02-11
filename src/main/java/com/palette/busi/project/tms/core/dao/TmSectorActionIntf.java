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

import com.palette.busi.project.tms.core.entity.TmSectorAction;
import com.palette.busi.project.tms.core.dao.TmSectorActionSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmSectorActionIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_SECTOR_ACTION_ID  AS tmSectorActionId, ACTION_CODE  AS actionCode, ACTION_DESC  AS actionDesc, USER_VIEW_NO  AS userViewNo, USER_VIEW_CODE  AS userViewCode, IS_ACTIVITY  AS isActivity, RECORD_VERSION  AS recordVersion, COMPANY_CODE  AS companyCode, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_sector_action WHERE tm_sector_action_id=#{tmSectorActionId}")
	public TmSectorAction selectTmSectorActionById(@Param("tmSectorActionId") int tmSectorActionId);
	
	@Select("SELECT  TM_SECTOR_ACTION_ID  AS tmSectorActionId, ACTION_CODE  AS actionCode, ACTION_DESC  AS actionDesc, USER_VIEW_NO  AS userViewNo, USER_VIEW_CODE  AS userViewCode, IS_ACTIVITY  AS isActivity, RECORD_VERSION  AS recordVersion, COMPANY_CODE  AS companyCode, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_sector_action")
	public List<TmSectorAction> selectAllTmSectorAction();
	
	@Insert("insert into tm_sector_action ( TM_SECTOR_ACTION_ID, ACTION_CODE, ACTION_DESC, USER_VIEW_NO, USER_VIEW_CODE, IS_ACTIVITY, RECORD_VERSION, COMPANY_CODE, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{tmSectorActionId},#{actionCode},#{actionDesc},#{userViewNo},#{userViewCode},#{isActivity},#{recordVersion},#{companyCode},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertTmSectorAction(TmSectorAction tmSectorAction);

	@UpdateProvider(type=TmSectorActionSqlProvider.class, method="update")
	public int updateTmSectorAction(TmSectorAction tmSectorAction);
	
	@Delete("delete from tm_sector_action where tm_sector_action_id = #{tmSectorActionId}")
	public int deleteTmSectorAction(@Param("tmSectorActionId") int tmSectorActionId);

    @SelectProvider(type=TmSectorActionSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmSectorAction.class)
    public List<TmSectorAction> selectAllByRecord(TmSectorAction record);
    
}