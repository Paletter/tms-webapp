package com.palette.busi.project.tms.business.basic.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.basic.user.dto.AddUserReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.QueryUserAuthReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.QueryUserReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.ResetPwdReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserAuthRoleReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserAuthWareReqDto;
import com.palette.busi.project.tms.business.basic.user.dto.UpdateUserReqDto;
import com.palette.busi.project.tms.business.basic.user.service.UserService;
import com.palette.busi.project.tms.business.basic.user.service.UserValidateService;
import com.palette.busi.project.tms.business.basic.user.vo.QueryUserPageParamVo;
import com.palette.busi.project.tms.business.basic.user.vo.QueryUserResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.core.entity.CdRole;
import com.palette.busi.project.tms.core.entity.CdWarehouse;
import com.palette.busi.project.tms.core.page.PageInfo;

@RestController
public class UserController extends BaseController {

	public static String CONTROLLER_ID = "USER";
	
	@Autowired
	private UserValidateService userValidateService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/UserController/queryUser")
	public PageInfo<QueryUserResultVo> queryUser(@RequestBody QueryUserReqDto reqDto) {
		
		// Business
		QueryUserPageParamVo paramVo = new QueryUserPageParamVo();
		BeanUtilsExt.copyProperties(reqDto, paramVo);
		PageInfo<QueryUserResultVo> result = selectPageInfo(SqlMapperConstants.USER_QUERY_USER_LIST, paramVo);
		
		return result;
	}
	
	@RequestMapping(value="/UserController/addUser")
	public boolean addUser(@RequestBody AddUserReqDto reqDto) {
		
		// Validate
		userValidateService.validateAddUser(reqDto);
		
		// Business
		userService.createUserInfo(reqDto, getSessionLinkerVo());
		
		return true;
	}

	@RequestMapping(value="/UserController/updateUser")
	public boolean updateUser(@RequestBody UpdateUserReqDto reqDto) {
		
		// Validate
		userValidateService.validateUpdateUser(reqDto);
		
		// Business
		userService.updateUserInfo(reqDto, getSessionLinkerVo());
		
		return true;
	}

	@RequestMapping(value="/UserController/resetPwd")
	public boolean resetPwd(@RequestBody ResetPwdReqDto reqDto) {
		
		// Business
		userService.resetPwd(reqDto, getSessionLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/UserController/queryUserAuthWare")
	public List<CdWarehouse> queryUserAuthWare(@RequestBody QueryUserAuthReqDto reqDto) {
		
		// Business
		List<CdWarehouse> wareList = selectList(SqlMapperConstants.USER_QUERY_USER_AUTH_WARE, reqDto.getCdUserId());
		
		return wareList;
	}
	
	@RequestMapping(value="/UserController/addUserAuthWare")
	public boolean addUserAuthWare(@RequestBody UpdateUserAuthWareReqDto reqDto) {
		
		// Business
		userService.insertUserWarehouse(reqDto, getSessionLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/UserController/removeUserAuthWare")
	public boolean removeUserAuthWare(@RequestBody UpdateUserAuthWareReqDto reqDto) {
		
		// Business
		userService.deleteUserWarehouse(reqDto, getSessionLinkerVo());
		
		return true;
	}

	@RequestMapping(value="/UserController/queryUserAuthRole")
	public CdRole queryUserAuthRole(@RequestBody QueryUserAuthReqDto reqDto) {
		
		// Business
		CdRole role = selectOne(SqlMapperConstants.USER_QUERY_USER_AUTH_ROLE, reqDto.getCdUserId());
		
		return role;
	}	
	
	@RequestMapping(value="/UserController/updateUserAuthRole")
	public boolean updateUserAuthRole(@RequestBody UpdateUserAuthRoleReqDto reqDto) {
	
		// Business
		userService.updateUserRole(reqDto, getSessionLinkerVo());
		
		return true;
	}
}
