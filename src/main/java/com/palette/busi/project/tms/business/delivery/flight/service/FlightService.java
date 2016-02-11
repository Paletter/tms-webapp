package com.palette.busi.project.tms.business.delivery.flight.service;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightStatusReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.vo.AddUnitParamVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmSector;
import com.palette.busi.project.tms.core.entity.TmUnit;

public interface FlightService {

	public TmSector createSectorInfo(AddFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public TmSector updateSector(UpdateFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void deleteSectorInfo(DeleteFlightReqDto reqDto);
	public TmUnit addUnitInfo(AddUnitParamVo paramVo, ServiceOptParamLinkerVo linkerVo);
	public String evaluateUnitLabel(AddUnitReqDto reqDto);
	public void deleteUnit(DeleteUnitReqDto reqDto);
	public void updateSectorStatusForShipping(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updatePiecesStatusForShipping(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updateSectorStatusForUpper(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updatePiecesStatusForUpper(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updateSectorStatusForArrive(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void updatePiecesStatusForArrive(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
}
