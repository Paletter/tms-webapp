package com.palette.busi.project.tms.business.delivery.outBatchDeliver.support;

public class PiecesOutBatchUpdateParam {

	private String outBatchNo;
	private Integer tmOutBatchId;
	private Integer tmPiecesId;

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

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}
	
}
