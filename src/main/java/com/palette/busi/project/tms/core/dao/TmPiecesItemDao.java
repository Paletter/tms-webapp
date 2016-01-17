package com.palette.busi.project.tms.core.dao;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palette.busi.project.tms.core.base.dao.impl.BaseDaoImpl;
import com.palette.busi.project.tms.core.entity.TmPiecesItem;
import com.palette.busi.project.tms.core.dao.TmPiecesItemIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmPiecesItemDao extends BaseDaoImpl {
	
	public TmPiecesItem updateTmPiecesItem(TmPiecesItem tmPiecesItem) throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		mapper.updateTmPiecesItem(tmPiecesItem);
		return tmPiecesItem;
	}
	
	public TmPiecesItem insertTmPiecesItem(TmPiecesItem tmPiecesItem) throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		mapper.insertTmPiecesItem(tmPiecesItem);
		if(tmPiecesItem.getTmPiecesItemId() == null){
			tmPiecesItem.setTmPiecesItemId(getLastPk());
		}
		return tmPiecesItem;
	}
	
	public TmPiecesItem selectTmPiecesItemById(Integer tmPiecesItemId) throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		return mapper.selectTmPiecesItemById(tmPiecesItemId);
	}
	
	public Integer deleteTmPiecesItem(Integer tmPiecesItemId) throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		return mapper.deleteTmPiecesItem(tmPiecesItemId);
	}
	
	public List<TmPiecesItem> selectAllTmPiecesItem() throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		List<TmPiecesItem> allTmPiecesItem = mapper.selectAllTmPiecesItem();
		return allTmPiecesItem;
	}
	
	public List<TmPiecesItem> selectAllByRecord(TmPiecesItem tmPiecesItem) throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		return mapper.selectAllByRecord(tmPiecesItem);
	}
	
	public PageInfo selectPageByRecord(TmPiecesItem tmPiecesItem) throws Exception {
		PageModel pageModel = tmPiecesItem.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		mapper.selectAllByRecord(tmPiecesItem);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmPiecesItem selectOneByRecord(TmPiecesItem tmPiecesItem) throws Exception {
		List<TmPiecesItem> resultList = selectAllByRecord(tmPiecesItem);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmPiecesItem saveTmPiecesItem(TmPiecesItem tmPiecesItem) throws Exception {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		if(tmPiecesItem.getTmPiecesItemId() == null){
			mapper.insertTmPiecesItem(tmPiecesItem);
			tmPiecesItem = selectTmPiecesItemById(getLastPk());
		}else{
			mapper.updateTmPiecesItem(tmPiecesItem);
			tmPiecesItem = mapper.selectTmPiecesItemById(tmPiecesItem.getTmPiecesItemId());
		}
		return tmPiecesItem;
	}
}