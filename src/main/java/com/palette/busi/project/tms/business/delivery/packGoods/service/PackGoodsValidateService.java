package com.palette.busi.project.tms.business.delivery.packGoods.service;

import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesInUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesOutUnitReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface PackGoodsValidateService {

	public void validatePackCsmInUnit(PackPiecesInUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void validatePackCsmOutUnit(PackPiecesOutUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
