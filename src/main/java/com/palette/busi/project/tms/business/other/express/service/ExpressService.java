package com.palette.busi.project.tms.business.other.express.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.other.express.vo.ExpressImportVo;

public interface ExpressService {

	public List<ExpressImportVo> importExpressExcel(MultipartFile file) throws IOException ;
	public void updatePiecesExpressInfo(List<ExpressImportVo> importVoList);

}
