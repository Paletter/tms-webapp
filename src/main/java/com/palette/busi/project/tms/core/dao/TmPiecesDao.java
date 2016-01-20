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
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.dao.TmPiecesIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmPiecesDao extends BaseDaoImpl {
	
	public TmPieces updateTmPieces(TmPieces tmPieces, String user, String programId) throws BaseException {
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		tmPieces.setUpdateDateTime(getCurrentGMTDate());
		tmPieces.setUpdateUserCode(user);
		mapper.updateTmPieces(tmPieces);
		return tmPieces;
	}
	
	public TmPieces insertTmPieces(TmPieces tmPieces, String user, String programId) throws BaseException {
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		tmPieces.setCreateDateTime(getCurrentGMTDate());
		tmPieces.setCreateUserCode(user);
		tmPieces.setUpdateDateTime(getCurrentGMTDate());
		tmPieces.setUpdateUserCode(user);
		mapper.insertTmPieces(tmPieces);
		if(tmPieces.getTmPiecesId() == null){
			tmPieces.setTmPiecesId(getLastPk());
		}
		return tmPieces;
	}
	
	public TmPieces selectTmPiecesById(Integer tmPiecesId) throws BaseException {
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		return mapper.selectTmPiecesById(tmPiecesId);
	}
	
	public Integer deleteTmPieces(Integer tmPiecesId) throws BaseException {
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		return mapper.deleteTmPieces(tmPiecesId);
	}
	
	public List<TmPieces> selectAllTmPieces() throws BaseException {
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		List<TmPieces> allTmPieces = mapper.selectAllTmPieces();
		return allTmPieces;
	}
	
	public List<TmPieces> selectAllByRecord(TmPieces tmPieces) throws BaseException {
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		return mapper.selectAllByRecord(tmPieces);
	}
	
	public PageInfo selectPageByRecord(TmPieces tmPieces) throws BaseException {
		PageModel pageModel = tmPieces.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmPiecesIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesIntf.class);
		mapper.selectAllByRecord(tmPieces);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmPieces selectOneByRecord(TmPieces tmPieces) throws BaseException {
		List<TmPieces> resultList = selectAllByRecord(tmPieces);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmPieces saveTmPieces(TmPieces tmPieces, String user, String programId) throws BaseException {
		if(tmPieces.getTmPiecesId() == null){
			tmPieces = insertTmPieces(tmPieces, user, programId);
		}else{
			tmPieces = updateTmPieces(tmPieces, user, programId);
		}
		return tmPieces;
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