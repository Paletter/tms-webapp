package com.palette.busi.project.tms.common.constant;

public class SqlMapperConstants {

	// Business common
	public static final String BUSINESS_COMMON_NAMSPACE = "com.palette.busi.project.tms.business.common.mapper.business_common.";
	public static final String BUSINESS_COMMON_QUERY_SEQ_NEXTVAL = BUSINESS_COMMON_NAMSPACE + "querySeqNextval";
	public static final String BUSINESS_COMMON_DELETE_PIECES_NO_LOCATION_CURRENT = BUSINESS_COMMON_NAMSPACE + "deletePiecesNoLocationCurrent";
	public static final String BUSINESS_COMMON_CALL_GET_USABLE_PIECES_SP = BUSINESS_COMMON_NAMSPACE + "callGetUsablePiecesSp";
	
	// Login
	public static final String LOGIN_NAMESPACE = "com.palette.busi.project.tms.business.basic.login.mapper.login.";
	public static final String LOGIN_QUERY_LOAD_USER_DETAILS_INFO = LOGIN_NAMESPACE + "queryLoadUserDetailsInfo";
	public static final String LOGIN_QUERY_USER_MENU = LOGIN_NAMESPACE + "queryUserMenu";
	
	// Welcome
	public static final String WELCOME_NAME_SPACE = "com.palette.busi.project.tms.business.basic.welcome.mapper.welcome.";
	public static final String WELCOME_QUERY_US_DADLY_STOCK_IN_PIECES = WELCOME_NAME_SPACE + "queryUSDaylyStockInPieces";
	public static final String WELCOME_QUERY_DE_DADLY_STOCK_IN_PIECES = WELCOME_NAME_SPACE + "queryDEDaylyStockInPieces";
	
	// Pieces stock in
	public static final String PIECES_STOCK_IN_NAMESPACE = "com.palette.busi.project.tms.business.stockIn.piecesStockIn.mapper.pieces_stock_in.";
	public static final String PIECES_STOCK_IN_QUERY_STOCK_IN_PIECES = PIECES_STOCK_IN_NAMESPACE + "queryStockInPieces";
	
	// Check weight
	public static final String CHECK_WEIGHT_NAMESPACE = "com.palette.busi.project.tms.business.storage.checkWeight.mapper.check_weight.";
	public static final String CHECK_WEIGHT_QUERY_CHECK_WEIGHT_PIECES = CHECK_WEIGHT_NAMESPACE + "queryCheckWeightPieces";
	
	// Pieces manage
	public static final String PIECES_MANAGE_NAMESPACE = "com.palette.busi.project.tms.business.storage.piecesManage.mapper.pieces_manage.";
	public static final String PIECES_MANAGE_QUERY_PIECES_LIST = PIECES_MANAGE_NAMESPACE + "queryPiecesList";
	public static final String PIECES_MANAGE_GET_PIECES_DETAIL_SP = PIECES_MANAGE_NAMESPACE + "callGetPiecesDetailSp";
	
	// Flight
	public static final String FLIGHT_NAMESPACE = "com.palette.busi.project.tms.business.delivery.flight.mapper.flight.";
	public static final String FLIGHT_QUERY_FLIGHT = FLIGHT_NAMESPACE + "queryFlightList";
	public static final String FLIGHT_QUERY_VALIDATE_FLIGHT = FLIGHT_NAMESPACE + "queryValidateFlight";
	public static final String FLIGHT_DELETE_TM_UNIT_BY_FLIGHT = FLIGHT_NAMESPACE + "deleteTmUnitByFlight";
	public static final String FLIGHT_DELETE_SECTOR_CURRENT = FLIGHT_NAMESPACE + "deleteSectorCurrent";
	public static final String FLIGHT_DELETE_SECTOR_HISTORY = FLIGHT_NAMESPACE + "deleteSectorHistory";
	public static final String FLIGHT_QUERY_PRINT_UNIT_LIST = FLIGHT_NAMESPACE + "queryPrintUnitList";
	
	// Pack goods
	public static final String PACK_GOODS_NAMESPACE = "com.palette.busi.project.tms.business.delivery.packGoods.mapper.pack_goods.";
	public static final String PACK_GOODS_CALL_GET_UNIT_AND_CSM_SP = PACK_GOODS_NAMESPACE + "callGetUnitAndCsmSp";
	public static final String PACK_GOODS_UPDATE_PIECES_UNIT_INFO = PACK_GOODS_NAMESPACE + "updatePiecesUnitInfo";
	
	// Express
	public static final String EXPRESS_NAMESPACE = "com.palette.busi.project.tms.business.other.express.mapper.express.";
	public static final String EXPRESS_BATCH_UPDATE_PIECES_DELIVERY_INFO = EXPRESS_NAMESPACE + "batchUpdatePiecesDeliveryInfo";
	
	// Out batch
	public static final String OUT_BATCH_NAMESPACE = "com.palette.busi.project.tms.business.delivery.outBatch.mapper.out_batch.";
	public static final String OUT_BATCH_QUERY_OUT_BATCH_LIST = OUT_BATCH_NAMESPACE + "queryOutBatchList";
	
	// Out batch deliver
	public static final String OUT_BATCH_DELIVER_NAMESPACE = "com.palette.busi.project.tms.business.delivery.outBatchDeliver.mapper.out_batch_deliver.";
	public static final String OUT_BATCH_DELIVER_BATCH_UPDATE_PIECES_BATCH_INFO = OUT_BATCH_DELIVER_NAMESPACE + "batchUpdatePiecesBatchInfo";
}
