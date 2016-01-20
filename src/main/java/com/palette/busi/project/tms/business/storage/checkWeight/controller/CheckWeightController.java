package com.palette.busi.project.tms.business.storage.checkWeight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightService;
import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightValidateService;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesInfoResultVo;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesQueryParamVo;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CheckWeightUpdateVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;

@RestController
public class CheckWeightController extends BaseController {

	public static String CONTROLLER_ID = "CHECK_WEIGHT";
	
	@Autowired
	private CheckWeightService checkWeightService;
	@Autowired
	private CheckWeightValidateService checkWeightValidateService;
	
	@RequestMapping(value="/CheckWeightController/queryPieces")
	public CWPiecesInfoResultVo queryPieces(@RequestBody CWPiecesQueryParamVo checkWeightPiecesQueryParamVo) {
		
		ThrowExp.isNullOrEmpty(checkWeightPiecesQueryParamVo.getQueryNo(), "操作失败。查询单号不能为空");
		
		checkWeightPiecesQueryParamVo.setQueryNo(StringUtils.toUpperAndTrim(checkWeightPiecesQueryParamVo.getQueryNo()));
		
		// Business
		CWPiecesInfoResultVo resultVo = checkWeightService.queryCheckWeightPieces(checkWeightPiecesQueryParamVo);
		ThrowExp.isNull(resultVo, "操作失败。运单信息不存在");
		
		return resultVo;
	}
	
	@RequestMapping(value="/CheckWeightController/checkWeight")
	public boolean checkWeight(@RequestBody CheckWeightUpdateVo checkWeightUpdateVo) throws Exception {
		
		// Validate
		checkWeightService.formatCheckWeightUpdateVo(checkWeightUpdateVo);
		checkWeightValidateService.validateCheckWeight(checkWeightUpdateVo);
		
		// Business
		checkWeightService.updatePiecesInfoForCkeckWeight(checkWeightUpdateVo, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
}
