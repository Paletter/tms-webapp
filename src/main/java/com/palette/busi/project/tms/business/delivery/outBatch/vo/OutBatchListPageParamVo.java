package com.palette.busi.project.tms.business.delivery.outBatch.vo;

import com.palette.busi.project.tms.core.base.BasePo;

public class OutBatchListPageParamVo extends BasePo {

	private static final long serialVersionUID = 1L;
	
	private String outBatchNo;
	private String outDate;
	private String status;
	private String startOutDate;
	private String endOutDate;
	private String warehouseCode;
	private String companyCode;

	public String getOutBatchNo() {
		return outBatchNo;
	}

	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartOutDate() {
		return startOutDate;
	}

	public void setStartOutDate(String startOutDate) {
		this.startOutDate = startOutDate;
	}

	public String getEndOutDate() {
		return endOutDate;
	}

	public void setEndOutDate(String endOutDate) {
		this.endOutDate = endOutDate;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

}
