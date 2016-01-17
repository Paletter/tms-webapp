package com.palette.busi.project.tms.business.storage.checkWeight.service;

import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesInfoResultVo;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesQueryParamVo;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CheckWeightUpdateVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface CheckWeightService {
	
	public CWPiecesInfoResultVo queryCheckWeightPieces(CWPiecesQueryParamVo checkWeightPiecesQueryParamVo);
	public void formatCheckWeightUpdateVo(CheckWeightUpdateVo checkWeightUpdateVo);
	public void updatePiecesInfoForCkeckWeight(CheckWeightUpdateVo checkWeightUpdateVo, ServiceOptParamLinkerVo paramLinkerVo);
}
