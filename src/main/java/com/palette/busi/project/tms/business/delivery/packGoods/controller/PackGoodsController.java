package com.palette.busi.project.tms.business.delivery.packGoods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesInUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesInUnitRespDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesOutUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesOutUnitRespDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.QueryUnitCsmInfoRespDto;
import com.palette.busi.project.tms.business.delivery.packGoods.service.PackGoodsService;
import com.palette.busi.project.tms.business.delivery.packGoods.service.PackGoodsValidateService;
import com.palette.busi.project.tms.business.delivery.packGoods.vo.UnitCsmInfoResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmUnit;
import com.palette.busi.project.tms.web.exception.BusinessException;

@RestController
public class PackGoodsController extends BaseController {
	
	public static String CONTROLLER_ID = "PACK_GOODS";
	
	@Autowired
	private PackGoodsService packGoodsService;
	@Autowired
	private PackGoodsValidateService packGoodsValidateService;
	
	@RequestMapping(value="/PackGoodsController/queryUnitAndCsmInfo")
	public QueryUnitCsmInfoRespDto queryUnitAndCsmInfo(@RequestParam(value="unitLabel") String unitLabel) throws BusinessException {
		
		// Business
		List<Object> resultList = selectList(SqlMapperConstants.PACK_GOODS_CALL_GET_UNIT_AND_CSM_SP, unitLabel);
		
		List<TmUnit> tmUnitList = (List<TmUnit>) resultList.get(0);
		ThrowExp.isEmpty(tmUnitList, "操作失败。该分箱号信息不存在");
		ThrowExp.isMoreThanOne(tmUnitList, "操作失败。该麻袋号存在重复的麻袋信息，请确认");
		
		List<UnitCsmInfoResultVo> unitCsmList = (List<UnitCsmInfoResultVo>) resultList.get(1);
		
		// Encapsulation result
		QueryUnitCsmInfoRespDto respDto = new QueryUnitCsmInfoRespDto();
		respDto.setTmUnit(tmUnitList.get(0));
		respDto.setUnitCsmList(unitCsmList);
		
		return respDto;
	}
	
	@RequestMapping(value="/PackGoodsController/packCsmInUnit")
	public PackPiecesInUnitRespDto packCsmInUnit(@RequestBody PackPiecesInUnitReqDto reqDto) throws BusinessException {
		
		// Validate
		packGoodsValidateService.validatePackCsmInUnit(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Business
		TmPieces tmPieces = packGoodsService.updatePiecesInfoForPackIn(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		PackPiecesInUnitRespDto respDto = new PackPiecesInUnitRespDto();
		respDto.setPiecesNo(tmPieces.getPiecesNo());
		respDto.setActualWeight(tmPieces.getActualWeight());
		
		return respDto;
	}
	
	@RequestMapping(value="/PackGoodsController/packCsmOutUnit")
	public PackPiecesOutUnitRespDto packCsmOutUnit(@RequestBody PackPiecesOutUnitReqDto reqDto) {
		
		// Validate
		packGoodsValidateService.validatePackCsmOutUnit(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Business
		TmPieces tmPieces = packGoodsService.updatePiecesInfoForPackOut(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		PackPiecesOutUnitRespDto respDto = new PackPiecesOutUnitRespDto();
		respDto.setPiecesNo(tmPieces.getPiecesNo());
		
		return respDto;
	}
}
