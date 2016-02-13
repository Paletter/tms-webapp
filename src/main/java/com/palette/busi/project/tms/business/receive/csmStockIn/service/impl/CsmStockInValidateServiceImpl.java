package com.palette.busi.project.tms.business.receive.csmStockIn.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.receive.csmStockIn.dto.CsmStockInReqDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.service.CsmStockInValidateService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.ThrowExp;

@Service
public class CsmStockInValidateServiceImpl extends BaseServiceImpl implements CsmStockInValidateService {

	@Override
	public void validateCsmStockIn(CsmStockInReqDto reqDto) {
		
		ThrowExp.isNull(reqDto.getActualWeight(), "操作失败。必须输入包裹实重");
	}
}
