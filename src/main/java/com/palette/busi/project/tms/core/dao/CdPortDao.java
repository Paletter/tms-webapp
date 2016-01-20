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
import com.palette.busi.project.tms.core.entity.CdPort;
import com.palette.busi.project.tms.core.dao.CdPortIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdPortDao extends BaseDaoImpl {
	
	public CdPort updateCdPort(CdPort cdPort, String user, String programId) throws BaseException {
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		cdPort.setUpdateDateTime(getCurrentGMTDate());
		cdPort.setUpdateUserCode(user);
		mapper.updateCdPort(cdPort);
		return cdPort;
	}
	
	public CdPort insertCdPort(CdPort cdPort, String user, String programId) throws BaseException {
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		cdPort.setCreateDateTime(getCurrentGMTDate());
		cdPort.setCreateUserCode(user);
		cdPort.setUpdateDateTime(getCurrentGMTDate());
		cdPort.setUpdateUserCode(user);
		mapper.insertCdPort(cdPort);
		if(cdPort.getCdPortId() == null){
			cdPort.setCdPortId(getLastPk());
		}
		return cdPort;
	}
	
	public CdPort selectCdPortById(Integer cdPortId) throws BaseException {
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		return mapper.selectCdPortById(cdPortId);
	}
	
	public Integer deleteCdPort(Integer cdPortId) throws BaseException {
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		return mapper.deleteCdPort(cdPortId);
	}
	
	public List<CdPort> selectAllCdPort() throws BaseException {
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		List<CdPort> allCdPort = mapper.selectAllCdPort();
		return allCdPort;
	}
	
	public List<CdPort> selectAllByRecord(CdPort cdPort) throws BaseException {
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		return mapper.selectAllByRecord(cdPort);
	}
	
	public PageInfo selectPageByRecord(CdPort cdPort) throws BaseException {
		PageModel pageModel = cdPort.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdPortIntf mapper = this.getSqlSessionTemplate().getMapper(CdPortIntf.class);
		mapper.selectAllByRecord(cdPort);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdPort selectOneByRecord(CdPort cdPort) throws BaseException {
		List<CdPort> resultList = selectAllByRecord(cdPort);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdPort saveCdPort(CdPort cdPort, String user, String programId) throws BaseException {
		if(cdPort.getCdPortId() == null){
			cdPort = insertCdPort(cdPort, user, programId);
		}else{
			cdPort = updateCdPort(cdPort, user, programId);
		}
		return cdPort;
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