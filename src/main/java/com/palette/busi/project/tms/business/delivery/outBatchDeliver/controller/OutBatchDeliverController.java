package com.palette.busi.project.tms.business.delivery.outBatchDeliver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.PackPiecesInOutBatchReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryBatchPiecesReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryBatchPiecesRespDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryDeliverPiecesReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryDeliverPiecesRespDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.service.OutBatchDeliverService;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.service.OutBatchDeliverValidateService;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo.DeliverPiecesRowVo;
import com.palette.busi.project.tms.common.base.BaseController;

@RestController
public class OutBatchDeliverController extends BaseController {

	@Autowired
	private OutBatchDeliverValidateService outBatchDeliverValidateService;
	@Autowired
	private OutBatchDeliverService outBatchDeliverService;

	@RequestMapping(value="/OutBatchDeliverController/queryBatchPieces")
	public QueryBatchPiecesRespDto queryBatchPieces(@RequestBody QueryBatchPiecesReqDto reqDto) {
		
		// Business
		List<DeliverPiecesRowVo> deliverPiecesVoList = outBatchDeliverService.queryBatchPieces(reqDto, getSessionLinkerVo());
		
		// Encapsulation result
		QueryBatchPiecesRespDto respDto = new QueryBatchPiecesRespDto();
		respDto.setDeliverPiecesRowVoList(deliverPiecesVoList);
		
		return respDto;
	}
	
	@RequestMapping(value="/OutBatchDeliverController/queryDeliverPieces")
	public QueryDeliverPiecesRespDto queryDeliverPieces(@RequestBody QueryDeliverPiecesReqDto reqDto) {
		
		// Validate
		ComUsablePiecesResultVo usablePieces = outBatchDeliverValidateService.validateQueryDeliverPieces(reqDto, getSessionLinkerVo());
		
		// Encapsulation result
		QueryDeliverPiecesRespDto respDto = new QueryDeliverPiecesRespDto();
		
		DeliverPiecesRowVo rowVo = new DeliverPiecesRowVo();
		rowVo.setTmPiecesId(usablePieces.getTmPiecesId());
		rowVo.setPiecesNo(usablePieces.getPiecesNo());
		rowVo.setActualWeight(usablePieces.getActualWeight());
		
		respDto.setDeliverPiecesRowVo(rowVo);
		
		return respDto;
	}

	@RequestMapping(value="/OutBatchDeliverController/packPiecesInOutBatch")
	public boolean packPiecesInOutBatch(@RequestBody PackPiecesInOutBatchReqDto reqDto) {
		
		// Business
		outBatchDeliverService.updatePiecesInOutBatch(reqDto, getSessionLinkerVo());
		
		return true;
	}
}
