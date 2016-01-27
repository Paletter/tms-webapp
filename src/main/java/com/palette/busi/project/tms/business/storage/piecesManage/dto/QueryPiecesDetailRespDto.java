package com.palette.busi.project.tms.business.storage.piecesManage.dto;

import java.util.List;

import com.palette.busi.project.tms.business.storage.piecesManage.vo.PiecesDetailHistoryResultVo;
import com.palette.busi.project.tms.business.storage.piecesManage.vo.PiecesDetailResultVo;
import com.palette.busi.project.tms.common.base.BaseRespDto;
import com.palette.busi.project.tms.core.entity.TmConsignmentItem;

public class QueryPiecesDetailRespDto extends BaseRespDto {

    private PiecesDetailResultVo piecesDetailResultVo;
    private List<TmConsignmentItem> tmConsignmentItemList;
    private List<PiecesDetailHistoryResultVo> piecesHistoryVoList;

	public PiecesDetailResultVo getPiecesDetailResultVo() {
		return piecesDetailResultVo;
	}

	public void setPiecesDetailResultVo(PiecesDetailResultVo piecesDetailResultVo) {
		this.piecesDetailResultVo = piecesDetailResultVo;
	}

	public List<TmConsignmentItem> getTmConsignmentItemList() {
		return tmConsignmentItemList;
	}

	public void setTmConsignmentItemList(
			List<TmConsignmentItem> tmConsignmentItemList) {
		this.tmConsignmentItemList = tmConsignmentItemList;
	}

	public List<PiecesDetailHistoryResultVo> getPiecesHistoryVoList() {
		return piecesHistoryVoList;
	}

	public void setPiecesHistoryVoList(
			List<PiecesDetailHistoryResultVo> piecesHistoryVoList) {
		this.piecesHistoryVoList = piecesHistoryVoList;
	}
    
}
