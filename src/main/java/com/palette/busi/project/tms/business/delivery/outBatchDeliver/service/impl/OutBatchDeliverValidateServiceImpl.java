package com.palette.busi.project.tms.business.delivery.outBatchDeliver.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesQueryVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryDeliverPiecesReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.service.OutBatchDeliverValidateService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

@Service
public class OutBatchDeliverValidateServiceImpl extends BaseServiceImpl implements OutBatchDeliverValidateService {

	@Override
	public ComUsablePiecesResultVo validateQueryDeliverPieces(QueryDeliverPiecesReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		ComUsablePiecesQueryVo usablePiecesQueryVo = new ComUsablePiecesQueryVo();
		usablePiecesQueryVo.setPiecesNo(reqDto.getQueryNo());
		ComUsablePiecesResultVo usablePieces = servicePvd.commonPiecesService.queryUsablePieces(usablePiecesQueryVo, linkerVo);
		
		ThrowExp.isNull(usablePieces, "操作失败。包裹不存在");
		ThrowExp.isTrue(usablePieces.getPiecesUserViewNo() < 200, "操作失败。包裹未入库");
		ThrowExp.isTrue(usablePieces.getPiecesUserViewNo() > 200, "操作失败。包裹已装箱或出库");
		
		return usablePieces;
	}
}
