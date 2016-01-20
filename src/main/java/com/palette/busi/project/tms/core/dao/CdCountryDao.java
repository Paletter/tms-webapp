package com.palette.busi.project.tms.core.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palette.busi.project.tms.core.base.dao.impl.BaseDaoImpl;
import com.palette.busi.project.tms.core.base.BaseException;
import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.dao.CdCountryIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdCountryDao extends BaseDaoImpl {
	
	public CdCountry updateCdCountry(CdCountry cdCountry, String user, String programId) throws BaseException {
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		cdCountry.setUpdateDateTime(getCurrentGMTDate());
		cdCountry.setUpdateUserCode(user);
		mapper.updateCdCountry(cdCountry);
		return cdCountry;
	}
	
	public CdCountry insertCdCountry(CdCountry cdCountry, String user, String programId) throws BaseException {
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		cdCountry.setCreateDateTime(getCurrentGMTDate());
		cdCountry.setCreateUserCode(user);
		cdCountry.setUpdateDateTime(getCurrentGMTDate());
		cdCountry.setUpdateUserCode(user);
		mapper.insertCdCountry(cdCountry);
		if(cdCountry.getCdCountryId() == null){
			cdCountry.setCdCountryId(getLastPk());
		}
		return cdCountry;
	}
	
	public CdCountry selectCdCountryById(Integer cdCountryId) throws BaseException {
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		return mapper.selectCdCountryById(cdCountryId);
	}
	
	public Integer deleteCdCountry(Integer cdCountryId) throws BaseException {
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		return mapper.deleteCdCountry(cdCountryId);
	}
	
	public List<CdCountry> selectAllCdCountry() throws BaseException {
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		List<CdCountry> allCdCountry = mapper.selectAllCdCountry();
		return allCdCountry;
	}
	
	public List<CdCountry> selectAllByRecord(CdCountry cdCountry) throws BaseException {
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		return mapper.selectAllByRecord(cdCountry);
	}
	
	public PageInfo selectPageByRecord(CdCountry cdCountry) throws BaseException {
		PageModel pageModel = cdCountry.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdCountryIntf mapper = this.getSqlSessionTemplate().getMapper(CdCountryIntf.class);
		mapper.selectAllByRecord(cdCountry);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdCountry selectOneByRecord(CdCountry cdCountry) throws BaseException {
		List<CdCountry> resultList = selectAllByRecord(cdCountry);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdCountry saveCdCountry(CdCountry cdCountry, String user, String programId) throws BaseException {
		if(cdCountry.getCdCountryId() == null){
			cdCountry = insertCdCountry(cdCountry, user, programId);
		}else{
			cdCountry = updateCdCountry(cdCountry, user, programId);
		}
		return cdCountry;
	}
	
	private Date getCurrentGMTDate() {
		try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
	        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateTimeFormat.parse(dateFormat.format(new Date()));
		} catch (Exception e) {
			throw new BaseException(e.getMessage());
		}
    }
}