package com.palette.busi.project.tms.business.delivery.outBatch.service;

import com.palette.busi.project.tms.business.delivery.outBatch.dto.DeliverOutBatchReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmOutBatch;

public interface OutBatchService {

	public TmOutBatch createOutBatch(ServiceOptParamLinkerVo linkerVo);
	public void deliverOutBatch(DeliverOutBatchReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void deliverPieces(DeliverOutBatchReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
}
