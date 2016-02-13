package com.palette.busi.project.tms.business.basic.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.basic.login.vo.LoginParamVo;
import com.palette.busi.project.tms.business.basic.login.vo.LoginUserJudgeVo;
import com.palette.busi.project.tms.business.basic.login.vo.LoginUserResultVo;
import com.palette.busi.project.tms.business.basic.login.vo.MenuResultVo;
import com.palette.busi.project.tms.business.basic.login.vo.UserCountryAuthQueryParamVo;
import com.palette.busi.project.tms.business.basic.login.vo.UserCountryAuthResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.MD5Utils;
import com.palette.busi.project.tms.common.util.SessionUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.core.dao.CdCountryDao;
import com.palette.busi.project.tms.core.dao.CdCountryRefDao;
import com.palette.busi.project.tms.core.dao.CdUserDao;
import com.palette.busi.project.tms.core.dao.CdWarehouseDao;
import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.entity.CdCountryRef;
import com.palette.busi.project.tms.core.entity.CdRole;
import com.palette.busi.project.tms.core.entity.CdUser;
import com.palette.busi.project.tms.core.entity.CdWarehouse;
import com.palette.busi.project.tms.web.exception.BusinessException;

@RestController
public class LoginController extends BaseController {
	
	@Autowired
	private CdUserDao cdUserDao;
	@Autowired
	private CdWarehouseDao cdWarehouseDao;
	@Autowired
	private CdCountryDao cdCountryDao;
	@Autowired
	private CdCountryRefDao cdCountryRefDao;
	
	@RequestMapping(value="/LoginController/getLoginUserCountryAuth")
	public UserCountryAuthResultVo getLoginUserCountryAuth(@RequestBody UserCountryAuthQueryParamVo paramVo) throws Exception {
		
		// Validate input
		if(StringUtils.isNullOrEmpty(paramVo.getUserName())) {
			throw new BusinessException("用户名不能为空");
		}
		
		if(StringUtils.isNullOrEmpty(paramVo.getPwd())) {
			throw new BusinessException("密码不能为空");
		}
		
		// Query user info
		List<LoginUserJudgeVo> resultList = selectList(SqlMapperConstants.LOGIN_QUERY_LOAD_USER_DETAILS_INFO, paramVo.getUserName());
		
		if(resultList == null || resultList.size() == 0) {
			throw new BusinessException("用户名不存在");
		}
		
		if(resultList.size() > 1) {
			throw new BusinessException("用户名数量大于1，获取权限仓库失败，请联系管理员");
		}
		
		LoginUserJudgeVo judgeVo = resultList.get(0);
		
		// Validate login password and warehouse
		String salt = judgeVo.getSalt();
		String encodePwd = MD5Utils.encrypt(paramVo.getPwd(), salt);
		
		if(!judgeVo.getPwd().equals(encodePwd)) {
			throw new BusinessException("密码错误");
		}
		
		// Return result
		UserCountryAuthResultVo userCountryAuthResultVo = new UserCountryAuthResultVo();
		
		boolean isRoot = false;
		if(judgeVo.getCdRoleList() != null) {
			for(CdRole cdRole : judgeVo.getCdRoleList()) {
				if(cdRole.getCategory() != null && cdRole.getCategory().equals(CodeConstants.USER_ROLE_CATEGORY.ROOT)) {
					isRoot = true;
				}
			}
		}
		
		if(isRoot) {
			List<CdCountry> allCountryList = cdCountryDao.selectAllCdCountry();
			List<CdWarehouse> allWarehouseList = cdWarehouseDao.selectAllCdWarehouse();

			userCountryAuthResultVo.setCdCountryList(allCountryList);
			userCountryAuthResultVo.setCdWarehouseList(allWarehouseList);
		} else {
			userCountryAuthResultVo.setCdCountryList(judgeVo.getCdCountryList());
			userCountryAuthResultVo.setCdWarehouseList(judgeVo.getCdWarehouseList());
		}
		
		return userCountryAuthResultVo;
	}
	
