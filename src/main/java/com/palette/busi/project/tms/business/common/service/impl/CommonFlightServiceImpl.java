package com.palette.busi.project.tms.business.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.service.CommonFlightService;
import com.palette.busi.project.tms.business.common.vo.ComSectorStatusUpdateVo;
import com.palette.busi.project.tms.business.delivery.flight.controller.FlightController;
import com.palette.busi.project.tms.business.delivery.flight.dto.UpdateFlightStatusReqDto;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmSectorCurrentDao;
import com.palette.busi.project.tms.core.dao.TmSectorHistoryDao;
import com.palette.busi.project.tms.core.entity.TmSectorAction;
import com.palette.busi.project.tms.core.entity.TmSectorCurrent;
import com.palette.busi.project.tms.core.entity.TmSectorHistory;

@Service
@Transactional
public class CommonFlightServiceImpl extends BaseServiceImpl implements CommonFlightService {

	@Autowired
	private TmSectorCurrentDao tmSectorCurrentDao;
	@Autowired
	private TmSectorHistoryDao tmSectorHistoryDao;
	
	@Override
	public ComSectorStatusUpdateVo createSectorStatusUpdateVo(Integer tmSectorId, String sectorCode, String actionCode, String memo, String controllerId, ServiceOptParamLinkerVo linkerVo) {
		
		ComSectorStatusUpdateVo updateVo = new ComSectorStatusUpdateVo(linkerVo.getUserName(), controllerId);
		updateVo.setTmSectorId(tmSectorId);
		updateVo.setSectorCode(sectorCode);
		updateVo.setActionCode(actionCode);
		updateVo.setMemo(memo);
		updateVo.setActionUserName(linkerVo.getUserName());
		updateVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		return updateVo;
	}
	
	@Override
	public void updateSectorStatus(ComSectorStatusUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo) {
		
		// Query sector action
		TmSectorAction tmSectorActionQuery = new TmSectorAction();
		tmSectorActionQuery.setActionCode(updateVo.getActionCode());
		tmSectorActionQuery.setIsActivity(1);
		TmSectorAction tmSectorAction = querier.selectTmSectorActionOneByRecord(tmSectorActionQuery);
		ThrowExp.isNull(tmSectorAction, "操作失败。更新航班状态，查询不到TmSectorAction数据");
		
		// Insert or Update sector current
		TmSectorCurrent tmSectorCurrentQuery = new TmSectorCurrent();
		tmSectorCurrentQuery.setTmSectorId(updateVo.getTmSectorId());
		TmSectorCurrent tmSectorCurrent = querier.selectTmSectorCurrentOneByRecord(tmSectorCurrentQuery);
		if(tmSectorCurrent == null) {
			tmSectorCurrent = new TmSectorCurrent();
			
			tmSectorCurrent.setTmSectorId(updateVo.getTmSectorId());
			tmSectorCurrent.setSectorCode(updateVo.getSectorCode());
		}
		
		tmSectorCurrent.setActionCode(updateVo.getActionCode());
		tmSectorCurrent.setMemo(updateVo.getMemo());
		tmSectorCurrent.setActionUserName(updateVo.getActionUserName());
		tmSectorCurrent.setActionDateTime(updateVo.getActionDateTime());
		
		tmSectorCurrentDao.saveTmSectorCurrent(tmSectorCurrent, updateVo.getUserName(), updateVo.getControllerId());
		
		// Insert sector history
		TmSectorHistory tmSectorHistory = new TmSectorHistory();
		tmSectorHistory.setTmSectorId(updateVo.getTmSectorId());
		tmSectorHistory.setSectorCode(updateVo.getSectorCode());
		tmSectorHistory.setActionCode(updateVo.getActionCode());
		tmSectorHistory.setMemo(updateVo.getMemo());
		tmSectorHistory.setActionUserName(updateVo.getActionUserName());
		tmSectorHistory.setActionDateTime(updateVo.getActionDateTime());
		
		tmSectorHistoryDao.insertTmSectorHistory(tmSectorHistory, updateVo.getUserName(), updateVo.getControllerId());
	}
}
