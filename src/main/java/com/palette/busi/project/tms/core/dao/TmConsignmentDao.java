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
import com.palette.busi.project.tms.core.entity.TmConsignment;
import com.palette.busi.project.tms.core.dao.TmConsignmentIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmConsignmentDao extends BaseDaoImpl {
	
	public TmConsignment updateTmConsignment(TmConsignment tmConsignment, String user, String programId) throws BaseException {
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		tmConsignment.setUpdateDateTime(getCurrentGMTDate());
		tmConsignment.setUpdateUserCode(user);
		mapper.updateTmConsignment(tmConsignment);
		return tmConsignment;
	}
	
	public TmConsignment insertTmConsignment(TmConsignment tmConsignment, String user, String programId) throws BaseException {
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		tmConsignment.setCreateDateTime(getCurrentGMTDate());
		tmConsignment.setCreateUserCode(user);
		tmConsignment.setUpdateDateTime(getCurrentGMTDate());
		tmConsignment.setUpdateUserCode(user);
		mapper.insertTmConsignment(tmConsignment);
		if(tmConsignment.getTmConsignmentId() == null){
			tmConsignment.setTmConsignmentId(getLastPk());
		}
		return tmConsignment;
	}
	
	public TmConsignment selectTmConsignmentById(Integer tmConsignmentId) throws BaseException {
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		return mapper.selectTmConsignmentById(tmConsignmentId);
	}
	
	public Integer deleteTmConsignment(Integer tmConsignmentId) throws BaseException {
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		return mapper.deleteTmConsignment(tmConsignmentId);
	}
	
	public List<TmConsignment> selectAllTmConsignment() throws BaseException {
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		List<TmConsignment> allTmConsignment = mapper.selectAllTmConsignment();
		return allTmConsignment;
	}
	
	public List<TmConsignment> selectAllByRecord(TmConsignment tmConsignment) throws BaseException {
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		return mapper.selectAllByRecord(tmConsignment);
	}
	
	public PageInfo selectPageByRecord(TmConsignment tmConsignment) throws BaseException {
		PageModel pageModel = tmConsignment.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmConsignmentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentIntf.class);
		mapper.selectAllByRecord(tmConsignment);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmConsignment selectOneByRecord(TmConsignment tmConsignment) throws BaseException {
		List<TmConsignment> resultList = selectAllByRecord(tmConsignment);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmConsignment saveTmConsignment(TmConsignment tmConsignment, String user, String programId) throws BaseException {
		if(tmConsignment.getTmConsignmentId() == null){
			tmConsignment = insertTmConsignment(tmConsignment, user, programId);
		}else{
			tmConsignment = updateTmConsignment(tmConsignment, user, programId);
		}
		return tmConsignment;
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