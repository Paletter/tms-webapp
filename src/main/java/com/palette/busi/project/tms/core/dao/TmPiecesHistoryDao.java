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
import com.palette.busi.project.tms.core.entity.TmPiecesHistory;
import com.palette.busi.project.tms.core.dao.TmPiecesHistoryIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmPiecesHistoryDao extends BaseDaoImpl {
	
	public TmPiecesHistory updateTmPiecesHistory(TmPiecesHistory tmPiecesHistory, String user, String programId) throws BaseException {
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		tmPiecesHistory.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesHistory.setUpdateUserCode(user);
		mapper.updateTmPiecesHistory(tmPiecesHistory);
		return tmPiecesHistory;
	}
	
	public TmPiecesHistory insertTmPiecesHistory(TmPiecesHistory tmPiecesHistory, String user, String programId) throws BaseException {
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		tmPiecesHistory.setCreateDateTime(getCurrentGMTDate());
		tmPiecesHistory.setCreateUserCode(user);
		tmPiecesHistory.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesHistory.setUpdateUserCode(user);
		mapper.insertTmPiecesHistory(tmPiecesHistory);
		if(tmPiecesHistory.getTmPiecesHistoryId() == null){
			tmPiecesHistory.setTmPiecesHistoryId(getLastPk());
		}
		return tmPiecesHistory;
	}
	
	public TmPiecesHistory selectTmPiecesHistoryById(Integer tmPiecesHistoryId) throws BaseException {
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		return mapper.selectTmPiecesHistoryById(tmPiecesHistoryId);
	}
	
	public Integer deleteTmPiecesHistory(Integer tmPiecesHistoryId) throws BaseException {
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		return mapper.deleteTmPiecesHistory(tmPiecesHistoryId);
	}
	
	public List<TmPiecesHistory> selectAllTmPiecesHistory() throws BaseException {
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		List<TmPiecesHistory> allTmPiecesHistory = mapper.selectAllTmPiecesHistory();
		return allTmPiecesHistory;
	}
	
	public List<TmPiecesHistory> selectAllByRecord(TmPiecesHistory tmPiecesHistory) throws BaseException {
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		return mapper.selectAllByRecord(tmPiecesHistory);
	}
	
	public PageInfo selectPageByRecord(TmPiecesHistory tmPiecesHistory) throws BaseException {
		PageModel pageModel = tmPiecesHistory.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmPiecesHistoryIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesHistoryIntf.class);
		mapper.selectAllByRecord(tmPiecesHistory);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmPiecesHistory selectOneByRecord(TmPiecesHistory tmPiecesHistory) throws BaseException {
		List<TmPiecesHistory> resultList = selectAllByRecord(tmPiecesHistory);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmPiecesHistory saveTmPiecesHistory(TmPiecesHistory tmPiecesHistory, String user, String programId) throws BaseException {
		if(tmPiecesHistory.getTmPiecesHistoryId() == null){
			tmPiecesHistory = insertTmPiecesHistory(tmPiecesHistory, user, programId);
		}else{
			tmPiecesHistory = updateTmPiecesHistory(tmPiecesHistory, user, programId);
		}
		return tmPiecesHistory;
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