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
import com.palette.busi.project.tms.core.entity.CdAttachmentRef;
import com.palette.busi.project.tms.core.dao.CdAttachmentRefIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdAttachmentRefDao extends BaseDaoImpl {
	
	public CdAttachmentRef updateCdAttachmentRef(CdAttachmentRef cdAttachmentRef, String user, String programId) throws BaseException {
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		cdAttachmentRef.setUpdateDateTime(getCurrentGMTDate());
		cdAttachmentRef.setUpdateUserCode(user);
		mapper.updateCdAttachmentRef(cdAttachmentRef);
		return cdAttachmentRef;
	}
	
	public CdAttachmentRef insertCdAttachmentRef(CdAttachmentRef cdAttachmentRef, String user, String programId) throws BaseException {
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		cdAttachmentRef.setCreateDateTime(getCurrentGMTDate());
		cdAttachmentRef.setCreateUserCode(user);
		cdAttachmentRef.setUpdateDateTime(getCurrentGMTDate());
		cdAttachmentRef.setUpdateUserCode(user);
		mapper.insertCdAttachmentRef(cdAttachmentRef);
		if(cdAttachmentRef.getCdAttachmentRefId() == null){
			cdAttachmentRef.setCdAttachmentRefId(getLastPk());
		}
		return cdAttachmentRef;
	}
	
	public CdAttachmentRef selectCdAttachmentRefById(Integer cdAttachmentRefId) throws BaseException {
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		return mapper.selectCdAttachmentRefById(cdAttachmentRefId);
	}
	
	public Integer deleteCdAttachmentRef(Integer cdAttachmentRefId) throws BaseException {
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		return mapper.deleteCdAttachmentRef(cdAttachmentRefId);
	}
	
	public List<CdAttachmentRef> selectAllCdAttachmentRef() throws BaseException {
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		List<CdAttachmentRef> allCdAttachmentRef = mapper.selectAllCdAttachmentRef();
		return allCdAttachmentRef;
	}
	
	public List<CdAttachmentRef> selectAllByRecord(CdAttachmentRef cdAttachmentRef) throws BaseException {
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		return mapper.selectAllByRecord(cdAttachmentRef);
	}
	
	public PageInfo selectPageByRecord(CdAttachmentRef cdAttachmentRef) throws BaseException {
		PageModel pageModel = cdAttachmentRef.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdAttachmentRefIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentRefIntf.class);
		mapper.selectAllByRecord(cdAttachmentRef);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdAttachmentRef selectOneByRecord(CdAttachmentRef cdAttachmentRef) throws BaseException {
		List<CdAttachmentRef> resultList = selectAllByRecord(cdAttachmentRef);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdAttachmentRef saveCdAttachmentRef(CdAttachmentRef cdAttachmentRef, String user, String programId) throws BaseException {
		if(cdAttachmentRef.getCdAttachmentRefId() == null){
			cdAttachmentRef = insertCdAttachmentRef(cdAttachmentRef, user, programId);
		}else{
			cdAttachmentRef = updateCdAttachmentRef(cdAttachmentRef, user, programId);
		}
		return cdAttachmentRef;
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