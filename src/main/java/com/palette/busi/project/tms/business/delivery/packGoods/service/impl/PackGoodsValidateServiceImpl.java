package com.palette.busi.project.tms.business.delivery.packGoods.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesQueryVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesInUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesOutUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.service.PackGoodsValidateService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

@Service
public class PackGoodsValidateServiceImpl extends BaseServiceImpl implements PackGoodsValidateService {

	@Override
	public void validatePackCsmInUnit(PackPiecesInUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		ComUsablePiecesQueryVo usablePiecesQueryVo = new ComUsablePiecesQueryVo();
		usablePiecesQueryVo.setPiecesNo(reqDto.getPackNo());
		ComUsablePiecesResultVo usablePiecesResultVo = servicePvd.commonPiecesService.queryUsablePieces(usablePiecesQueryVo, linkerVo);
		
		ThrowExp.isNull(usablePiecesResultVo, "操作失败。包裹不存在，禁止装包");
		ThrowExp.isTrue(usablePiecesResultVo.getPiecesUserViewNo() < 200, "操作失败。包裹未入库，禁止装包");
		ThrowExp.isTrue(usablePiecesResultVo.getPiecesUserViewNo() > 200, "操作失败。包裹已装箱或出库，禁止装包");
		ThrowExp.isNotNull(usablePiecesResultVo.getTmUnitId(), "操作失败。包裹已装入其他分箱，禁止装包。");
	}
	
	@Override
	public void validatePackCsmOutUnit(PackPiecesOutUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		ComUsablePiecesQueryVo usablePiecesQueryVo = new ComUsablePiecesQueryVo();
		usablePiecesQueryVo.setPiecesNo(reqDto.getPackNo());
		ComUsablePiecesResultVo usablePiecesResultVo = servicePvd.commonPiecesService.queryUsablePieces(usablePiecesQueryVo, linkerVo);
		ThrowExp.isNull(usablePiecesResultVo, "操作失败。包裹不存在");
	}
}
