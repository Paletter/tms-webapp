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
import com.palette.busi.project.tms.core.entity.TmConsignmentItem;
import com.palette.busi.project.tms.core.dao.TmConsignmentItemIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmConsignmentItemDao extends BaseDaoImpl {
	
	public TmConsignmentItem updateTmConsignmentItem(TmConsignmentItem tmConsignmentItem, String user, String programId) throws BaseException {
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		tmConsignmentItem.setUpdateDateTime(getCurrentGMTDate());
		tmConsignmentItem.setUpdateUserCode(user);
		mapper.updateTmConsignmentItem(tmConsignmentItem);
		return tmConsignmentItem;
	}
	
	public TmConsignmentItem insertTmConsignmentItem(TmConsignmentItem tmConsignmentItem, String user, String programId) throws BaseException {
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		tmConsignmentItem.setCreateDateTime(getCurrentGMTDate());
		tmConsignmentItem.setCreateUserCode(user);
		tmConsignmentItem.setUpdateDateTime(getCurrentGMTDate());
		tmConsignmentItem.setUpdateUserCode(user);
		mapper.insertTmConsignmentItem(tmConsignmentItem);
		if(tmConsignmentItem.getTmConsignmentItemId() == null){
			tmConsignmentItem.setTmConsignmentItemId(getLastPk());
		}
		return tmConsignmentItem;
	}
	
	public TmConsignmentItem selectTmConsignmentItemById(Integer tmConsignmentItemId) throws BaseException {
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		return mapper.selectTmConsignmentItemById(tmConsignmentItemId);
	}
	
	public Integer deleteTmConsignmentItem(Integer tmConsignmentItemId) throws BaseException {
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		return mapper.deleteTmConsignmentItem(tmConsignmentItemId);
	}
	
	public List<TmConsignmentItem> selectAllTmConsignmentItem() throws BaseException {
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		List<TmConsignmentItem> allTmConsignmentItem = mapper.selectAllTmConsignmentItem();
		return allTmConsignmentItem;
	}
	
	public List<TmConsignmentItem> selectAllByRecord(TmConsignmentItem tmConsignmentItem) throws BaseException {
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		return mapper.selectAllByRecord(tmConsignmentItem);
	}
	
	public PageInfo selectPageByRecord(TmConsignmentItem tmConsignmentItem) throws BaseException {
		PageModel pageModel = tmConsignmentItem.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmConsignmentItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmConsignmentItemIntf.class);
		mapper.selectAllByRecord(tmConsignmentItem);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmConsignmentItem selectOneByRecord(TmConsignmentItem tmConsignmentItem) throws BaseException {
		List<TmConsignmentItem> resultList = selectAllByRecord(tmConsignmentItem);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmConsignmentItem saveTmConsignmentItem(TmConsignmentItem tmConsignmentItem, String user, String programId) throws BaseException {
		if(tmConsignmentItem.getTmConsignmentItemId() == null){
			tmConsignmentItem = insertTmConsignmentItem(tmConsignmentItem, user, programId);
		}else{
			tmConsignmentItem = updateTmConsignmentItem(tmConsignmentItem, user, programId);
		}
		return tmConsignmentItem;
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