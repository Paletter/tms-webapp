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
import com.palette.busi.project.tms.core.entity.TrDataSyncHist;
import com.palette.busi.project.tms.core.dao.TrDataSyncHistIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TrDataSyncHistDao extends BaseDaoImpl {
	
	public TrDataSyncHist updateTrDataSyncHist(TrDataSyncHist trDataSyncHist, String user, String programId) throws BaseException {
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		trDataSyncHist.setUpdateDateTime(getCurrentGMTDate());
		trDataSyncHist.setUpdateUserCode(user);
		mapper.updateTrDataSyncHist(trDataSyncHist);
		return trDataSyncHist;
	}
	
	public TrDataSyncHist insertTrDataSyncHist(TrDataSyncHist trDataSyncHist, String user, String programId) throws BaseException {
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		trDataSyncHist.setCreateDateTime(getCurrentGMTDate());
		trDataSyncHist.setCreateUserCode(user);
		trDataSyncHist.setUpdateDateTime(getCurrentGMTDate());
		trDataSyncHist.setUpdateUserCode(user);
		mapper.insertTrDataSyncHist(trDataSyncHist);
		if(trDataSyncHist.getTrDataSyncHistId() == null){
			trDataSyncHist.setTrDataSyncHistId(getLastPk());
		}
		return trDataSyncHist;
	}
	
	public TrDataSyncHist selectTrDataSyncHistById(Integer trDataSyncHistId) throws BaseException {
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		return mapper.selectTrDataSyncHistById(trDataSyncHistId);
	}
	
	public Integer deleteTrDataSyncHist(Integer trDataSyncHistId) throws BaseException {
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		return mapper.deleteTrDataSyncHist(trDataSyncHistId);
	}
	
	public List<TrDataSyncHist> selectAllTrDataSyncHist() throws BaseException {
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		List<TrDataSyncHist> allTrDataSyncHist = mapper.selectAllTrDataSyncHist();
		return allTrDataSyncHist;
	}
	
	public List<TrDataSyncHist> selectAllByRecord(TrDataSyncHist trDataSyncHist) throws BaseException {
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		return mapper.selectAllByRecord(trDataSyncHist);
	}
	
	public PageInfo selectPageByRecord(TrDataSyncHist trDataSyncHist) throws BaseException {
		PageModel pageModel = trDataSyncHist.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TrDataSyncHistIntf mapper = this.getSqlSessionTemplate().getMapper(TrDataSyncHistIntf.class);
		mapper.selectAllByRecord(trDataSyncHist);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TrDataSyncHist selectOneByRecord(TrDataSyncHist trDataSyncHist) throws BaseException {
		List<TrDataSyncHist> resultList = selectAllByRecord(trDataSyncHist);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TrDataSyncHist saveTrDataSyncHist(TrDataSyncHist trDataSyncHist, String user, String programId) throws BaseException {
		if(trDataSyncHist.getTrDataSyncHistId() == null){
			trDataSyncHist = insertTrDataSyncHist(trDataSyncHist, user, programId);
		}else{
			trDataSyncHist = updateTrDataSyncHist(trDataSyncHist, user, programId);
		}
		return trDataSyncHist;
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