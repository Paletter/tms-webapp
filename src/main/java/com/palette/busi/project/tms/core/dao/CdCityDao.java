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
import com.palette.busi.project.tms.core.entity.CdCity;
import com.palette.busi.project.tms.core.dao.CdCityIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdCityDao extends BaseDaoImpl {
	
	public CdCity updateCdCity(CdCity cdCity, String user, String programId) throws BaseException {
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		cdCity.setUpdateDateTime(getCurrentGMTDate());
		cdCity.setUpdateUserCode(user);
		mapper.updateCdCity(cdCity);
		return cdCity;
	}
	
	public CdCity insertCdCity(CdCity cdCity, String user, String programId) throws BaseException {
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		cdCity.setCreateDateTime(getCurrentGMTDate());
		cdCity.setCreateUserCode(user);
		cdCity.setUpdateDateTime(getCurrentGMTDate());
		cdCity.setUpdateUserCode(user);
		mapper.insertCdCity(cdCity);
		if(cdCity.getCdCityId() == null){
			cdCity.setCdCityId(getLastPk());
		}
		return cdCity;
	}
	
	public CdCity selectCdCityById(Integer cdCityId) throws BaseException {
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		return mapper.selectCdCityById(cdCityId);
	}
	
	public Integer deleteCdCity(Integer cdCityId) throws BaseException {
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		return mapper.deleteCdCity(cdCityId);
	}
	
	public List<CdCity> selectAllCdCity() throws BaseException {
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		List<CdCity> allCdCity = mapper.selectAllCdCity();
		return allCdCity;
	}
	
	public List<CdCity> selectAllByRecord(CdCity cdCity) throws BaseException {
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		return mapper.selectAllByRecord(cdCity);
	}
	
	public PageInfo selectPageByRecord(CdCity cdCity) throws BaseException {
		PageModel pageModel = cdCity.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdCityIntf mapper = this.getSqlSessionTemplate().getMapper(CdCityIntf.class);
		mapper.selectAllByRecord(cdCity);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdCity selectOneByRecord(CdCity cdCity) throws BaseException {
		List<CdCity> resultList = selectAllByRecord(cdCity);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdCity saveCdCity(CdCity cdCity, String user, String programId) throws BaseException {
		if(cdCity.getCdCityId() == null){
			cdCity = insertCdCity(cdCity, user, programId);
		}else{
			cdCity = updateCdCity(cdCity, user, programId);
		}
		return cdCity;
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