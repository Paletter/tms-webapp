package com.palette.busi.project.tms.business.common.service;

import com.palette.busi.project.tms.web.exception.BusinessException;

public interface CommonSeqNumberService {

	public String generatePiecesNo() throws BusinessException;
	public String generateUnitNo() throws BusinessException;
	public String generateSectorNo() throws BusinessException; 
	public String generateSyncTargetNo() throws BusinessException;
	public String generateDeliveryOrderNo() throws BusinessException;
	public String generateOutBatchNo() throws BusinessException;
	public String generateCsmNo() throws BusinessException;
}
