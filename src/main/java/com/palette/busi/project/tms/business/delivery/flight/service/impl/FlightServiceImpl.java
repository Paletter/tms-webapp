package com.palette.busi.project.tms.business.delivery.flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.delivery.flight.controller.FlightController;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmSectorDao;
import com.palette.busi.project.tms.core.entity.TmSector;

@Service
@Transactional
public class FlightServiceImpl extends BaseServiceImpl implements FlightService {

	@Autowired
	private TmSectorDao tmSectorDao;
	
	@Override
	public TmSector insertSector(AddFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmSector tmSector = new TmSector();
		BeanUtilsExt.copyPropertiesIgnoreDefault(reqDto, tmSector);
		tmSector.setWarehouseCode(linkerVo.getWarehouseCode());
		tmSector.setCompanyCode(linkerVo.getCompanyCode());
		tmSector.setCreateTime(DateUtils.getCurrentGMTDate());
		
		tmSectorDao.insertTmSector(tmSector, linkerVo.getUserName(), FlightController.CONTROLLER_ID);
		
		return tmSector;
	}
}
