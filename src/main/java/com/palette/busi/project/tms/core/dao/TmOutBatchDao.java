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
import com.palette.busi.project.tms.core.entity.TmOutBatch;
import com.palette.busi.project.tms.core.dao.TmOutBatchIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmOutBatchDao extends BaseDaoImpl {
	
	public TmOutBatch updateTmOutBatch(TmOutBatch tmOutBatch, String user, String programId) throws BaseException {
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		tmOutBatch.setUpdateDateTime(getCurrentGMTDate());
		tmOutBatch.setUpdateUserCode(user);
		mapper.updateTmOutBatch(tmOutBatch);
		return tmOutBatch;
	}
	
	public TmOutBatch insertTmOutBatch(TmOutBatch tmOutBatch, String user, String programId) throws BaseException {
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		tmOutBatch.setCreateDateTime(getCurrentGMTDate());
		tmOutBatch.setCreateUserCode(user);
		tmOutBatch.setUpdateDateTime(getCurrentGMTDate());
		tmOutBatch.setUpdateUserCode(user);
		mapper.insertTmOutBatch(tmOutBatch);
		if(tmOutBatch.getTmOutBatchId() == null){
			tmOutBatch.setTmOutBatchId(getLastPk());
		}
		return tmOutBatch;
	}
	
	public TmOutBatch selectTmOutBatchById(Integer tmOutBatchId) throws BaseException {
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		return mapper.selectTmOutBatchById(tmOutBatchId);
	}
	
	public Integer deleteTmOutBatch(Integer tmOutBatchId) throws BaseException {
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		return mapper.deleteTmOutBatch(tmOutBatchId);
	}
	
	public List<TmOutBatch> selectAllTmOutBatch() throws BaseException {
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		List<TmOutBatch> allTmOutBatch = mapper.selectAllTmOutBatch();
		return allTmOutBatch;
	}
	
	public List<TmOutBatch> selectAllByRecord(TmOutBatch tmOutBatch) throws BaseException {
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		return mapper.selectAllByRecord(tmOutBatch);
	}
	
	public PageInfo selectPageByRecord(TmOutBatch tmOutBatch) throws BaseException {
		PageModel pageModel = tmOutBatch.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmOutBatchIntf mapper = this.getSqlSessionTemplate().getMapper(TmOutBatchIntf.class);
		mapper.selectAllByRecord(tmOutBatch);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmOutBatch selectOneByRecord(TmOutBatch tmOutBatch) throws BaseException {
		List<TmOutBatch> resultList = selectAllByRecord(tmOutBatch);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmOutBatch saveTmOutBatch(TmOutBatch tmOutBatch, String user, String programId) throws BaseException {
		if(tmOutBatch.getTmOutBatchId() == null){
			tmOutBatch = insertTmOutBatch(tmOutBatch, user, programId);
		}else{
			tmOutBatch = updateTmOutBatch(tmOutBatch, user, programId);
		}
		return tmOutBatch;
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