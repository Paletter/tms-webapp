package com.palette.busi.project.tms.business.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.service.CommonSeqNumberService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.web.exception.BusinessException;

@Service
@Transactional
public class CommonSeqNumberServiceImpl extends BaseServiceImpl implements CommonSeqNumberService {

	@Override
	public String generatePiecesNo() throws BusinessException {
		return (String) baseDao.getSqlSessionTemplate().selectOne(SqlMapperConstants.SEQ_NUMBER_GET_SEQ_NEXTVAL, CodeConstants.SEQUENCE_NUMBER_TYPE.PIECES_NO);
	}

	@Override
	public String generateUnitNo() throws BusinessException {
		return (String) baseDao.getSqlSessionTemplate().selectOne(SqlMapperConstants.SEQ_NUMBER_GET_SEQ_NEXTVAL, CodeConstants.SEQUENCE_NUMBER_TYPE.UNIT_NO);
	}

	@Override
	public String generateSectorNo() throws BusinessException {
		return (String) baseDao.getSqlSessionTemplate().selectOne(SqlMapperConstants.SEQ_NUMBER_GET_SEQ_NEXTVAL, CodeConstants.SEQUENCE_NUMBER_TYPE.SECTOR_NO);
	}
	
	@Override
	public String generateSyncTargetNo() throws BusinessException {
		String targetNo = (String) baseDao.getSqlSessionTemplate().selectOne(SqlMapperConstants.SEQ_NUMBER_GET_SEQ_NEXTVAL, CodeConstants.SEQUENCE_NUMBER_TYPE.SYNC_TARGET_NO);
		baseDao.getSqlSessionTemplate().clearCache();
		return targetNo;
	}

	@Override
	public String generateDeliveryOrderNo() throws BusinessException {
		return baseDao.getSqlSessionTemplate().selectOne(SqlMapperConstants.SEQ_NUMBER_GET_SEQ_NEXTVAL, CodeConstants.SEQUENCE_NUMBER_TYPE.DELIVERY_ORDER_NO);
	}
}
