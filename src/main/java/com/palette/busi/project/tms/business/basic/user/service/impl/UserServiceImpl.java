package com.palette.busi.project.tms.business.basic.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.basic.user.controller.UserController;
import com.palette.busi.project.tms.business.basic.user.dto.AddUserReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.ResetPwdReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserAuthRoleReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserAuthWareReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserReqDto;
import com.palette.busi.project.tms.business.basic.user.service.UserService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.MD5Utils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.CdUserDao;
import com.palette.busi.project.tms.core.dao.CdUserPwdDao;
import com.palette.busi.project.tms.core.dao.CdUserRoleDao;
import com.palette.busi.project.tms.core.dao.CdUserWarehouseDao;
import com.palette.busi.project.tms.core.entity.CdUser;
import com.palette.busi.project.tms.core.entity.CdUserPwd;
import com.palette.busi.project.tms.core.entity.CdUserRole;
import com.palette.busi.project.tms.core.entity.CdUserWarehouse;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private CdUserDao cdUserDao;
	@Autowired
	private CdUserPwdDao cdUserPwdDao;
	@Autowired
	private CdUserWarehouseDao cdUserWarehouseDao;
	@Autowired
	private CdUserRoleDao cdUserRoleDao;
	
	@Override
	public CdUser createUserInfo(AddUserReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Insert user
		CdUser cdUser = new CdUser();
		cdUser.setUserName(reqDto.getUserName());
		cdUser.setFullName(reqDto.getFullName());
		cdUser.setMemo(reqDto.getMemo());
		cdUser.setCompanyCode(reqDto.getCompanyCode());
		cdUser.setIsActive(1);
		
		cdUserDao.insertCdUser(cdUser, linkerVo.getUserName(), UserController.CONTROLLER_ID);
		
		// Insert user pwd
		CdUserPwd cdUserPwd = new CdUserPwd();
		cdUserPwd.setCdUserId(cdUser.getCdUserId());
		cdUserPwd.setUserName(cdUser.getUserName());
		String salt = MD5Utils.getSalt();
		String pwdStr = MD5Utils.encrypt(reqDto.getPwd(),salt);
		cdUserPwd.setSalt(salt);
		cdUserPwd.setPwd(pwdStr);
		
		cdUserPwdDao.insertCdUserPwd(cdUserPwd, linkerVo.getUserName(), UserController.CONTROLLER_ID);
		
		return cdUser;
	}
	
	@Override
	public CdUser updateUserInfo(UpdateUserReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update user
		CdUser updateUser = querier.selectCdUserById(reqDto.getCdUserId());
		updateUser.setUserName(reqDto.getUserName());
		updateUser.setFullName(reqDto.getFullName());
		updateUser.setMemo(reqDto.getMemo());
		updateUser.setCompanyCode(reqDto.getCompanyCode());
		updateUser.setIsActive(reqDto.getIsActive());
		
		cdUserDao.updateCdUser(updateUser, linkerVo.getUserName(), UserController.CONTROLLER_ID);
		
		return updateUser;
	}
	
	@Override
	public void resetPwd(ResetPwdReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdUserPwd cdUserPwdQuery = new CdUserPwd();
		cdUserPwdQuery.setCdUserId(reqDto.getCdUserId());
		CdUserPwd updatePwd = querier.selectCdUserPwdOneByRecord(cdUserPwdQuery);
		
		String salt = MD5Utils.getSalt();
		String pwdStr = MD5Utils.encrypt("123456", salt);
		updatePwd.setSalt(salt);
		updatePwd.setPwd(pwdStr);
		
		cdUserPwdDao.updateCdUserPwd(updatePwd, linkerVo.getUserName(), UserController.CONTROLLER_ID);
	}
	
	@Override
	public CdUserWarehouse insertUserWarehouse(UpdateUserAuthWareReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdUserWarehouse cdUserWarehouse = new CdUserWarehouse();
		cdUserWarehouse.setCdUserId(reqDto.getCdUserId());
		cdUserWarehouse.setCdWarehouseId(reqDto.getCdWarehouseId());
		cdUserWarehouseDao.insertCdUserWarehouse(cdUserWarehouse, linkerVo.getUserName(), UserController.CONTROLLER_ID);
		
		return cdUserWarehouse;
	}
	
	@Override
	public void deleteUserWarehouse(UpdateUserAuthWareReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdUserWarehouse cdUserWareQuery = new CdUserWarehouse();
		cdUserWareQuery.setCdUserId(reqDto.getCdUserId());
		cdUserWareQuery.setCdWarehouseId(reqDto.getCdWarehouseId());
		CdUserWarehouse cdUserWare = querier.selectCdUserWarehouseOneByRecord(cdUserWareQuery);
		
		cdUserWarehouseDao.deleteCdUserWarehouse(cdUserWare.getCdUserWarehouseId());
	}
	
	@Override
	public void updateUserRole(UpdateUserAuthRoleReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		CdUserRole cdUserRoleQuery = new CdUserRole();
		cdUserRoleQuery.setCdUserId(reqDto.getCdUserId());
		CdUserRole cdUserRole = querier.selectCdUserRoleOneByRecord(cdUserRoleQuery);
		if(cdUserRole == null) {
			cdUserRole = new CdUserRole();
		}
		
		cdUserRole.setCdUserId(reqDto.getCdUserId());
		cdUserRole.setCdRoleId(reqDto.getCdRoleId());
		
		cdUserRoleDao.saveCdUserRole(cdUserRole, linkerVo.getUserName(), UserController.CONTROLLER_ID);
	}
}
