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
import com.palette.busi.project.tms.core.entity.CdDistrict;
import com.palette.busi.project.tms.core.dao.CdDistrictIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdDistrictDao extends BaseDaoImpl {
	
	public CdDistrict updateCdDistrict(CdDistrict cdDistrict, String user, String programId) throws BaseException {
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		cdDistrict.setUpdateDateTime(getCurrentGMTDate());
		cdDistrict.setUpdateUserCode(user);
		mapper.updateCdDistrict(cdDistrict);
		return cdDistrict;
	}
	
	public CdDistrict insertCdDistrict(CdDistrict cdDistrict, String user, String programId) throws BaseException {
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		cdDistrict.setCreateDateTime(getCurrentGMTDate());
		cdDistrict.setCreateUserCode(user);
		cdDistrict.setUpdateDateTime(getCurrentGMTDate());
		cdDistrict.setUpdateUserCode(user);
		mapper.insertCdDistrict(cdDistrict);
		if(cdDistrict.getCdDistrictId() == null){
			cdDistrict.setCdDistrictId(getLastPk());
		}
		return cdDistrict;
	}
	
	public CdDistrict selectCdDistrictById(Integer cdDistrictId) throws BaseException {
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		return mapper.selectCdDistrictById(cdDistrictId);
	}
	
	public Integer deleteCdDistrict(Integer cdDistrictId) throws BaseException {
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		return mapper.deleteCdDistrict(cdDistrictId);
	}
	
	public List<CdDistrict> selectAllCdDistrict() throws BaseException {
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		List<CdDistrict> allCdDistrict = mapper.selectAllCdDistrict();
		return allCdDistrict;
	}
	
	public List<CdDistrict> selectAllByRecord(CdDistrict cdDistrict) throws BaseException {
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		return mapper.selectAllByRecord(cdDistrict);
	}
	
	public PageInfo selectPageByRecord(CdDistrict cdDistrict) throws BaseException {
		PageModel pageModel = cdDistrict.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdDistrictIntf mapper = this.getSqlSessionTemplate().getMapper(CdDistrictIntf.class);
		mapper.selectAllByRecord(cdDistrict);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdDistrict selectOneByRecord(CdDistrict cdDistrict) throws BaseException {
		List<CdDistrict> resultList = selectAllByRecord(cdDistrict);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdDistrict saveCdDistrict(CdDistrict cdDistrict, String user, String programId) throws BaseException {
		if(cdDistrict.getCdDistrictId() == null){
			cdDistrict = insertCdDistrict(cdDistrict, user, programId);
		}else{
			cdDistrict = updateCdDistrict(cdDistrict, user, programId);
		}
		return cdDistrict;
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