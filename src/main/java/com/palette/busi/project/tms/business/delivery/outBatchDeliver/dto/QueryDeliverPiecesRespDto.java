package com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto;

import com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo.DeliverPiecesRowVo;
import com.palette.busi.project.tms.common.base.BaseRespDto;

public class QueryDeliverPiecesRespDto extends BaseRespDto {

	private DeliverPiecesRowVo deliverPiecesRowVo;

	public DeliverPiecesRowVo getDeliverPiecesRowVo() {
		return deliverPiecesRowVo;
	}

	public void setDeliverPiecesRowVo(DeliverPiecesRowVo deliverPiecesRowVo) {
		this.deliverPiecesRowVo = deliverPiecesRowVo;
	}

}
