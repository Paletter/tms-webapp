package com.palette.busi.project.tms.common.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.palette.busi.project.tms.business.basic.login.vo.LoginUserResultVo;
import com.palette.busi.project.tms.common.provider.CommonServiceProvider;
import com.palette.busi.project.tms.common.util.SessionUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.base.BasePo;
import com.palette.busi.project.tms.core.base.dao.BaseDao;
import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.entity.CdCountryRef;
import com.palette.busi.project.tms.core.entity.CdWarehouse;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.service.EntityGeneralQuerier;
import com.palette.busi.project.tms.web.exception.BusinessException;

public class BaseController {

	public Logger log = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected BaseDao baseDao;
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected EntityGeneralQuerier querier;
	@Autowired
	protected CommonServiceProvider servicePvd;
	
	private BaseManageOptVo baseManageOptVo;
	private ServiceOptParamLinkerVo serviceOptParamLinkerVo;
	
	public BaseController() {
		baseManageOptVo = new BaseManageOptVo();
		serviceOptParamLinkerVo = new ServiceOptParamLinkerVo();
	}
	
	// ============================================================
	// Get commonly used param
	
	protected LoginUserResultVo getSessionUserVo() {
		LoginUserResultVo user = SessionUtils.getLoginUserSession(request.getSession().getId());
		return user;
	}

	protected String getSessionUserName() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdUser() != null
		   && user.getCdUser().getUserName() != null) {
			
			return user.getCdUser().getUserName(); 
		}
		
		return "";
	}
	
	protected String getSessionWarehouseCode() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdWarehouse() != null
		   && user.getCdWarehouse().getWarehouseCode() != null) {
			
			return user.getCdWarehouse().getWarehouseCode();
		}
		
		return "";
	}
	
	protected String getSessionWarehouseDesc() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdWarehouse() != null
		   && user.getCdWarehouse().getWarehouseDesc() != null) {
			
			return user.getCdWarehouse().getWarehouseDesc();
		}
		
		return "";
	}
	
	protected CdWarehouse getSessionWarehouse() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdWarehouse() != null) {
			
			return user.getCdWarehouse();
		}
		
		return new CdWarehouse();
	}
	
	protected String getSessionCountryCode() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdWarehouse() != null
		   && user.getCdWarehouse().getCountryCode() != null) {
			
			return user.getCdWarehouse().getCountryCode();
		}
		
		return "";
	}
	
	protected String getSessionWeightUnit() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdCountryRef() != null
		   && user.getCdCountryRef().getWeightUnit() != null) {
			
			return user.getCdCountryRef().getWeightUnit();
		}
		
		return "";
	}
	
	protected String getSessionVolumeUnit() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdCountryRef() != null
		   && user.getCdCountryRef().getVolumeUnit() != null) {
			
			return user.getCdCountryRef().getVolumeUnit();
		}
		
		return "";
	}
	
	protected CdCountryRef getSessionCountryRef() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdCountryRef() != null) {
			
			return user.getCdCountryRef();
		}
		
		return null;
	}
	
	protected String getServletRealPath() {
		String path = request.getServletContext().getRealPath("");
		return path;
	}
	
	protected CdCountry getSessionCountry() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdCountry() != null) {
			
			return user.getCdCountry(); 
		}
		
		return null;
	}
	
	protected String getSessionCompanyCode() {
		LoginUserResultVo user = getSessionUserVo();
		if(user != null
		   && user.getCdCompany() != null
		   && user.getCdCompany().getCompanyCode() != null) {
			
			return user.getCdCompany().getCompanyCode();
		}
		
		return null;
	}
	
	// ============================================================
	// Encapsulation commonly used session param obj
	
	public BaseManageOptVo getSessionBaseManageOptVo() {
		baseManageOptVo.setCountryCode(getSessionCountryCode());
		baseManageOptVo.setWarehouseCode(getSessionWarehouseCode());
		return baseManageOptVo;
	}
	
	public ServiceOptParamLinkerVo getSessionLinkerVo() {
		serviceOptParamLinkerVo.setUserName(getSessionUserName());
		serviceOptParamLinkerVo.setWeightUnit(getSessionWeightUnit());
		serviceOptParamLinkerVo.setVolumnUnit(getSessionVolumeUnit());
		serviceOptParamLinkerVo.setCountryCode(getSessionCountryCode());
		serviceOptParamLinkerVo.setWarehouseCode(getSessionWarehouseCode());
		serviceOptParamLinkerVo.setWarehouseDesc(getSessionWarehouseDesc());
		serviceOptParamLinkerVo.setConvertToKg(getSessionCountryRef().getConvertToKg());
		serviceOptParamLinkerVo.setCompanyCode(getSessionCompanyCode());
		return serviceOptParamLinkerVo;
	}
	
	// ============================================================
	// Commonly used db method
	
	protected <T> List<T> selectList(String sql, Object param) {
		return (List<T>) baseDao.selectList(sql, param);
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
}
