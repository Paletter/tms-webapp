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
import com.palette.busi.project.tms.core.entity.TmConsignmentCurrent;
import com.palette.busi.project.tms.core.dao.TmConsignmentCurrentIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmConsignmentCurrentDao extends BaseDaoImpl {
	
	public TmConsignmentCurrent updateTmConsignmentCurrent(TmConsignmentCurrent tmConsignmentCurrent, String user, String programId) throws BaseException {
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		tmConsignmentCurrent.setUpdateDateTime(getCurrentGMTDate());
		tmConsignmentCurrent.setUpdateUserCode(user);
		mapper.updateTmConsignmentCurrent(tmConsignmentCurrent);
		return tmConsignmentCurrent;
	}
	
	public TmConsignmentCurrent insertTmConsignmentCurrent(TmConsignmentCurrent tmConsignmentCurrent, String user, String programId) throws BaseException {
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		tmConsignmentCurrent.setCreateDateTime(getCurrentGMTDate());
		tmConsignmentCurrent.setCreateUserCode(user);
		tmConsignmentCurrent.setUpdateDateTime(getCurrentGMTDate());
		tmConsignmentCurrent.setUpdateUserCode(user);
		mapper.insertTmConsignmentCurrent(tmConsignmentCurrent);
		if(tmConsignmentCurrent.getTmConsignmentCurrentId() == null){
			tmConsignmentCurrent.setTmConsignmentCurrentId(getLastPk());
		}
		return tmConsignmentCurrent;
	}
	
	public TmConsignmentCurrent selectTmConsignmentCurrentById(Integer tmConsignmentCurrentId) throws BaseException {
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		return mapper.selectTmConsignmentCurrentById(tmConsignmentCurrentId);
	}
	
	public Integer deleteTmConsignmentCurrent(Integer tmConsignmentCurrentId) throws BaseException {
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		return mapper.deleteTmConsignmentCurrent(tmConsignmentCurrentId);
	}
	
	public List<TmConsignmentCurrent> selectAllTmConsignmentCurrent() throws BaseException {
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		List<TmConsignmentCurrent> allTmConsignmentCurrent = mapper.selectAllTmConsignmentCurrent();
		return allTmConsignmentCurrent;
	}
	
	public List<TmConsignmentCurrent> selectAllByRecord(TmConsignmentCurrent tmConsignmentCurrent) throws BaseException {
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		return mapper.selectAllByRecord(tmConsignmentCurrent);
	}
	
	public PageInfo selectPageByRecord(TmConsignmentCurrent tmConsignmentCurrent) throws BaseException {
		PageModel pageModel = tmConsignmentCurrent.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmConsignmentCurrentIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentCurrentIntf.class);
		mapper.selectAllByRecord(tmConsignmentCurrent);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmConsignmentCurrent selectOneByRecord(TmConsignmentCurrent tmConsignmentCurrent) throws BaseException {
		List<TmConsignmentCurrent> resultList = selectAllByRecord(tmConsignmentCurrent);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmConsignmentCurrent saveTmConsignmentCurrent(TmConsignmentCurrent tmConsignmentCurrent, String user, String programId) throws BaseException {
		if(tmConsignmentCurrent.getTmConsignmentCurrentId() == null){
			tmConsignmentCurrent = insertTmConsignmentCurrent(tmConsignmentCurrent, user, programId);
		}else{
			tmConsignmentCurrent = updateTmConsignmentCurrent(tmConsignmentCurrent, user, programId);
		}
		return tmConsignmentCurrent;
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