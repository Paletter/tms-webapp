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
import com.palette.busi.project.tms.core.entity.TmPiecesRef;
import com.palette.busi.project.tms.core.dao.TmPiecesRefIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmPiecesRefDao extends BaseDaoImpl {
	
	public TmPiecesRef updateTmPiecesRef(TmPiecesRef tmPiecesRef, String user, String programId) throws BaseException {
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		tmPiecesRef.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesRef.setUpdateUserCode(user);
		mapper.updateTmPiecesRef(tmPiecesRef);
		return tmPiecesRef;
	}
	
	public TmPiecesRef insertTmPiecesRef(TmPiecesRef tmPiecesRef, String user, String programId) throws BaseException {
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		tmPiecesRef.setCreateDateTime(getCurrentGMTDate());
		tmPiecesRef.setCreateUserCode(user);
		tmPiecesRef.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesRef.setUpdateUserCode(user);
		mapper.insertTmPiecesRef(tmPiecesRef);
		if(tmPiecesRef.getTmPiecesRefId() == null){
			tmPiecesRef.setTmPiecesRefId(getLastPk());
		}
		return tmPiecesRef;
	}
	
	public TmPiecesRef selectTmPiecesRefById(Integer tmPiecesRefId) throws BaseException {
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		return mapper.selectTmPiecesRefById(tmPiecesRefId);
	}
	
	public Integer deleteTmPiecesRef(Integer tmPiecesRefId) throws BaseException {
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		return mapper.deleteTmPiecesRef(tmPiecesRefId);
	}
	
	public List<TmPiecesRef> selectAllTmPiecesRef() throws BaseException {
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		List<TmPiecesRef> allTmPiecesRef = mapper.selectAllTmPiecesRef();
		return allTmPiecesRef;
	}
	
	public List<TmPiecesRef> selectAllByRecord(TmPiecesRef tmPiecesRef) throws BaseException {
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		return mapper.selectAllByRecord(tmPiecesRef);
	}
	
	public PageInfo selectPageByRecord(TmPiecesRef tmPiecesRef) throws BaseException {
		PageModel pageModel = tmPiecesRef.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmPiecesRefIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesRefIntf.class);
		mapper.selectAllByRecord(tmPiecesRef);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmPiecesRef selectOneByRecord(TmPiecesRef tmPiecesRef) throws BaseException {
		List<TmPiecesRef> resultList = selectAllByRecord(tmPiecesRef);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmPiecesRef saveTmPiecesRef(TmPiecesRef tmPiecesRef, String user, String programId) throws BaseException {
		if(tmPiecesRef.getTmPiecesRefId() == null){
			tmPiecesRef = insertTmPiecesRef(tmPiecesRef, user, programId);
		}else{
			tmPiecesRef = updateTmPiecesRef(tmPiecesRef, user, programId);
		}
		return tmPiecesRef;
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