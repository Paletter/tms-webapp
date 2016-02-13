package com.palette.busi.project.tms.business.delivery.flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComSectorStatusUpdateVo;
import com.palette.busi.project.tms.business.delivery.flight.controller.FlightController;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.AddUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.DeleteUnitReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightReqDto;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightStatusReqDto;
import com.palette.busi.project.tms.business.delivery.flight.service.FlightService;
import com.palette.busi.project.tms.business.delivery.flight.vo.AddUnitParamVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.dao.TmSectorDao;
import com.palette.busi.project.tms.core.dao.TmUnitDao;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmSector;
import com.palette.busi.project.tms.core.entity.TmUnit;

@Service
@Transactional
public class FlightServiceImpl extends BaseServiceImpl implements FlightService {

	@Autowired
	private TmSectorDao tmSectorDao;
	@Autowired
	private TmUnitDao tmUnitDao;
	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public TmSector createSectorInfo(AddFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Insert sector
		TmSector tmSector = new TmSector();
		BeanUtilsExt.copyPropertiesIgnoreDefault(reqDto, tmSector);
		tmSector.setSectorCode(servicePvd.commonSeqNumberService.generateSectorNo());
		tmSector.setWarehouseCode(linkerVo.getWarehouseCode());
		tmSector.setCompanyCode(linkerVo.getCompanyCode());
		tmSector.setCreateTime(DateUtils.getCurrentGMTDate());
		
		tmSectorDao.insertTmSector(tmSector, linkerVo.getUserName(), FlightController.CONTROLLER_ID);
		
		// Insert sector current and history
		ComSectorStatusUpdateVo updateVo = servicePvd.commonFlightService.createSectorStatusUpdateVo(tmSector.getTmSectorId()
																									,tmSector.getSectorCode()
																									,CodeConstants.SECTOR_ACTION.CR
																									,"航班创建"
																									,FlightController.CONTROLLER_ID
																									,linkerVo);
		servicePvd.commonFlightService.updateSectorStatus(updateVo, linkerVo);
		
		return tmSector;
		
	}
	
	@Override
	public TmSector updateSector(UpdateFlightReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update sector
		TmSector tmSector = querier.selectTmSectorById(reqDto.getTmSectorId());
		BeanUtilsExt.copyPropertiesIgnoreDefault(reqDto, tmSector);
		tmSectorDao.updateTmSector(tmSector, linkerVo.getUserName(), FlightController.CONTROLLER_ID);
		return tmSector;
	}
	
	@Override
	public void deleteSectorInfo(DeleteFlightReqDto reqDto) {
		
		// Delete sector
		tmSectorDao.deleteTmSector(reqDto.getTmSectorId());
		baseDao.delete(SqlMapperConstants.FLIGHT_DELETE_TM_UNIT_BY_FLIGHT, reqDto.getTmSectorId());
		baseDao.delete(SqlMapperConstants.FLIGHT_DELETE_SECTOR_CURRENT, reqDto.getTmSectorId());
		baseDao.delete(SqlMapperConstants.FLIGHT_DELETE_SECTOR_HISTORY, reqDto.getTmSectorId());
	}
	
	@Override
	public TmUnit addUnitInfo(AddUnitParamVo paramVo, ServiceOptParamLinkerVo linkerVo) {
		
		TmUnit tmUnit = new TmUnit();
		tmUnit.setTmSectorId(paramVo.getTmSectorId());
		tmUnit.setUnitLabel(paramVo.getUnitLabel());
		tmUnit.setUnitNo(servicePvd.commonSeqNumberService.generateUnitNo());
		tmUnit.setMawbCode(paramVo.getMawbCode());
		tmUnit.setSectorCode(paramVo.getSectorCode());
		tmUnit.setTmSectorId(paramVo.getTmSectorId());
		tmUnitDao.insertTmUnit(tmUnit, linkerVo.getUserName(), FlightController.CONTROLLER_ID);
		
		return tmUnit;
	}
	
	@Override
	public String evaluateUnitLabel(AddUnitReqDto reqDto) {
		
		TmUnit tmUnitQuery = new TmUnit();
		tmUnitQuery.setTmSectorId(reqDto.getTmSectorId());
		List<TmUnit> tmUnitList = querier.selectTmUnitAllByRecord(tmUnitQuery);
		
		Integer newUnitLabelNo = 0;
		for(TmUnit tmUnit : tmUnitList) {
			String unitLabel = tmUnit.getUnitLabel();
			Integer unitLabelNo = Integer.valueOf(unitLabel.substring(unitLabel.lastIndexOf("-") + 1));
			if(unitLabelNo > newUnitLabelNo) newUnitLabelNo = unitLabelNo;
		}
		newUnitLabelNo ++;
		
		return reqDto.getMawbCode() + "-" + newUnitLabelNo.toString();
	}
	
