package com.palette.busi.project.tms.business.delivery.flight.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightRespDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.QueryFlightListReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.QueryUnitListRespDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightRespDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightStatusReqDto;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightPrintService;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightService;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightValidateService;
import com.palette.busi.project.tms.business.delivery.flight.vo.AddUnitParamVo;
import com.palette.busi.project.tms.business.delivery.flight.vo.FlightListPageParamVo;
import com.palette.busi.project.tms.business.delivery.flight.vo.FlightListResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.PrintUtils;
import com.palette.busi.project.tms.core.entity.TmSector;
import com.palette.busi.project.tms.core.entity.TmUnit;
import com.palette.busi.project.tms.core.page.PageInfo;

@RestController
public class FlightController extends BaseController {

	public static String CONTROLLER_ID = "FLIGHT";
	
	@Autowired
	private FlightValidateService flightValidateService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private FlightPrintService flightPrintService;
	
	@RequestMapping(value="/FlightController/queryFlightList")
	public PageInfo<FlightListResultVo> queryFlightList(@RequestBody QueryFlightListReqDto reqDto) {
		
		FlightListPageParamVo paramVo = new FlightListPageParamVo();
		
		BeanUtilsExt.copyPropertiesIgnoreDefault(reqDto, paramVo);
		paramVo.setWarehouseCode(getSessionWarehouseCode());
		paramVo.setCompanyCode(getSessionCompanyCode());
		
		PageInfo<FlightListResultVo> result = selectPageInfo(SqlMapperConstants.FLIGHT_QUERY_FLIGHT, paramVo);
		
		return result;
	}

	@RequestMapping(value="/FlightController/addFlight")
	public AddFlightRespDto addFlight(@RequestBody AddFlightReqDto reqDto) {
		
		// Validate
		flightValidateService.validateAddSector(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Business
		TmSector tmSector = flightService.createSectorInfo(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		AddFlightRespDto respDto = new AddFlightRespDto();
		respDto.setSectorCode(tmSector.getSectorCode());
		
		return respDto;
	}
	
	@RequestMapping(value="/FlightController/updateFlight")
	public UpdateFlightRespDto updateFlight(@RequestBody UpdateFlightReqDto reqDto) {
		
		// Validate
		flightValidateService.validateUpdateSector(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Business
		TmSector tmSector = flightService.updateSector(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		UpdateFlightRespDto respDto = new UpdateFlightRespDto();
		respDto.setSectorCode(tmSector.getSectorCode());
		
		return respDto;
	}
	
	@RequestMapping(value="/FlightController/deleteFlight")
	public boolean deleteFlight(@RequestBody DeleteFlightReqDto reqDto) {
		
		// Validate
		flightValidateService.validateDeleteSector(reqDto);
		
		// Business
		flightService.deleteSectorInfo(reqDto);
		
		return true;
	}
	
	@RequestMapping(value="/FlightController/queryFlightUnitList")
	public QueryUnitListRespDto querySectorUnitList(@RequestParam(value="tmSectorId") Integer tmSectorId) {
		
		// Business
		TmUnit tmUnitQuery = new TmUnit();
		tmUnitQuery.setTmSectorId(tmSectorId);
		List<TmUnit> tmUnitList = querier.selectTmUnitAllByRecord(tmUnitQuery);
		
		// Encapsulation result
		QueryUnitListRespDto respDto = new QueryUnitListRespDto();
		respDto.setTmUnitList(tmUnitList);
		
		return respDto;
	}
	
	@RequestMapping(value="/FlightController/addUnit")
	public TmUnit addUnit(@RequestBody AddUnitReqDto reqDto) {
		
		// Validate
		flightValidateService.validateAddUnit(reqDto);
		
		// Business
		AddUnitParamVo paramVo = new AddUnitParamVo();
		BeanUtilsExt.copyProperties(reqDto, paramVo);
		
		TmUnit tmUnit = flightService.addUnitInfo(paramVo, getSessionServiceOptParamLinkerVo());
		
		return tmUnit;
	}

	@RequestMapping(value="/FlightController/autoAddUnit")
	public TmUnit autoAddUnit(@RequestBody AddUnitReqDto reqDto) {
		
		// Business
		String unitLabel = flightService.evaluateUnitLabel(reqDto);
		
		AddUnitParamVo paramVo = new AddUnitParamVo();
		BeanUtilsExt.copyProperties(reqDto, paramVo);
		paramVo.setUnitLabel(unitLabel);
		
		TmUnit tmUnit = flightService.addUnitInfo(paramVo, getSessionServiceOptParamLinkerVo());
		
		return tmUnit;
	}
	
	@RequestMapping(value="/FlightController/deleteUnit")
	public boolean deleteUnit(@RequestBody DeleteUnitReqDto reqDto) {
		
		// Business
		flightService.deleteUnit(reqDto);
		
		return true;
	}

	@RequestMapping(value="/FlightController/printUnitLabelList")
	public void printUnitLabelList(HttpServletResponse response) throws Exception {
		
		// Business
		List<Integer> tmUnitIdList = JSONObject.parseArray(request.getParameter("unitIdList"), Integer.class);
		
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("unitIdList", tmUnitIdList);
		List<TmUnit> tmUnitList = selectList(SqlMapperConstants.FLIGHT_QUERY_PRINT_UNIT_LIST, queryParam);
		
		XSSFWorkbook workbook = flightPrintService.createUnitLabel(getServletRealPath(), tmUnitList);
		
		PrintUtils.excelResponseOutput(response, workbook, "UnitLbale.xlsx");
	}

	@RequestMapping(value="/FlightController/shippingFlight")
	public boolean shippingFlight(@RequestBody UpdateFlightStatusReqDto reqDto) {
		
		// Business
		flightService.updateSectorStatusForShipping(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/FlightController/updatePiecesToShippingOfFlight")
	public boolean updatePiecesToShippingOfFlight(@RequestBody UpdateFlightStatusReqDto reqDto) {
		
		// Business
		flightService.updatePiecesStatusForShipping(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}

	@RequestMapping(value="/FlightController/upperFlight")
	public boolean upperFlight(@RequestBody UpdateFlightStatusReqDto reqDto) {
		
		// Business
		flightService.updateSectorStatusForUpper(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}

	@RequestMapping(value="/FlightController/updatePiecesToUpperOfFlight")
	public boolean updatePiecesToUpperOfFlight(@RequestBody UpdateFlightStatusReqDto reqDto) {
		
		// Business
		flightService.updatePiecesStatusForUpper(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/FlightController/arriveFlight")
	public boolean arriveFlight(@RequestBody UpdateFlightStatusReqDto reqDto) {
		
		// Business
		flightService.updateSectorStatusForArrive(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
	
	@RequestMapping(value="/FlightController/updatePiecesToArriveOfFlight")
	public boolean updatePiecesToArriveOfFlight(@RequestBody UpdateFlightStatusReqDto reqDto) {
		
		// Business
		flightService.updatePiecesStatusForArrive(reqDto, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
}
