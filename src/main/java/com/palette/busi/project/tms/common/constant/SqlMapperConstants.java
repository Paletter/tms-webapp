package com.palette.busi.project.tms.common.constant;

public class SqlMapperConstants {

	// Sequence number generate
	public static final String SEQ_NUMBER_NAMSPACE = "com.palette.busi.project.tms.business.common.mapper.seq_number.";
	public static final String SEQ_NUMBER_GET_SEQ_NEXTVAL = SEQ_NUMBER_NAMSPACE + "querySeqNextval";
	
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
}
