package com.palette.busi.project.tms.business.delivery.flight.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightValidateService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.dao.TmSectorDao;
import com.palette.busi.project.tms.core.entity.TmSector;

@Service
public class FlightValidateServiceImpl extends BaseServiceImpl implements FlightValidateService {

	@Override
	public void validateAddUnit(String unitLabel) {
		
	}

	@Override
	public void validateAddSector(AddFlightReqDto reqDto) {
		
		TmSector tmSectorQuery = new TmSector();
		tmSectorQuery.setMawbCode(reqDto.getMawbCode());
		List<TmSector> tmSectorList = querier.selectTmSectorAllByRecord(tmSectorQuery);
		
		ThrowExp.isNotEmpty(tmSectorList, "操作失败。主单号已存在");
	}

	@Override
	public void validateUpdateSector(UpdateFlightReqDto reqDto) {
		// TODO Auto-generated method stub
		
	}

}
