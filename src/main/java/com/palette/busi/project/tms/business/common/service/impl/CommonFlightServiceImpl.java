package com.palette.busi.project.tms.business.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.service.CommonFlightService;
import com.palette.busi.project.tms.business.common.vo.ComSectorStatusUpdateVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPiecesAction;
import com.palette.busi.project.tms.core.entity.TmPiecesCurrent;
import com.palette.busi.project.tms.core.entity.TmPiecesHistory;
import com.palette.busi.project.tms.core.entity.TmSectorAction;
import com.palette.busi.project.tms.core.entity.TmSectorCurrent;

@Service
@Transactional
public class CommonFlightServiceImpl extends BaseServiceImpl implements CommonFlightService {

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
		TmSectorCurrent tmSectorCurrent
		
		// Insert sector history
	}
}
