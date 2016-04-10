package com.palette.busi.project.tms.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.core.entity.CdDelivery;
import com.palette.busi.project.tms.core.entity.TmConsignment;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.server.dto.QueryPiecesReqDto;
import com.palette.busi.project.tms.server.dto.QueryPiecesRespDto;
import com.palette.busi.project.tms.server.vo.DeliveryVo;
import com.palette.busi.project.tms.server.vo.DeliveryVo.DetailDelivery;
import com.palette.busi.project.tms.server.vo.PiecesHistoryResultVo;
import com.palette.busi.project.tms.server.vo.QueryPiecesReqDataVo;

@RestController
public class PiecesController extends BaseController {

	public String QUERY_PIECES_HISTORY = "com.palette.busi.project.tms.server.mapper.server.queryPiecesHistory";
	
	@RequestMapping(value="/Server/PiecesService/queryPiecesInfo")
	public QueryPiecesRespDto queryPiecesInfo(@RequestBody QueryPiecesReqDto reqDto) {
		
		// TODO Validate
		
		// Business
		QueryPiecesReqDataVo data = reqDto.getReqData();
		
		// Query pieces
		TmPieces tmPiecesQuery = new TmPieces();
		if(StringUtils.isNotNullOrEmpty(data.getPiecesNo()))
			tmPiecesQuery.setPiecesNo(data.getPiecesNo());
		if(StringUtils.isNotNullOrEmpty(data.getReferenceNo()))
			tmPiecesQuery.setLogisticsNo(data.getReferenceNo());
		if(StringUtils.isNotNullOrEmpty(data.getCsmNo()))
			tmPiecesQuery.setConsignmentNo(data.getCsmNo());
		tmPiecesQuery.setCompanyCode(data.getCompanyCode());
		TmPieces tmPieces = querier.selectTmPiecesOneByRecord(tmPiecesQuery);
		
		TmConsignment tmCsm = null;
		List<PiecesHistoryResultVo> piecesHistoryVoList = new ArrayList<PiecesHistoryResultVo>();
		if(tmPieces != null) {
			
			// Query consignment
			if(tmPieces.getTmConsignmentId() != null) {
				tmCsm = querier.selectTmConsignmentById(tmPieces.getTmConsignmentId());
			}
		
			// Query pieces history
			piecesHistoryVoList = selectList(QUERY_PIECES_HISTORY, tmPieces.getTmPiecesId());
		}
		
		// Encapsulation result
		QueryPiecesRespDto respDto = new QueryPiecesRespDto();
		
		List<PiecesHistoryResultVo> deliveryPiecesHistoryResultVoList = new ArrayList<PiecesHistoryResultVo>();
		if(tmPieces != null) {
			respDto.setReferenceNo(tmPieces.getLogisticsNo());
			
			if(tmPieces.getDeliveryCode() != null) {
				CdDelivery cdDeliveryQuery = new CdDelivery();
				cdDeliveryQuery.setDeliveryCode(tmPieces.getDeliveryCode());
				CdDelivery cdDelivery = querier.selectCdDeliveryOneByRecord(cdDeliveryQuery);
				
				if(cdDelivery != null) {
					respDto.setDeliveryName(cdDelivery.getDeliveryName());
					
					if(tmPieces.getDeliveryNo() != null) {
//						HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//						CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
//						String companyCode = cdDelivery.getDeliveryCode().trim();
//						String trackingNumber = tmPieces.getDeliveryNo().trim();
//						HttpGet get = new HttpGet("http://toolkit.udfexpress.com/exsearch/api/search_cn.php?companycode=" + companyCode + "&trackingnumber=" + trackingNumber);
//						try {
//							
//							HttpResponse httpResponse = closeableHttpClient.execute(get);
//							String content = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
//							DeliveryVo deliveryVo = JSONObject.parseObject(content, DeliveryVo.class);
//							
//							if(null != deliveryVo && "OK".equals(deliveryVo.getStatus())){
//								List<DetailDelivery> result = deliveryVo.getData();
//								for (DetailDelivery detailDelivery : result) {
//									if(detailDelivery.getTime() != null && StringUtils.isNotNullOrEmpty(detailDelivery.getEvent())) {
//										PiecesHistoryResultVo piecesHistoryResultVo = new PiecesHistoryResultVo();
//										Date date = new Date(detailDelivery.getTime().getTime() - 1000 * 60 * 60 * 13);
//										piecesHistoryResultVo.setActionDateTime(DateUtils.parse(date, DateUtils.dateTimeFormat));
//										piecesHistoryResultVo.setMemo(detailDelivery.getEvent());
//										deliveryPiecesHistoryResultVoList.add(piecesHistoryResultVo);
//									}
//								}
//							}
//							
//						} catch (Exception e) {
//							log.error(e.getMessage());
//						} finally{
//							try {
//								closeableHttpClient.close();
//							} catch (IOException e) {
//								log.error("释放快递公司接口请求发生异常", e);
//							}
//						}
					}
				}
			}
			respDto.setDeliveryNo(tmPieces.getDeliveryNo());
		}
		
		if(tmCsm != null) {
			BeanUtilsExt.copyPropertiesIgnoreDefault(tmCsm, respDto);
		}
		
		piecesHistoryVoList.addAll(deliveryPiecesHistoryResultVoList);
		respDto.setPiecesHistoryVoList(piecesHistoryVoList);
		
		return respDto;
			
	}
}
