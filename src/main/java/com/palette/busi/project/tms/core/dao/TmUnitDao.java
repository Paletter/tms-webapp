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
import com.palette.busi.project.tms.core.entity.TmUnit;
import com.palette.busi.project.tms.core.dao.TmUnitIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmUnitDao extends BaseDaoImpl {
	
	public TmUnit updateTmUnit(TmUnit tmUnit, String user, String programId) throws BaseException {
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		tmUnit.setUpdateDateTime(getCurrentGMTDate());
		tmUnit.setUpdateUserCode(user);
		mapper.updateTmUnit(tmUnit);
		return tmUnit;
	}
	
	public TmUnit insertTmUnit(TmUnit tmUnit, String user, String programId) throws BaseException {
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		tmUnit.setCreateDateTime(getCurrentGMTDate());
		tmUnit.setCreateUserCode(user);
		tmUnit.setUpdateDateTime(getCurrentGMTDate());
		tmUnit.setUpdateUserCode(user);
		mapper.insertTmUnit(tmUnit);
		if(tmUnit.getTmUnitId() == null){
			tmUnit.setTmUnitId(getLastPk());
		}
		return tmUnit;
	}
	
	public TmUnit selectTmUnitById(Integer tmUnitId) throws BaseException {
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		return mapper.selectTmUnitById(tmUnitId);
	}
	
	public Integer deleteTmUnit(Integer tmUnitId) throws BaseException {
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		return mapper.deleteTmUnit(tmUnitId);
	}
	
	public List<TmUnit> selectAllTmUnit() throws BaseException {
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		List<TmUnit> allTmUnit = mapper.selectAllTmUnit();
		return allTmUnit;
	}
	
	public List<TmUnit> selectAllByRecord(TmUnit tmUnit) throws BaseException {
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		return mapper.selectAllByRecord(tmUnit);
	}
	
	public PageInfo selectPageByRecord(TmUnit tmUnit) throws BaseException {
		PageModel pageModel = tmUnit.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmUnitIntf mapper = this.getSqlSessionTemplate().getMapper(TmUnitIntf.class);
		mapper.selectAllByRecord(tmUnit);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmUnit selectOneByRecord(TmUnit tmUnit) throws BaseException {
		List<TmUnit> resultList = selectAllByRecord(tmUnit);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmUnit saveTmUnit(TmUnit tmUnit, String user, String programId) throws BaseException {
		if(tmUnit.getTmUnitId() == null){
			tmUnit = insertTmUnit(tmUnit, user, programId);
		}else{
			tmUnit = updateTmUnit(tmUnit, user, programId);
		}
		return tmUnit;
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