package com.palette.busi.project.tms.business.delivery.outBatchDeliver.service;

import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryDeliverPiecesReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface OutBatchDeliverValidateService {

	public ComUsablePiecesResultVo validateQueryDeliverPieces(QueryDeliverPiecesReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
