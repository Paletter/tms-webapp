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
import com.palette.busi.project.tms.core.entity.CdResource;
import com.palette.busi.project.tms.core.dao.CdResourceIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdResourceDao extends BaseDaoImpl {
	
	public CdResource updateCdResource(CdResource cdResource, String user, String programId) throws BaseException {
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		cdResource.setUpdateDateTime(getCurrentGMTDate());
		cdResource.setUpdateUserCode(user);
		mapper.updateCdResource(cdResource);
		return cdResource;
	}
	
	public CdResource insertCdResource(CdResource cdResource, String user, String programId) throws BaseException {
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		cdResource.setCreateDateTime(getCurrentGMTDate());
		cdResource.setCreateUserCode(user);
		cdResource.setUpdateDateTime(getCurrentGMTDate());
		cdResource.setUpdateUserCode(user);
		mapper.insertCdResource(cdResource);
		if(cdResource.getCdResourceId() == null){
			cdResource.setCdResourceId(getLastPk());
		}
		return cdResource;
	}
	
	public CdResource selectCdResourceById(Integer cdResourceId) throws BaseException {
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		return mapper.selectCdResourceById(cdResourceId);
	}
	
	public Integer deleteCdResource(Integer cdResourceId) throws BaseException {
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		return mapper.deleteCdResource(cdResourceId);
	}
	
	public List<CdResource> selectAllCdResource() throws BaseException {
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		List<CdResource> allCdResource = mapper.selectAllCdResource();
		return allCdResource;
	}
	
	public List<CdResource> selectAllByRecord(CdResource cdResource) throws BaseException {
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		return mapper.selectAllByRecord(cdResource);
	}
	
	public PageInfo selectPageByRecord(CdResource cdResource) throws BaseException {
		PageModel pageModel = cdResource.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdResourceIntf mapper = this.getSqlSessionTemplate().getMapper(CdResourceIntf.class);
		mapper.selectAllByRecord(cdResource);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdResource selectOneByRecord(CdResource cdResource) throws BaseException {
		List<CdResource> resultList = selectAllByRecord(cdResource);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdResource saveCdResource(CdResource cdResource, String user, String programId) throws BaseException {
		if(cdResource.getCdResourceId() == null){
			cdResource = insertCdResource(cdResource, user, programId);
		}else{
			cdResource = updateCdResource(cdResource, user, programId);
		}
		return cdResource;
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