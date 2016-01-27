package com.palette.busi.project.tms.business.common.service;

import com.palette.busi.project.tms.business.common.vo.ComPutPiecesDownUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComPutPiecesUpUpdateVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;

public interface CommonLocationService {

	public void putPiecesUpToLocation(ComPutPiecesUpUpdateVo piecesPutUpUpdateVo, ServiceOptParamLinkerVo paramLinkerVo);
	public void putPiecesDownFromLocation(ComPutPiecesDownUpdateVo updateVo, ServiceOptParamLinkerVo linkerVo);
}
