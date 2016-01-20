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
import com.palette.busi.project.tms.core.entity.TmConsignmentVasRelation;
import com.palette.busi.project.tms.core.dao.TmConsignmentVasRelationIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmConsignmentVasRelationDao extends BaseDaoImpl {
	
	public TmConsignmentVasRelation updateTmConsignmentVasRelation(TmConsignmentVasRelation tmConsignmentVasRelation, String user, String programId) throws BaseException {
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		tmConsignmentVasRelation.setUpdateDateTime(getCurrentGMTDate());
		tmConsignmentVasRelation.setUpdateUserCode(user);
		mapper.updateTmConsignmentVasRelation(tmConsignmentVasRelation);
		return tmConsignmentVasRelation;
	}
	
	public TmConsignmentVasRelation insertTmConsignmentVasRelation(TmConsignmentVasRelation tmConsignmentVasRelation, String user, String programId) throws BaseException {
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		tmConsignmentVasRelation.setCreateDateTime(getCurrentGMTDate());
		tmConsignmentVasRelation.setCreateUserCode(user);
		tmConsignmentVasRelation.setUpdateDateTime(getCurrentGMTDate());
		tmConsignmentVasRelation.setUpdateUserCode(user);
		mapper.insertTmConsignmentVasRelation(tmConsignmentVasRelation);
		if(tmConsignmentVasRelation.getTmConsignmentVasRelationId() == null){
			tmConsignmentVasRelation.setTmConsignmentVasRelationId(getLastPk());
		}
		return tmConsignmentVasRelation;
	}
	
	public TmConsignmentVasRelation selectTmConsignmentVasRelationById(Integer tmConsignmentVasRelationId) throws BaseException {
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		return mapper.selectTmConsignmentVasRelationById(tmConsignmentVasRelationId);
	}
	
	public Integer deleteTmConsignmentVasRelation(Integer tmConsignmentVasRelationId) throws BaseException {
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		return mapper.deleteTmConsignmentVasRelation(tmConsignmentVasRelationId);
	}
	
	public List<TmConsignmentVasRelation> selectAllTmConsignmentVasRelation() throws BaseException {
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		List<TmConsignmentVasRelation> allTmConsignmentVasRelation = mapper.selectAllTmConsignmentVasRelation();
		return allTmConsignmentVasRelation;
	}
	
	public List<TmConsignmentVasRelation> selectAllByRecord(TmConsignmentVasRelation tmConsignmentVasRelation) throws BaseException {
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		return mapper.selectAllByRecord(tmConsignmentVasRelation);
	}
	
	public PageInfo selectPageByRecord(TmConsignmentVasRelation tmConsignmentVasRelation) throws BaseException {
		PageModel pageModel = tmConsignmentVasRelation.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmConsignmentVasRelationIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentVasRelationIntf.class);
		mapper.selectAllByRecord(tmConsignmentVasRelation);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmConsignmentVasRelation selectOneByRecord(TmConsignmentVasRelation tmConsignmentVasRelation) throws BaseException {
		List<TmConsignmentVasRelation> resultList = selectAllByRecord(tmConsignmentVasRelation);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmConsignmentVasRelation saveTmConsignmentVasRelation(TmConsignmentVasRelation tmConsignmentVasRelation, String user, String programId) throws BaseException {
		if(tmConsignmentVasRelation.getTmConsignmentVasRelationId() == null){
			tmConsignmentVasRelation = insertTmConsignmentVasRelation(tmConsignmentVasRelation, user, programId);
		}else{
			tmConsignmentVasRelation = updateTmConsignmentVasRelation(tmConsignmentVasRelation, user, programId);
		}
		return tmConsignmentVasRelation;
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