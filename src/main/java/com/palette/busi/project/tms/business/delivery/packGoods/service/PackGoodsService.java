package com.palette.busi.project.tms.business.delivery.packGoods.service;

import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesInUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesOutUnitReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface PackGoodsService {

	public TmPieces updatePiecesInfoForPackIn(PackPiecesInUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public TmPieces updatePiecesInfoForPackOut(PackPiecesOutUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
