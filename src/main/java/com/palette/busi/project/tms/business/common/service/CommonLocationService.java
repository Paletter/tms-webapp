package com.palette.busi.project.tms.business.common.service;

import com.palette.busi.project.tms.business.common.vo.ComPiecesPutUpUpdateVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface CommonLocationService {

	public void piecesPutUpToLocation(ComPiecesPutUpUpdateVo piecesPutUpUpdateVo, ServiceOptParamLinkerVo paramLinkerVo);
}
