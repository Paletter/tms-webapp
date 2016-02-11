package com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto;

import java.util.List;

import com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo.DeliverPiecesRowVo;
import com.palette.busi.project.tms.common.base.BaseRespDto;

public class QueryBatchPiecesRespDto extends BaseRespDto {

	private List<DeliverPiecesRowVo> deliverPiecesRowVoList;

	public List<DeliverPiecesRowVo> getDeliverPiecesRowVoList() {
		return deliverPiecesRowVoList;
	}

	public void setDeliverPiecesRowVoList(List<DeliverPiecesRowVo> deliverPiecesVoList) {
		this.deliverPiecesRowVoList = deliverPiecesVoList;
	}

}
