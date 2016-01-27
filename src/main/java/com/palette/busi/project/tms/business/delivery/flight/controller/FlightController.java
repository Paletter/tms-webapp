package com.palette.busi.project.tms.business.delivery.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.QueryFlightListReqDto;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightService;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightValidateService;
import com.palette.busi.project.tms.business.delivery.flight.vo.FlightListPageParamVo;
import com.palette.busi.project.tms.business.delivery.flight.vo.FlightListResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.core.entity.TmSector;
import com.palette.busi.project.tms.core.page.PageInfo;

@RestController
public class FlightController extends BaseController {

	public static String CONTROLLER_ID = "FLIGHT";
	
	@Autowired
	private FlightValidateService flightValidateService;
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/FlightController/queryFlightList")
	public PageInfo<FlightListResultVo> queryFlightList(@RequestBody QueryFlightListReqDto reqDto) {
		
		FlightListPageParamVo paramVo = new FlightListPageParamVo();
		
		BeanUtilsExt.copyPropertiesIgnoreDefault(reqDto, paramVo);
		paramVo.setWarehouseCode(getSessionWarehouseCode());
		
		PageInfo<FlightListResultVo> result = baseDao.selectPageInfo(SqlMapperConstants.FLIGHT_QUERY_FLIGHT, paramVo);
		
		return result;
	}

	@RequestMapping(value="/FlightController/addFlight")
	public TmSector addFlight(@RequestBody AddFlightReqDto reqDto) {
		
		// Validate
		flightValidateService.validateAddSector(reqDto);
		
		// Business
		TmSector tmSector = flightService.insertSector(reqDto, getSessionServiceOptParamLinkerVo());
		
		// TODO Sector current and history
		
		return tmSector;
	}
}
