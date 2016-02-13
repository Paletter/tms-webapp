package com.palette.busi.project.tms.server.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;
import com.palette.busi.project.tms.server.vo.QueryPiecesReqDataVo;

@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryPiecesReqDto extends BaseReqDto {

	private String prinipleCode;
	private String auth;
	private QueryPiecesReqDataVo reqData;

	public String getPrinipleCode() {
		return prinipleCode;
	}

	public void setPrinipleCode(String prinipleCode) {
		this.prinipleCode = prinipleCode;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public QueryPiecesReqDataVo getReqData() {
		return reqData;
	}

	public void setReqData(QueryPiecesReqDataVo reqData) {
		this.reqData = reqData;
	}
	
}
