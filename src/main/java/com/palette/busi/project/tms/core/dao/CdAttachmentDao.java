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
import com.palette.busi.project.tms.core.entity.CdAttachment;
import com.palette.busi.project.tms.core.dao.CdAttachmentIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdAttachmentDao extends BaseDaoImpl {
	
	public CdAttachment updateCdAttachment(CdAttachment cdAttachment, String user, String programId) throws BaseException {
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		cdAttachment.setUpdateDateTime(getCurrentGMTDate());
		cdAttachment.setUpdateUserCode(user);
		mapper.updateCdAttachment(cdAttachment);
		return cdAttachment;
	}
	
	public CdAttachment insertCdAttachment(CdAttachment cdAttachment, String user, String programId) throws BaseException {
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		cdAttachment.setCreateDateTime(getCurrentGMTDate());
		cdAttachment.setCreateUserCode(user);
		cdAttachment.setUpdateDateTime(getCurrentGMTDate());
		cdAttachment.setUpdateUserCode(user);
		mapper.insertCdAttachment(cdAttachment);
		if(cdAttachment.getCdAttachmentId() == null){
			cdAttachment.setCdAttachmentId(getLastPk());
		}
		return cdAttachment;
	}
	
	public CdAttachment selectCdAttachmentById(Integer cdAttachmentId) throws BaseException {
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		return mapper.selectCdAttachmentById(cdAttachmentId);
	}
	
	public Integer deleteCdAttachment(Integer cdAttachmentId) throws BaseException {
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		return mapper.deleteCdAttachment(cdAttachmentId);
	}
	
	public List<CdAttachment> selectAllCdAttachment() throws BaseException {
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		List<CdAttachment> allCdAttachment = mapper.selectAllCdAttachment();
		return allCdAttachment;
	}
	
	public List<CdAttachment> selectAllByRecord(CdAttachment cdAttachment) throws BaseException {
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		return mapper.selectAllByRecord(cdAttachment);
	}
	
	public PageInfo selectPageByRecord(CdAttachment cdAttachment) throws BaseException {
		PageModel pageModel = cdAttachment.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdAttachmentIntf mapper = this.getSqlSessionTemplate().getMapper(CdAttachmentIntf.class);
		mapper.selectAllByRecord(cdAttachment);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdAttachment selectOneByRecord(CdAttachment cdAttachment) throws BaseException {
		List<CdAttachment> resultList = selectAllByRecord(cdAttachment);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdAttachment saveCdAttachment(CdAttachment cdAttachment, String user, String programId) throws BaseException {
		if(cdAttachment.getCdAttachmentId() == null){
			cdAttachment = insertCdAttachment(cdAttachment, user, programId);
		}else{
			cdAttachment = updateCdAttachment(cdAttachment, user, programId);
		}
		return cdAttachment;
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