	@RequestMapping("/LoginController/login")
	public LoginUserResultVo login(@RequestBody LoginParamVo loginParamVo) throws Exception {

		// Validate input
		if(StringUtils.isNullOrEmpty(loginParamVo.getUserName())) {
			throw new BusinessException("用户名不能为空");
		}
		
		if(StringUtils.isNullOrEmpty(loginParamVo.getPwd())) {
			throw new BusinessException("密码不能为空");
		}
		
		if(StringUtils.isNullOrEmpty(loginParamVo.getCountryCode())) {
			throw new BusinessException("登录国家不能为空");
		}
		
		if(StringUtils.isNullOrEmpty(loginParamVo.getWarehouseCode())) {
			throw new BusinessException("登录仓库不能为空");
		}
		
		// Query user info
		List<LoginUserJudgeVo> resultList = selectList(SqlMapperConstants.LOGIN_QUERY_LOAD_USER_DETAILS_INFO, loginParamVo.getUserName());
		
		if(resultList == null || resultList.size() == 0) {
			throw new BusinessException("用户名错误");
		}
		
		if(resultList.size() > 1) {
			throw new BusinessException("用户名数量大于1，无法登录，请联系管理员");
		}
		
		LoginUserJudgeVo judgeVo = resultList.get(0);
		
		// Validate login password
		String salt = judgeVo.getSalt();
		String encodePwd = MD5Utils.encrypt(loginParamVo.getPwd(), salt);
		
		if(!judgeVo.getPwd().equals(encodePwd)) {
			throw new BusinessException("密码错误");
		}
		
		// Validate login warehouse
		boolean isRoot = false;
		if(judgeVo.getCdRoleList() != null) {
			for(CdRole cdRole : judgeVo.getCdRoleList()) {
				if(cdRole.getCategory() != null && cdRole.getCategory().equals(CodeConstants.USER_ROLE_CATEGORY.ROOT)) {
					isRoot = true;
				}
			}
		}
		
		if(!isRoot) {
			boolean isNotHaveWareAuth = true;
			for(CdWarehouse cdWarehouse : judgeVo.getCdWarehouseList()) {
				if(cdWarehouse.getWarehouseCode().equals(loginParamVo.getWarehouseCode())
				   && cdWarehouse.getCountryCode().equals(loginParamVo.getCountryCode())) {
					isNotHaveWareAuth = false;
					break;
				}
			}
			
			if(isNotHaveWareAuth) {
				throw new BusinessException("没有该仓库的使用权限");
			}
		}
		
		// Login success
		// Set login user infos to session
		LoginUserResultVo userVo = new LoginUserResultVo();
		try {
			
			CdUser cuQueryParam = new CdUser();
			cuQueryParam.setUserName(loginParamVo.getUserName());
			CdUser cdUser = cdUserDao.selectOneByRecord(cuQueryParam);
			
			CdWarehouse cwQueryParam = new CdWarehouse();
			cwQueryParam.setWarehouseCode(loginParamVo.getWarehouseCode());
			cwQueryParam.setCountryCode(loginParamVo.getCountryCode());
			CdWarehouse cdWarehouse = cdWarehouseDao.selectOneByRecord(cwQueryParam);
			
			CdCountry ccQueryParam = new CdCountry();
			ccQueryParam.setCountryCode(loginParamVo.getCountryCode());
			CdCountry cdCountry = cdCountryDao.selectOneByRecord(ccQueryParam);
			
			CdCountryRef ccrQueryParam = new CdCountryRef();
			ccrQueryParam.setCountryCode(loginParamVo.getCountryCode());
			CdCountryRef cdCountryRef = cdCountryRefDao.selectOneByRecord(ccrQueryParam);
			
			List<MenuResultVo> menuVoList = selectList(SqlMapperConstants.LOGIN_QUERY_USER_MENU, loginParamVo.getUserName());
			
			userVo.setCdUser(cdUser);
			userVo.setCdWarehouse(cdWarehouse);
			userVo.setCdCountry(cdCountry);
			userVo.setCdCountryRef(cdCountryRef);
			userVo.setMenuVoList(menuVoList);
			userVo.setSessionId(request.getSession().getId());
			userVo.setCdRoleList(judgeVo.getCdRoleList());
			userVo.setIsRoot(isRoot);
			
			SessionUtils.saveSession(request.getSession().getId(), userVo);
			
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new BusinessException("登录用户信息读取错误，请联系管理员");
		}
		
		return userVo;
	}
	
	@RequestMapping(value="/LoginController/getCurrentUserDetail")
	public LoginUserResultVo getCurrentUserDetail() {
		
		LoginUserResultVo user = getSessionUserVo();
		return user;
	}
	
	@RequestMapping(value="/LoginController/logout")
	public boolean logout() {
		
		SessionUtils.clearLoginUserSession(request.getSession().getId());
		return true;
	}
}
