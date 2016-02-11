package com.palette.busi.project.tms.business.delivery.outBatchDeliver.service;

import java.util.List;

import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.PackPiecesInOutBatchReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryBatchPiecesReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo.DeliverPiecesRowVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface OutBatchDeliverService {

	public List<DeliverPiecesRowVo> queryBatchPieces(QueryBatchPiecesReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updatePiecesInOutBatch(PackPiecesInOutBatchReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
