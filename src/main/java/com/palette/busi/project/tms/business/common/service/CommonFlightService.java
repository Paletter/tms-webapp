package com.palette.busi.project.tms.business.common.service;

import com.palette.busi.project.tms.business.common.vo.ComSectorStatusUpdateVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface CommonFlightService {

	/**
	 * @param tmSectorId
	 * @param sectorCode
	 * @param actionCode
	 * @param memo
	 * @param controllerId
	 * @param linkerVo
	 * @return
	 */
	public ComSectorStatusUpdateVo createSectorStatusUpdateVo(Integer tmSectorId,
			String sectorCode, String actionCode, String memo,
			String controllerId, ServiceOptParamLinkerVo linkerVo);
	
	public void updateSectorStatus(ComSectorStatusUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo);

}
