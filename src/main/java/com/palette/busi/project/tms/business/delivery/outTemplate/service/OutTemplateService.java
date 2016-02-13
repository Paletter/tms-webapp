package com.palette.busi.project.tms.business.delivery.outTemplate.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.delivery.outTemplate.vo.DeliverPiecesImportVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface OutTemplateService {

	public List<DeliverPiecesImportVo> importDeliverPiecesExcel(MultipartFile file) throws IOException;
	public void concurrencyDeliverPieces(List<DeliverPiecesImportVo> importVoList, ServiceOptParamLinkerVo linkerVo);

}
