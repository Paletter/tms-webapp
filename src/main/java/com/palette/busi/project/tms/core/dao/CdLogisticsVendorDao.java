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
import com.palette.busi.project.tms.core.entity.CdLogisticsVendor;
import com.palette.busi.project.tms.core.dao.CdLogisticsVendorIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdLogisticsVendorDao extends BaseDaoImpl {
	
	public CdLogisticsVendor updateCdLogisticsVendor(CdLogisticsVendor cdLogisticsVendor, String user, String programId) throws BaseException {
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		cdLogisticsVendor.setUpdateDateTime(getCurrentGMTDate());
		cdLogisticsVendor.setUpdateUserCode(user);
		mapper.updateCdLogisticsVendor(cdLogisticsVendor);
		return cdLogisticsVendor;
	}
	
	public CdLogisticsVendor insertCdLogisticsVendor(CdLogisticsVendor cdLogisticsVendor, String user, String programId) throws BaseException {
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		cdLogisticsVendor.setCreateDateTime(getCurrentGMTDate());
		cdLogisticsVendor.setCreateUserCode(user);
		cdLogisticsVendor.setUpdateDateTime(getCurrentGMTDate());
		cdLogisticsVendor.setUpdateUserCode(user);
		mapper.insertCdLogisticsVendor(cdLogisticsVendor);
		if(cdLogisticsVendor.getCdLogisticsVendorId() == null){
			cdLogisticsVendor.setCdLogisticsVendorId(getLastPk());
		}
		return cdLogisticsVendor;
	}
	
	public CdLogisticsVendor selectCdLogisticsVendorById(Integer cdLogisticsVendorId) throws BaseException {
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		return mapper.selectCdLogisticsVendorById(cdLogisticsVendorId);
	}
	
	public Integer deleteCdLogisticsVendor(Integer cdLogisticsVendorId) throws BaseException {
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		return mapper.deleteCdLogisticsVendor(cdLogisticsVendorId);
	}
	
	public List<CdLogisticsVendor> selectAllCdLogisticsVendor() throws BaseException {
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		List<CdLogisticsVendor> allCdLogisticsVendor = mapper.selectAllCdLogisticsVendor();
		return allCdLogisticsVendor;
	}
	
	public List<CdLogisticsVendor> selectAllByRecord(CdLogisticsVendor cdLogisticsVendor) throws BaseException {
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		return mapper.selectAllByRecord(cdLogisticsVendor);
	}
	
	public PageInfo selectPageByRecord(CdLogisticsVendor cdLogisticsVendor) throws BaseException {
		PageModel pageModel = cdLogisticsVendor.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdLogisticsVendorIntf mapper = this.getSqlSessionTemplate().getMapper(CdLogisticsVendorIntf.class);
		mapper.selectAllByRecord(cdLogisticsVendor);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdLogisticsVendor selectOneByRecord(CdLogisticsVendor cdLogisticsVendor) throws BaseException {
		List<CdLogisticsVendor> resultList = selectAllByRecord(cdLogisticsVendor);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdLogisticsVendor saveCdLogisticsVendor(CdLogisticsVendor cdLogisticsVendor, String user, String programId) throws BaseException {
		if(cdLogisticsVendor.getCdLogisticsVendorId() == null){
			cdLogisticsVendor = insertCdLogisticsVendor(cdLogisticsVendor, user, programId);
		}else{
			cdLogisticsVendor = updateCdLogisticsVendor(cdLogisticsVendor, user, programId);
		}
		return cdLogisticsVendor;
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