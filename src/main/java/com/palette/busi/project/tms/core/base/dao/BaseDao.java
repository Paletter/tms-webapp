package com.palette.busi.project.tms.core.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.palette.busi.project.tms.core.base.BaseException;
import com.palette.busi.project.tms.core.base.BasePo;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

public interface BaseDao {
	
	/**
	 * 获取mybatis原生接口
	 * @return
	 * @throws Exception
	 */
	public SqlSession getSqlSessionTemplate() throws BaseException;
	
	/**
	 * 根据Map分页查询
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <MODEL extends BasePo> PageInfo selectPageInfo(String sqlMapId,PageModel pageModel,Map map) throws BaseException;
	
	/**
	 * 根据Object分页查询
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <MODEL extends BasePo> PageInfo selectPageInfo(String sqlMapId,MODEL model) throws BaseException;
	
	/**
	 * 根据Map分页查询
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public PageInfo selectPageInfo(String sqlMapId,Map map) throws BaseException;
	
	/**
	 * 列表查询
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	public List<?> selectList(String sqlMapId,Map<String,Object> map) throws BaseException;
	
	/**
	 * 列表查询
	 * @param sqlMapId
	 * @param obj
	 * @return
	 */
	public List<?> selectList(String sqlMapId,Object model) throws BaseException;
	
	/**
	 * 对象查询
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	public Object selectOne(String sqlMapId,Map<String,Object> map) throws BaseException;
	
	/**
	 * 对象查询
	 * @param sqlMapId
	 * @param obj
	 * @return
	 */
	public <MODEL extends BasePo> MODEL selectOne(String sqlMapId,MODEL model) throws BaseException;
	
	/**
	 * 对象查询
	 * @param sqlMapId
	 * @param obj
	 * @return
	 */
	public Object selectOne(String sqlMapId,Object model) throws BaseException;
	
	/**
	 * 
	 * @param sqlMapId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Object selectByOne(String sqlMapId,Map model) throws BaseException;
	
	/**
	 * 根据Map更新
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	public int update(String sqlMapId,Map<String,Object> map) throws BaseException;
	
	/**
	 * 根据Map更新
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	public int update(String sqlMapId,Object object) throws BaseException;
	
	/**
	 * 根据Map更新
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	public int delete(String sqlMapId,Map<String,Object> map) throws BaseException;
	
	/**
	 * 根据Object更新
	 * @param sqlMapId
	 * @param object
	 * @return
	 */
	public int delete(String sqlMapId,Object model) throws BaseException;
	
	/**
	 * 根据Object新增
	 * @param sqlMapId
	 * @param object
	 * @return
	 */
	public int insert(String sqlMapId,Object model) throws BaseException;
	
	/**
	 * 根据Map新增
	 * @param sqlMapId
	 * @param map
	 * @return
	 */
	public int insert(String sqlMapId,Map<String,Object> map) throws BaseException;
	
	/**
	 * 获取最后一次插入的主键
	 * @return
	 */
	public int getLastPk() throws BaseException;
}
