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

import com.palette.busi.project.tms.core.entity.CdCompany;
import com.palette.busi.project.tms.core.dao.CdCompanySqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface CdCompanyIntf extends BaseMybatisMapper {


	@Select("SELECT  CD_COMPANY_ID  AS cdCompanyId, COMPANY_NAME  AS companyName, COMPANY_CODE  AS companyCode, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM cd_company WHERE cd_company_id=#{cdCompanyId}")
	public CdCompany selectCdCompanyById(@Param("cdCompanyId") int cdCompanyId);
	
	@Select("SELECT  CD_COMPANY_ID  AS cdCompanyId, COMPANY_NAME  AS companyName, COMPANY_CODE  AS companyCode, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM cd_company")
	public List<CdCompany> selectAllCdCompany();
	
	@Insert("insert into cd_company ( CD_COMPANY_ID, COMPANY_NAME, COMPANY_CODE, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{cdCompanyId},#{companyName},#{companyCode},#{recordVersion},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertCdCompany(CdCompany cdCompany);

	@UpdateProvider(type=CdCompanySqlProvider.class, method="update")
	public int updateCdCompany(CdCompany cdCompany);
	
	@Delete("delete from cd_company where cd_company_id = #{cdCompanyId}")
	public int deleteCdCompany(@Param("cdCompanyId") int cdCompanyId);

    @SelectProvider(type=CdCompanySqlProvider.class, method="selectAllByRecord")
    @ResultType(CdCompany.class)
    public List<CdCompany> selectAllByRecord(CdCompany record);
    
}