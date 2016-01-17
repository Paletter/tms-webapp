package com.palette.busi.project.tms.core.base.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.core.base.BaseException;
import com.palette.busi.project.tms.core.base.BasePo;
import com.palette.busi.project.tms.core.base.dao.BaseDao;
import com.palette.busi.project.tms.core.base.dao.SqlSessionTemplateHolder;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Service
@Transactional
public class BaseDaoImpl implements BaseDao {
	
	public static final String SQL_MAPPER_BASE_NAMESPACE = "com.palette.busi.project.tms.core.mapper.sql_mapper_base.";
	
	/**
	 * 查询ID
	 */
	public static final String SELECT_LAST_PK = SQL_MAPPER_BASE_NAMESPACE + "selectLastPk";
	
	@Resource
	private SqlSessionTemplateHolder sqlSessionTemplateHolder;
	
	@Override
	public SqlSession getSqlSessionTemplate(){
		return this.sqlSessionTemplateHolder.getSqlSessionTemplate();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public <MODEL extends BasePo> PageInfo selectPageInfo(String sqlMapId,PageModel pageModel,Map map){
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		getSqlSessionTemplate().selectList(sqlMapId, map);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public <MODEL extends BasePo> PageInfo selectPageInfo(String sqlMapId,MODEL model){
		PageModel pageModel = model.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		getSqlSessionTemplate().selectList(sqlMapId, model);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	@Override
	public PageInfo selectPageInfo(String sqlMapId, Map map) throws BaseException {
		PageModel pageModel = new PageModel();
		LinkedHashMap pageMap =  (LinkedHashMap) map.get("pageInfo");
		pageModel.setPageNum((int) pageMap.get("pageNum"));
		pageModel.setPageSize((int) pageMap.get("pageSize"));
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		getSqlSessionTemplate().selectList(sqlMapId, map);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}

	@Override
	public List<?> selectList(String sqlMapId,Map<String,Object> map){
		return getSqlSessionTemplate().selectList(sqlMapId, map);
	}
	
	@Override
	public List<?> selectList(String sqlMapId,Object object){
		return getSqlSessionTemplate().selectList(sqlMapId, object);
	}
	
	@Override
	public Object selectOne(String sqlMapId,Map<String,Object> map){
		List list = getSqlSessionTemplate().selectList(sqlMapId, map);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	@Override
	public <MODEL extends BasePo> MODEL selectOne(String sqlMapId,MODEL model){
		List<MODEL> list = getSqlSessionTemplate().selectList(sqlMapId, model);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	@Override
	public Object selectOne(String sqlMapId,Object model){
		List list = getSqlSessionTemplate().selectList(sqlMapId, model);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	@Override
	public Object selectByOne(String sqlMapId,Map model){
		return getSqlSessionTemplate().selectOne(sqlMapId, model);
	}
	
	/**
	 * 根据Map更新
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	@Override
	public int update(String sqlMapId,Map<String,Object> map) throws BaseException {
		return getSqlSessionTemplate().update(sqlMapId, map);
	}
	@Override
	public int update(String sqlMapId, Object object) throws BaseException {
		return getSqlSessionTemplate().update(sqlMapId, object);
	}
	
	@Override
	public int delete(String sqlMapId,Map<String,Object> map) throws BaseException {
		return getSqlSessionTemplate().delete(sqlMapId, map);
	}
	
	@Override
	public int delete(String sqlMapId, Object model) throws BaseException {
		return getSqlSessionTemplate().delete(sqlMapId, model);
	}
	
	@Override
	public int insert(String sqlMapId, Object object) throws BaseException {
		return getSqlSessionTemplate().insert(sqlMapId, object);
	}
	
	@Override
	public int insert(String sqlMapId,Map<String,Object> map) throws BaseException {
		return getSqlSessionTemplate().insert(sqlMapId, map);
	}
	
	@Override
	public int getLastPk() throws BaseException {
		return getSqlSessionTemplate().selectOne(SELECT_LAST_PK);
	}

}
