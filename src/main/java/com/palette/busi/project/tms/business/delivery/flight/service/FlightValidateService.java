package com.palette.busi.project.tms.business.delivery.flight.service;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface FlightValidateService {

	public void validateAddSector(AddFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void validateUpdateSector(UpdateFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
	public void validateDeleteSector(DeleteFlightReqDto reqDto);
	public void validateAddUnit(AddUnitReqDto reqDto);
	public void validateDeleteUnit(DeleteUnitReqDto reqDto);
}
