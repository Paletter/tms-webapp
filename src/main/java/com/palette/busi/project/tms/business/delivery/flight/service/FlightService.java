package com.palette.busi.project.tms.business.delivery.flight.service;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmSector;

public interface FlightService {

	public TmSector insertSector(AddFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo);

}
