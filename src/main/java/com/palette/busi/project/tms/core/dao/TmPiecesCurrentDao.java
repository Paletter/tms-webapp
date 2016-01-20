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
import com.palette.busi.project.tms.core.entity.TmPiecesCurrent;
import com.palette.busi.project.tms.core.dao.TmPiecesCurrentIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmPiecesCurrentDao extends BaseDaoImpl {
	
	public TmPiecesCurrent updateTmPiecesCurrent(TmPiecesCurrent tmPiecesCurrent, String user, String programId) throws BaseException {
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		tmPiecesCurrent.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesCurrent.setUpdateUserCode(user);
		mapper.updateTmPiecesCurrent(tmPiecesCurrent);
		return tmPiecesCurrent;
	}
	
	public TmPiecesCurrent insertTmPiecesCurrent(TmPiecesCurrent tmPiecesCurrent, String user, String programId) throws BaseException {
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		tmPiecesCurrent.setCreateDateTime(getCurrentGMTDate());
		tmPiecesCurrent.setCreateUserCode(user);
		tmPiecesCurrent.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesCurrent.setUpdateUserCode(user);
		mapper.insertTmPiecesCurrent(tmPiecesCurrent);
		if(tmPiecesCurrent.getTmPiecesCurrentId() == null){
			tmPiecesCurrent.setTmPiecesCurrentId(getLastPk());
		}
		return tmPiecesCurrent;
	}
	
	public TmPiecesCurrent selectTmPiecesCurrentById(Integer tmPiecesCurrentId) throws BaseException {
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		return mapper.selectTmPiecesCurrentById(tmPiecesCurrentId);
	}
	
	public Integer deleteTmPiecesCurrent(Integer tmPiecesCurrentId) throws BaseException {
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		return mapper.deleteTmPiecesCurrent(tmPiecesCurrentId);
	}
	
	public List<TmPiecesCurrent> selectAllTmPiecesCurrent() throws BaseException {
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		List<TmPiecesCurrent> allTmPiecesCurrent = mapper.selectAllTmPiecesCurrent();
		return allTmPiecesCurrent;
	}
	
	public List<TmPiecesCurrent> selectAllByRecord(TmPiecesCurrent tmPiecesCurrent) throws BaseException {
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		return mapper.selectAllByRecord(tmPiecesCurrent);
	}
	
	public PageInfo selectPageByRecord(TmPiecesCurrent tmPiecesCurrent) throws BaseException {
		PageModel pageModel = tmPiecesCurrent.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmPiecesCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesCurrentIntf.class);
		mapper.selectAllByRecord(tmPiecesCurrent);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmPiecesCurrent selectOneByRecord(TmPiecesCurrent tmPiecesCurrent) throws BaseException {
		List<TmPiecesCurrent> resultList = selectAllByRecord(tmPiecesCurrent);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmPiecesCurrent saveTmPiecesCurrent(TmPiecesCurrent tmPiecesCurrent, String user, String programId) throws BaseException {
		if(tmPiecesCurrent.getTmPiecesCurrentId() == null){
			tmPiecesCurrent = insertTmPiecesCurrent(tmPiecesCurrent, user, programId);
		}else{
			tmPiecesCurrent = updateTmPiecesCurrent(tmPiecesCurrent, user, programId);
		}
		return tmPiecesCurrent;
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