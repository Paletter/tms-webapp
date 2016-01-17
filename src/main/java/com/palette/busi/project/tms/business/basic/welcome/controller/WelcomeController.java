package com.palette.busi.project.tms.business.basic.welcome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.basic.welcome.vo.DaylyStockInPiecesResultVo;
import com.palette.busi.project.tms.business.basic.welcome.vo.TodayStockInPiecesStatsResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.StringUtils;

@RestController
public class WelcomeController extends BaseController {

	@RequestMapping(value="/WelcomeController/queryTodayStockInPiecesStats")
	public TodayStockInPiecesStatsResultVo queryTodayStockInPiecesStats() throws Exception {
		
		TodayStockInPiecesStatsResultVo resultVo = new TodayStockInPiecesStatsResultVo();
		
		if(getSessionCountryCode().equals(CodeConstants.COUNTRY_CODE.US)) {
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("warehouseCode", getSessionWarehouseCode());
			String currentDate = DateUtils.getCurrentDate(getSessionCountryCode(), "yyyy-MM-dd");
			params.put("day", currentDate);
			List<DaylyStockInPiecesResultVo> daylyStockInPiecesResultVoList = selectList(SqlMapperConstants.WELCOME_QUERY_US_DADLY_STOCK_IN_PIECES, params);
			
			Integer putUpPiecesQty = 0;
			List<DaylyStockInPiecesResultVo> notPutUpPiecesList = new ArrayList<DaylyStockInPiecesResultVo>();
			for(DaylyStockInPiecesResultVo daylyStockInPiecesResultVo : daylyStockInPiecesResultVoList) {
				if(StringUtils.isNotNullOrEmpty(daylyStockInPiecesResultVo.getLocationCode())) putUpPiecesQty ++;
				if(StringUtils.isNullOrEmpty(daylyStockInPiecesResultVo.getLocationCode())) notPutUpPiecesList.add(daylyStockInPiecesResultVo);
			}
			
			resultVo.setStockInPiecesQty(daylyStockInPiecesResultVoList.size());
			resultVo.setAlreadyPutUpPiecesQty(putUpPiecesQty);
			resultVo.setNotPutUpPiecesList(notPutUpPiecesList);
		}
		
		return resultVo;
	}
}
