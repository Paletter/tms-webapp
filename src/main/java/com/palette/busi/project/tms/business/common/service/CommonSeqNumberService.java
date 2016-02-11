package com.palette.busi.project.tms.business.common.service;

import com.palette.busi.project.tms.web.exception.BusinessException;

public interface CommonSeqNumberService {

	/**
	 * 规则生成PiecesNo
	 * @return
	 * @throws BusinessException
	 */
	public String generatePiecesNo() throws BusinessException;
	
	/**
	 * 规则生成UnitNo
	 * @return
	 * @throws BusinessException
	 */
	public String generateUnitNo() throws BusinessException;
	
	/**
	 * 规则生成SectorNo
	 * @return
	 * @throws BusinessException
	 */
	public String generateSectorNo() throws BusinessException; 
	
	/**
	 * 规则生成同步唯一编号
	 * @return
	 */
	public String generateSyncTargetNo() throws BusinessException;
	
	/**
	 * 规则出库单号
	 * @return
	 */
	public String generateDeliveryOrderNo() throws BusinessException;
	
	/**
	 * 规则出库批次号
	 * @return
	 */
	public String generateOutBatchNo() throws BusinessException;
}
