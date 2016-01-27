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
import com.palette.busi.project.tms.core.entity.CdCompany;
import com.palette.busi.project.tms.core.dao.CdCompanyIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdCompanyDao extends BaseDaoImpl {
	
	public CdCompany updateCdCompany(CdCompany cdCompany, String user, String programId) throws BaseException {
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		cdCompany.setUpdateDateTime(getCurrentGMTDate());
		cdCompany.setUpdateUserCode(user);
		mapper.updateCdCompany(cdCompany);
		return cdCompany;
	}
	
	public CdCompany insertCdCompany(CdCompany cdCompany, String user, String programId) throws BaseException {
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		cdCompany.setCreateDateTime(getCurrentGMTDate());
		cdCompany.setCreateUserCode(user);
		cdCompany.setUpdateDateTime(getCurrentGMTDate());
		cdCompany.setUpdateUserCode(user);
		mapper.insertCdCompany(cdCompany);
		if(cdCompany.getCdCompanyId() == null){
			cdCompany.setCdCompanyId(getLastPk());
		}
		return cdCompany;
	}
	
	public CdCompany selectCdCompanyById(Integer cdCompanyId) throws BaseException {
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		return mapper.selectCdCompanyById(cdCompanyId);
	}
	
	public Integer deleteCdCompany(Integer cdCompanyId) throws BaseException {
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		return mapper.deleteCdCompany(cdCompanyId);
	}
	
	public List<CdCompany> selectAllCdCompany() throws BaseException {
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		List<CdCompany> allCdCompany = mapper.selectAllCdCompany();
		return allCdCompany;
	}
	
	public List<CdCompany> selectAllByRecord(CdCompany cdCompany) throws BaseException {
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		return mapper.selectAllByRecord(cdCompany);
	}
	
	public PageInfo selectPageByRecord(CdCompany cdCompany) throws BaseException {
		PageModel pageModel = cdCompany.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdCompanyIntf mapper = this.getSqlSessionTemplate().getMapper(CdCompanyIntf.class);
		mapper.selectAllByRecord(cdCompany);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdCompany selectOneByRecord(CdCompany cdCompany) throws BaseException {
		List<CdCompany> resultList = selectAllByRecord(cdCompany);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdCompany saveCdCompany(CdCompany cdCompany, String user, String programId) throws BaseException {
		if(cdCompany.getCdCompanyId() == null){
			cdCompany = insertCdCompany(cdCompany, user, programId);
		}else{
			cdCompany = updateCdCompany(cdCompany, user, programId);
		}
		return cdCompany;
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