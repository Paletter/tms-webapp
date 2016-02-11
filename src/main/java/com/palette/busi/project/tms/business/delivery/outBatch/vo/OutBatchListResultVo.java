package com.palette.busi.project.tms.business.delivery.outBatch.vo;

import java.util.Date;

public class OutBatchListResultVo {

	private Integer tmOutBatchId;
    private String outBatchNo;
    private Date outDate;
    private String status;

	public Integer getTmOutBatchId() {
		return tmOutBatchId;
	}

	public void setTmOutBatchId(Integer tmOutBatchId) {
		this.tmOutBatchId = tmOutBatchId;
	}

	public String getOutBatchNo() {
		return outBatchNo;
	}

	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
