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
import com.palette.busi.project.tms.core.entity.CdDelivery;
import com.palette.busi.project.tms.core.dao.CdDeliveryIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdDeliveryDao extends BaseDaoImpl {
	
	public CdDelivery updateCdDelivery(CdDelivery cdDelivery, String user, String programId) throws BaseException {
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		cdDelivery.setUpdateDateTime(getCurrentGMTDate());
		cdDelivery.setUpdateUserCode(user);
		mapper.updateCdDelivery(cdDelivery);
		return cdDelivery;
	}
	
	public CdDelivery insertCdDelivery(CdDelivery cdDelivery, String user, String programId) throws BaseException {
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		cdDelivery.setCreateDateTime(getCurrentGMTDate());
		cdDelivery.setCreateUserCode(user);
		cdDelivery.setUpdateDateTime(getCurrentGMTDate());
		cdDelivery.setUpdateUserCode(user);
		mapper.insertCdDelivery(cdDelivery);
		if(cdDelivery.getCdDeliveryId() == null){
			cdDelivery.setCdDeliveryId(getLastPk());
		}
		return cdDelivery;
	}
	
	public CdDelivery selectCdDeliveryById(Integer cdDeliveryId) throws BaseException {
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		return mapper.selectCdDeliveryById(cdDeliveryId);
	}
	
	public Integer deleteCdDelivery(Integer cdDeliveryId) throws BaseException {
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		return mapper.deleteCdDelivery(cdDeliveryId);
	}
	
	public List<CdDelivery> selectAllCdDelivery() throws BaseException {
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		List<CdDelivery> allCdDelivery = mapper.selectAllCdDelivery();
		return allCdDelivery;
	}
	
	public List<CdDelivery> selectAllByRecord(CdDelivery cdDelivery) throws BaseException {
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		return mapper.selectAllByRecord(cdDelivery);
	}
	
	public PageInfo selectPageByRecord(CdDelivery cdDelivery) throws BaseException {
		PageModel pageModel = cdDelivery.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdDeliveryIntf mapper = this.getSqlSessionTemplate().getMapper(CdDeliveryIntf.class);
		mapper.selectAllByRecord(cdDelivery);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdDelivery selectOneByRecord(CdDelivery cdDelivery) throws BaseException {
		List<CdDelivery> resultList = selectAllByRecord(cdDelivery);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdDelivery saveCdDelivery(CdDelivery cdDelivery, String user, String programId) throws BaseException {
		if(cdDelivery.getCdDeliveryId() == null){
			cdDelivery = insertCdDelivery(cdDelivery, user, programId);
		}else{
			cdDelivery = updateCdDelivery(cdDelivery, user, programId);
		}
		return cdDelivery;
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