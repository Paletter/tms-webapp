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
import com.palette.busi.project.tms.core.entity.WmLocationHistory;
import com.palette.busi.project.tms.core.dao.WmLocationHistoryIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class WmLocationHistoryDao extends BaseDaoImpl {
	
	public WmLocationHistory updateWmLocationHistory(WmLocationHistory wmLocationHistory, String user, String programId) throws BaseException {
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		wmLocationHistory.setUpdateDateTime(getCurrentGMTDate());
		wmLocationHistory.setUpdateUserCode(user);
		mapper.updateWmLocationHistory(wmLocationHistory);
		return wmLocationHistory;
	}
	
	public WmLocationHistory insertWmLocationHistory(WmLocationHistory wmLocationHistory, String user, String programId) throws BaseException {
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		wmLocationHistory.setCreateDateTime(getCurrentGMTDate());
		wmLocationHistory.setCreateUserCode(user);
		wmLocationHistory.setUpdateDateTime(getCurrentGMTDate());
		wmLocationHistory.setUpdateUserCode(user);
		mapper.insertWmLocationHistory(wmLocationHistory);
		if(wmLocationHistory.getWmLocationHistoryId() == null){
			wmLocationHistory.setWmLocationHistoryId(getLastPk());
		}
		return wmLocationHistory;
	}
	
	public WmLocationHistory selectWmLocationHistoryById(Integer wmLocationHistoryId) throws BaseException {
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		return mapper.selectWmLocationHistoryById(wmLocationHistoryId);
	}
	
	public Integer deleteWmLocationHistory(Integer wmLocationHistoryId) throws BaseException {
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		return mapper.deleteWmLocationHistory(wmLocationHistoryId);
	}
	
	public List<WmLocationHistory> selectAllWmLocationHistory() throws BaseException {
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		List<WmLocationHistory> allWmLocationHistory = mapper.selectAllWmLocationHistory();
		return allWmLocationHistory;
	}
	
	public List<WmLocationHistory> selectAllByRecord(WmLocationHistory wmLocationHistory) throws BaseException {
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		return mapper.selectAllByRecord(wmLocationHistory);
	}
	
	public PageInfo selectPageByRecord(WmLocationHistory wmLocationHistory) throws BaseException {
		PageModel pageModel = wmLocationHistory.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		WmLocationHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(WmLocationHistoryIntf.class);
		mapper.selectAllByRecord(wmLocationHistory);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public WmLocationHistory selectOneByRecord(WmLocationHistory wmLocationHistory) throws BaseException {
		List<WmLocationHistory> resultList = selectAllByRecord(wmLocationHistory);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public WmLocationHistory saveWmLocationHistory(WmLocationHistory wmLocationHistory, String user, String programId) throws BaseException {
		if(wmLocationHistory.getWmLocationHistoryId() == null){
			wmLocationHistory = insertWmLocationHistory(wmLocationHistory, user, programId);
		}else{
			wmLocationHistory = updateWmLocationHistory(wmLocationHistory, user, programId);
		}
		return wmLocationHistory;
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