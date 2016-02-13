package com.palette.busi.project.tms.business.receive.csmStockIn.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.receive.csmStockIn.dto.CsmStockInReqDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockImportVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockInCsmUpdateVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockInPiecesUpdateVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmConsignment;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface CsmStockInService {

	public void formatCsmStockInUpdateVo(CsmStockInReqDto reqDto);
	public TmConsignment insertOrUpdateCsmInfo(CsmStockInCsmUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo);
	public TmPieces updatePiecesInfoForStockIn(CsmStockInPiecesUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo);
	public List<CsmStockImportVo> importStockCsmExcel(MultipartFile file) throws Exception;
	public void concurrencyCsmStockIn(List<CsmStockImportVo> importVoList, ServiceOptParamLinkerVo linkerVo);

}
