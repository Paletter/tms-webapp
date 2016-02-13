package com.palette.busi.project.tms.business.storage.checkWeight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.storage.checkWeight.dto.CheckWeightReqDto;
import com.palette.busi.project.tms.business.storage.checkWeight.dto.QueryCheckWeightPiecesReqDto;
import com.palette.busi.project.tms.business.storage.checkWeight.dto.QueryCheckWeightPiecesRespDto;
import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightService;
import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightValidateService;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesInfoResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
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
	public QueryCheckWeightPiecesRespDto queryPieces(@RequestBody QueryCheckWeightPiecesReqDto reqDto) {
		
		// Validate
		ThrowExp.isNullOrEmpty(reqDto.getQueryNo(), "操作失败。查询单号不能为空");
		
		reqDto.setQueryNo(StringUtils.toUpperAndTrim(reqDto.getQueryNo()));
		
		// Business
		CWPiecesInfoResultVo piecesInfoResultVo = checkWeightService.queryCheckWeightPieces(reqDto);
		ThrowExp.isNull(piecesInfoResultVo, "操作失败。运单信息不存在");
		
		// Encapsulation result
		QueryCheckWeightPiecesRespDto respDto = new QueryCheckWeightPiecesRespDto();
		BeanUtilsExt.copyPropertiesIgnoreDefault(piecesInfoResultVo, respDto);
		
		return respDto;
	}
	
	@RequestMapping(value="/CheckWeightController/checkWeight")
	public boolean checkWeight(@RequestBody CheckWeightReqDto reqDto) throws Exception {
		
		// Validate
		checkWeightService.formatCheckWeightUpdateVo(reqDto);
		checkWeightValidateService.validateCheckWeight(reqDto);
		
		// Business
		checkWeightService.updatePiecesInfoForCkeckWeight(reqDto, getSessionLinkerVo());
		
		return true;
	}
}
