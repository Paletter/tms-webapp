package com.palette.busi.project.tms.business.storage.checkWeight.service;

import com.palette.busi.project.tms.business.storage.checkWeight.dto.CheckWeightReqDto;
import com.palette.busi.project.tms.business.storage.checkWeight.dto.QueryCheckWeightPiecesReqDto;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesInfoResultVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface CheckWeightService {
	
	public CWPiecesInfoResultVo queryCheckWeightPieces(QueryCheckWeightPiecesReqDto reqDto);
	public void formatCheckWeightUpdateVo(CheckWeightReqDto reqDto);
	public void updatePiecesInfoForCkeckWeight(CheckWeightReqDto reqDto, ServiceOptParamLinkerVo paramLinkerVo);
}
