package com.palette.busi.project.tms.common.base;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.common.provider.CommonServiceProvider;
import com.palette.busi.project.tms.core.base.BasePo;
import com.palette.busi.project.tms.core.base.dao.BaseDao;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.service.EntityGeneralQuerier;
import com.palette.busi.project.tms.web.exception.BusinessException;

@Service
@Transactional
public class BaseServiceImpl {
	
	public Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	protected CommonServiceProvider servicePvd;
	@Autowired
	protected BaseDao baseDao;
	@Autowired
	protected EntityGeneralQuerier querier;
	
	// ============================================================
	// Commonly used db method
	protected <T> List<T> selectList(String sql, Object param) {
		return (List<T>) baseDao.selectList(sql, param);
	}
	
	protected <T> List<T> selectList(String sql) {
		return (List<T>) baseDao.selectList(sql, null);
	}
	
	protected <T> T selectOne(String sql, Object param) {
		return (T) baseDao.selectOne(sql, param);
	}
	
	protected <T> T selectOneWithEx(String sql, Object param) {
		List<T> list = (List<T>) baseDao.selectList(sql, param);
		if(list != null && list.size() > 1) throw new BusinessException("操作失败。查询单条数据返回多条结果集错误");
		return list == null || list.size() == 0 ? null : list.get(0);
	}
	
	protected <T extends BasePo> PageInfo selectPageInfo(String sql, T param) {
		return baseDao.selectPageInfo(sql, param);
	}
	
	public int delete(String sqlMapId, Object param) {
		return baseDao.delete(sqlMapId, param);
	}
}
