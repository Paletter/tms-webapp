package com.palette.busi.project.tms.business.storage.checkWeight.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightValidateService;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CheckWeightUpdateVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.web.exception.BusinessException;

@Service
public class CheckWeightValidateServiceImpl extends BaseServiceImpl implements CheckWeightValidateService {

	@Override
	public void validateCheckWeight(CheckWeightUpdateVo checkWeightUpdateVo) {
		
		if(checkWeightUpdateVo.getActualWeight() == null 
		   && checkWeightUpdateVo.getVolumeWeight() == null) throw new BusinessException("操作失败。核重重量不能为空");
		if(checkWeightUpdateVo.getUserViewNo() < 0) throw new BusinessException(StringUtils.concat("操作失败。该包裹为无效包裹，状态\"", checkWeightUpdateVo.getCurrentActionDesc(), "\"，不能核重"));
		if(checkWeightUpdateVo.getUserViewNo() == 300) throw new BusinessException("操作失败。该包裹已装箱，不能核重");
		if(checkWeightUpdateVo.getUserViewNo() > 300) throw new BusinessException("操作失败。该包裹已出库，不能核重");
			
	}
	
}
