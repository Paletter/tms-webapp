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
import com.palette.busi.project.tms.core.entity.CrMember;
import com.palette.busi.project.tms.core.dao.CrMemberIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CrMemberDao extends BaseDaoImpl {
	
	public CrMember updateCrMember(CrMember crMember, String user, String programId) throws BaseException {
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		crMember.setUpdateDateTime(getCurrentGMTDate());
		crMember.setUpdateUserCode(user);
		mapper.updateCrMember(crMember);
		return crMember;
	}
	
	public CrMember insertCrMember(CrMember crMember, String user, String programId) throws BaseException {
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		crMember.setCreateDateTime(getCurrentGMTDate());
		crMember.setCreateUserCode(user);
		crMember.setUpdateDateTime(getCurrentGMTDate());
		crMember.setUpdateUserCode(user);
		mapper.insertCrMember(crMember);
		if(crMember.getCrMemberId() == null){
			crMember.setCrMemberId(getLastPk());
		}
		return crMember;
	}
	
	public CrMember selectCrMemberById(Integer crMemberId) throws BaseException {
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		return mapper.selectCrMemberById(crMemberId);
	}
	
	public Integer deleteCrMember(Integer crMemberId) throws BaseException {
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		return mapper.deleteCrMember(crMemberId);
	}
	
	public List<CrMember> selectAllCrMember() throws BaseException {
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		List<CrMember> allCrMember = mapper.selectAllCrMember();
		return allCrMember;
	}
	
	public List<CrMember> selectAllByRecord(CrMember crMember) throws BaseException {
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		return mapper.selectAllByRecord(crMember);
	}
	
	public PageInfo selectPageByRecord(CrMember crMember) throws BaseException {
		PageModel pageModel = crMember.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CrMemberIntf mapper = this.getSqlSessionTemplate().getMapper(CrMemberIntf.class);
		mapper.selectAllByRecord(crMember);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CrMember selectOneByRecord(CrMember crMember) throws BaseException {
		List<CrMember> resultList = selectAllByRecord(crMember);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CrMember saveCrMember(CrMember crMember, String user, String programId) throws BaseException {
		if(crMember.getCrMemberId() == null){
			crMember = insertCrMember(crMember, user, programId);
		}else{
			crMember = updateCrMember(crMember, user, programId);
		}
		return crMember;
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