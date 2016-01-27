package com.palette.busi.project.tms.business.storage.piecesManage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.storage.piecesManage.dto.QueryPiecesDetailRespDto;
import com.palette.busi.project.tms.business.storage.piecesManage.dto.QueryPiecesListReqDto;
import com.palette.busi.project.tms.business.storage.piecesManage.vo.PiecesDetailHistoryResultVo;
import com.palette.busi.project.tms.business.storage.piecesManage.vo.PiecesDetailResultVo;
import com.palette.busi.project.tms.business.storage.piecesManage.vo.PiecesListPageParamVo;
import com.palette.busi.project.tms.business.storage.piecesManage.vo.PiecesListResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.CallDbSpUtils;
import com.palette.busi.project.tms.core.entity.TmConsignmentItem;
import com.palette.busi.project.tms.core.page.PageInfo;

@RestController
public class PiecesManageController extends BaseController {

	@RequestMapping(value="/PiecesManageController/queryPiecesList")
	public PageInfo<PiecesListResultVo> queryPiecesList(@RequestBody QueryPiecesListReqDto reqDto) {
		
		PiecesListPageParamVo piecesListPageParamVo = new PiecesListPageParamVo();
		
		BeanUtilsExt.copyPropertiesIgnoreDefault(reqDto, piecesListPageParamVo);
		piecesListPageParamVo.setWarehouseCode(getSessionWarehouseCode());
		
		PageInfo<PiecesListResultVo> result = selectPageInfo(SqlMapperConstants.PIECES_MANAGE_QUERY_PIECES_LIST, piecesListPageParamVo);
		
		return result;
	}

	@RequestMapping(value="/PiecesManageController/queryPiecesDetailInfos")
	public QueryPiecesDetailRespDto queryPiecesDetailInfos(@RequestParam(value="piecesNo") String piecesNo) {
		
		// Business
		List<Object> resultList = (List<Object>) baseDao.selectList(SqlMapperConstants.PIECES_MANAGE_GET_PIECES_DETAIL_SP, piecesNo);
		
		PiecesDetailResultVo piecesDetailResultVo = (PiecesDetailResultVo) CallDbSpUtils.getSubResultListFirstValue(resultList, 0);
		List<TmConsignmentItem> consignmentItemList = (List<TmConsignmentItem>) resultList.get(1);
		List<PiecesDetailHistoryResultVo> piecesHistoryVoList = (List<PiecesDetailHistoryResultVo>) resultList.get(2);
		
		// Encapsulation result
		QueryPiecesDetailRespDto respDto = new QueryPiecesDetailRespDto();
		respDto.setPiecesDetailResultVo(piecesDetailResultVo);
		respDto.setTmConsignmentItemList(consignmentItemList);
		respDto.setPiecesHistoryVoList(piecesHistoryVoList);
		
		return respDto;
	}
}