	@Override
	public void deleteUnit(DeleteUnitReqDto reqDto) {
		
		tmUnitDao.deleteTmUnit(reqDto.getTmUnitId());
	}
	
	@Override
	public void updateSectorStatusForShipping(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update sector current and history
		ComSectorStatusUpdateVo updateVo = servicePvd.commonFlightService.createSectorStatusUpdateVo(reqDto.getTmSectorId()
																									,reqDto.getSectorCode()
																									,CodeConstants.SECTOR_ACTION.OS
																									,"包裹出仓，转运机场"
																									,FlightController.CONTROLLER_ID
																									,linkerVo);
		servicePvd.commonFlightService.updateSectorStatus(updateVo, linkerVo);
	}

	@Override
	public void updatePiecesStatusForShipping(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmSectorId(reqDto.getTmSectorId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		for(TmPieces tmPieces : tmPiecesList) {
			
			// Update pieces
			tmPieces.setDeliveryDate(DateUtils.getCurrentGMTDate());
			tmPiecesDao.updateTmPieces(tmPieces, linkerVo.getUserName(), FlightController.CONTROLLER_ID);
			
			// Update pieces current and history
			ComPiecesStatusUpdateVo updateVo = servicePvd.commonPiecesService.createPiecesStatusUpdateVo(tmPieces.getTmPiecesId()
																										,tmPieces.getPiecesNo()
																										,CodeConstants.PIECES_ACTION.CO
																										,"包裹出仓"
																										,FlightController.CONTROLLER_ID
																										,linkerVo);
			servicePvd.commonPiecesService.updatePiecesStatus(updateVo);
		}
	}
	
	@Override
	public void updateSectorStatusForUpper(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update sector current and history
		ComSectorStatusUpdateVo updateVo = servicePvd.commonFlightService.createSectorStatusUpdateVo(reqDto.getTmSectorId()
																									,reqDto.getSectorCode()
																									,CodeConstants.SECTOR_ACTION.UL
																									,"航班起飞"
																									,FlightController.CONTROLLER_ID
																									,linkerVo);
		servicePvd.commonFlightService.updateSectorStatus(updateVo, linkerVo);
	}
	
	@Override
	public void updatePiecesStatusForUpper(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update pieces current and history
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmSectorId(reqDto.getTmSectorId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		
		for(TmPieces tmPieces : tmPiecesList) {
			
			ComPiecesStatusUpdateVo updateVo = servicePvd.commonPiecesService.createPiecesStatusUpdateVo(tmPieces.getTmPiecesId()
																										,tmPieces.getPiecesNo()
																										,CodeConstants.PIECES_ACTION.UL
																										,"航班起飞"
																										,FlightController.CONTROLLER_ID
																										,linkerVo);
			servicePvd.commonPiecesService.updatePiecesStatus(updateVo);
		}
	}
	
	@Override
	public void updateSectorStatusForArrive(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update sector current and history
		ComSectorStatusUpdateVo updateVo = servicePvd.commonFlightService.createSectorStatusUpdateVo(reqDto.getTmSectorId()
													                                                ,reqDto.getSectorCode()
													                                                ,CodeConstants.SECTOR_ACTION.DL
													                                                ,"航班到达"
													                                                ,FlightController.CONTROLLER_ID
													                                                ,linkerVo);
		servicePvd.commonFlightService.updateSectorStatus(updateVo, linkerVo);
	}
	
	@Override
	public void updatePiecesStatusForArrive(UpdateFlightStatusReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update pieces current and history
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmSectorId(reqDto.getTmSectorId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		
		for(TmPieces tmPieces : tmPiecesList) {
			
			ComPiecesStatusUpdateVo updateVo = servicePvd.commonPiecesService.createPiecesStatusUpdateVo(tmPieces.getTmPiecesId()
					                                                                                    ,tmPieces.getPiecesNo()
					                                                                                    ,CodeConstants.PIECES_ACTION.DL
					                                                                                    ,"航班到达"
					                                                                                    ,FlightController.CONTROLLER_ID
					                                                                                    ,linkerVo);
			servicePvd.commonPiecesService.updatePiecesStatus(updateVo);
		}
	}
}
