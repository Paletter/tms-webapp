package com.palette.busi.project.tms.business.basic.welcome.vo;

import java.util.List;

public class TodayStockInPiecesStatsResultVo {

	private Integer stockInPiecesQty;
	private Integer alreadyPutUpPiecesQty;
	private List<DaylyStockInPiecesResultVo> notPutUpPiecesList;

	public Integer getStockInPiecesQty() {
		return stockInPiecesQty;
	}

	public void setStockInPiecesQty(Integer stockInPiecesQty) {
		this.stockInPiecesQty = stockInPiecesQty;
	}

	public Integer getAlreadyPutUpPiecesQty() {
		return alreadyPutUpPiecesQty;
	}

	public void setAlreadyPutUpPiecesQty(Integer alreadyPutUpPiecesQty) {
		this.alreadyPutUpPiecesQty = alreadyPutUpPiecesQty;
	}

	public List<DaylyStockInPiecesResultVo> getNotPutUpPiecesList() {
		return notPutUpPiecesList;
	}

	public void setNotPutUpPiecesList(
			List<DaylyStockInPiecesResultVo> notPutUpPiecesList) {
		this.notPutUpPiecesList = notPutUpPiecesList;
	}
}
