package com.palette.busi.project.tms.business.delivery.outBatch.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DeliverOutBatchReqDto extends BaseReqDto {

	private Integer tmOutBatchId;

	public Integer getTmOutBatchId() {
		return tmOutBatchId;
	}

	public void setTmOutBatchId(Integer tmOutBatchId) {
		this.tmOutBatchId = tmOutBatchId;
	}
	
}
