package com.palette.busi.project.tms.business.delivery.flight.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightValidateService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmSector;
import com.palette.busi.project.tms.core.entity.TmUnit;

@Service
public class FlightValidateServiceImpl extends BaseServiceImpl implements FlightValidateService {

	@Override
	public void validateAddSector(AddFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmSector tmSectorQuery = new TmSector();
		tmSectorQuery.setMawbCode(reqDto.getMawbCode());
		tmSectorQuery.setCompanyCode(linkerVo.getCompanyCode());
		List<TmSector> tmSectorList = querier.selectTmSectorAllByRecord(tmSectorQuery);
		ThrowExp.isNotEmpty(tmSectorList, "操作失败。主单号已存在");
	}
	
	@Override
	public void validateUpdateSector(UpdateFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		ThrowExp.isNull(reqDto.getTmSectorId(), "操作失败。航班信息不存在");
		
		TmSector tmSector = querier.selectTmSectorById(reqDto.getTmSectorId());
		ThrowExp.isNull(tmSector, "操作失败。航班信息不存在");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tmSectorId", reqDto.getTmSectorId());
		params.put("mawbCode", reqDto.getMawbCode());
		Integer count = selectOne(SqlMapperConstants.FLIGHT_QUERY_VALIDATE_FLIGHT, params);
		ThrowExp.isBiggerThanZero(count, "操作失败。主单号已存在");
	}
	
	@Override
	public void validateDeleteSector(DeleteFlightReqDto reqDto) {
		
		ThrowExp.isNull(reqDto.getTmSectorId(), "操作失败。航班信息不存在");
		
		TmSector tmSector = querier.selectTmSectorById(reqDto.getTmSectorId());
		ThrowExp.isNull(tmSector, "操作失败。航班信息不存在");
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmSectorId(reqDto.getTmSectorId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		ThrowExp.isNotEmpty(tmPiecesList, "操作失败。已有包裹绑定在该航班中，无法删除");
	}

	@Override
	public void validateAddUnit(AddUnitReqDto reqDto) {
		
		ThrowExp.isNullOrEmpty(reqDto.getUnitLabel(), "操作失败。标签号不能为空");
		ThrowExp.isTrue(reqDto.getUnitLabel().length() > 20, "操作失败。标签号不能超过20位");
		
		TmUnit tmUnitQuery = new TmUnit();
		tmUnitQuery.setUnitLabel(reqDto.getUnitLabel());
		TmUnit tmUnit = querier.selectTmUnitOneByRecord(tmUnitQuery);
		ThrowExp.isNotNull(tmUnit, "操作失败。标签号" + reqDto.getUnitLabel() + "已存在");
	}
	
	@Override
	public void validateDeleteUnit(DeleteUnitReqDto reqDto) {
		
		ThrowExp.isNull(reqDto.getTmUnitId(), "操作失败。分箱ID为空");
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmUnitId(reqDto.getTmUnitId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		ThrowExp.isNotEmpty(tmPiecesList, "操作失败。有包裹绑定在该分箱中，该分箱不可删除");
	}
}
