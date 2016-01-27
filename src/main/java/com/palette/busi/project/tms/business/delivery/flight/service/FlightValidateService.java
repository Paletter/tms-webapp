package com.palette.busi.project.tms.business.delivery.flight.service;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;

public interface FlightValidateService {

	public void validateAddUnit(String unitLabel);
	public void validateAddSector(AddFlightReqDto reqDto);
	public void validateUpdateSector(UpdateFlightReqDto reqDto);
}
