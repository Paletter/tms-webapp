package com.palette.busi.project.tms.business.delivery.outBatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.delivery.outBatch.dto.DeliverOutBatchReqDto;
import com.palette.busi.project.tms.business.delivery.outBatch.dto.QueryOutBatchReqDto;
import com.palette.busi.project.tms.business.delivery.outBatch.service.OutBatchService;
import com.palette.busi.project.tms.business.delivery.outBatch.vo.OutBatchListPageParamVo;
import com.palette.busi.project.tms.business.delivery.outBatch.vo.OutBatchListResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.core.entity.TmOutBatch;
import com.palette.busi.project.tms.core.page.PageInfo;

@RestController
public class OutBatchController extends BaseController {

	public static String CONTROLLER_ID = "OUT_BATCH";
	
	@Autowired
	private OutBatchService outBatchService;
	
	@RequestMapping(value="/OutBatchController/queryOutBatchList")
	public PageInfo<OutBatchListResultVo> queryOutBatchList(@RequestBody QueryOutBatchReqDto reqDto) {
		
		OutBatchListPageParamVo paramVo = new OutBatchListPageParamVo();
		
		BeanUtilsExt.copyProperties(reqDto, paramVo);
		paramVo.setWarehouseCode(getSessionWarehouseCode());
		paramVo.setCompanyCode(getSessionCompanyCode());
		
		PageInfo<OutBatchListResultVo> result = selectPageInfo(SqlMapperConstants.OUT_BATCH_QUERY_OUT_BATCH_LIST, paramVo);
		
		return result;
	}
	
	@RequestMapping(value="/OutBatchController/addOutBatch")
	public TmOutBatch addOutBatch() {
		
		// Business
		TmOutBatch tmOutBatch = outBatchService.createOutBatch(getSessionServiceOptParamLinkerVo());
		
		return tmOutBatch;
	}
	
	@RequestMapping(value="/OutBatchController/deliverOutBatch")
	public boolean deliverOutBatch(@RequestBody DeliverOutBatchReqDto reqDto) {
		
		// Business
		outBatchService.deliverOutBatch(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/OutBatchController/deliverPieces")
	public boolean deliverPieces(@RequestBody DeliverOutBatchReqDto reqDto) {
		
		// Business
		outBatchService.deliverPieces(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
}
