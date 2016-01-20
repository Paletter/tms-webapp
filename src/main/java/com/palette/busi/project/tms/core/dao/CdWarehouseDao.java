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
import com.palette.busi.project.tms.core.entity.CdWarehouse;
import com.palette.busi.project.tms.core.dao.CdWarehouseIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdWarehouseDao extends BaseDaoImpl {
	
	public CdWarehouse updateCdWarehouse(CdWarehouse cdWarehouse, String user, String programId) throws BaseException {
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		cdWarehouse.setUpdateDateTime(getCurrentGMTDate());
		cdWarehouse.setUpdateUserCode(user);
		mapper.updateCdWarehouse(cdWarehouse);
		return cdWarehouse;
	}
	
	public CdWarehouse insertCdWarehouse(CdWarehouse cdWarehouse, String user, String programId) throws BaseException {
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		cdWarehouse.setCreateDateTime(getCurrentGMTDate());
		cdWarehouse.setCreateUserCode(user);
		cdWarehouse.setUpdateDateTime(getCurrentGMTDate());
		cdWarehouse.setUpdateUserCode(user);
		mapper.insertCdWarehouse(cdWarehouse);
		if(cdWarehouse.getCdWarehouseId() == null){
			cdWarehouse.setCdWarehouseId(getLastPk());
		}
		return cdWarehouse;
	}
	
	public CdWarehouse selectCdWarehouseById(Integer cdWarehouseId) throws BaseException {
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		return mapper.selectCdWarehouseById(cdWarehouseId);
	}
	
	public Integer deleteCdWarehouse(Integer cdWarehouseId) throws BaseException {
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		return mapper.deleteCdWarehouse(cdWarehouseId);
	}
	
	public List<CdWarehouse> selectAllCdWarehouse() throws BaseException {
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		List<CdWarehouse> allCdWarehouse = mapper.selectAllCdWarehouse();
		return allCdWarehouse;
	}
	
	public List<CdWarehouse> selectAllByRecord(CdWarehouse cdWarehouse) throws BaseException {
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		return mapper.selectAllByRecord(cdWarehouse);
	}
	
	public PageInfo selectPageByRecord(CdWarehouse cdWarehouse) throws BaseException {
		PageModel pageModel = cdWarehouse.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdWarehouseIntf mapper = this.getSqlSessionTemplate().getMapper(CdWarehouseIntf.class);
		mapper.selectAllByRecord(cdWarehouse);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdWarehouse selectOneByRecord(CdWarehouse cdWarehouse) throws BaseException {
		List<CdWarehouse> resultList = selectAllByRecord(cdWarehouse);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdWarehouse saveCdWarehouse(CdWarehouse cdWarehouse, String user, String programId) throws BaseException {
		if(cdWarehouse.getCdWarehouseId() == null){
			cdWarehouse = insertCdWarehouse(cdWarehouse, user, programId);
		}else{
			cdWarehouse = updateCdWarehouse(cdWarehouse, user, programId);
		}
		return cdWarehouse;
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