package com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto;

import java.util.List;

import com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo.DeliverPiecesRowVo;
import com.palette.busi.project.tms.common.base.BaseReqDto;

public class PackPiecesInOutBatchReqDto extends BaseReqDto {

	private String outBatchNo;
	private Integer tmOutBatchId;
	private List<DeliverPiecesRowVo> deliverPiecesVoList;

	public String getOutBatchNo() {
		return outBatchNo;
	}

	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}

	public Integer getTmOutBatchId() {
		return tmOutBatchId;
	}

	public void setTmOutBatchId(Integer tmOutBatchId) {
		this.tmOutBatchId = tmOutBatchId;
	}

	public List<DeliverPiecesRowVo> getDeliverPiecesVoList() {
		return deliverPiecesVoList;
	}

	public void setDeliverPiecesVoList(List<DeliverPiecesRowVo> deliverPiecesVoList) {
		this.deliverPiecesVoList = deliverPiecesVoList;
	}
	
}
