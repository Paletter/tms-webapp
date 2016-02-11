package com.palette.busi.project.tms.common.constant;


public class CodeConstants {
	
	public static class PIECES_ACTION {
		public static String CL = "CL";
		public static String CI = "CI";
		public static String SN = "SN";
		public static String HW = "HW";
		public static String KW = "KW";
		public static String CP = "CP";
		public static String PK = "PK";
		public static String CO = "CO";
		public static String UL = "UL";
		public static String DL = "DL";
	}
	
	public static class SECTOR_ACTION {
		public static String CR = "CR";
		public static String OS = "OS";
		public static String UL = "UL";
		public static String DL = "DL";
	}
	
	public static class SERVICE_LINE_REF_TYPE {
		public static String IN_STOCK_NO = "IN_STOCK_NO";
		public static String CLEARANCE_NO = "CLEARANCE_NO";
	}
	
	public static class SERVICE_LINE_CODE {
		public static String SZ = "SZ";
		public static String NB = "NB";
		public static String TJ = "TJ";
	}
	
	public static class SERVICE_LINE_PARTY_TYPE {
		public static String SHIPPER = "SHIPPER";
		public static String CONSIGNEE = "CONSIGNEE";
	}
	
	public static class COUNTRY_CODE {
		public static String DE = "DE";
		public static String US = "US";
		public static String CA = "CA";
		public static String JP = "JP";
		public static String CN = "CN";
	}
	
	public static class LOCATION_HITORY_ACTION_CODE {
		public static String PUT_UP = "PUT_UP";
		public static String PUT_DOWN = "PUT_DOWN";
	}
	
	public static class LOCATION_HITORY_MEMO_TEMPLATE {
		public static String NORMAL = "NORMAL";
		public static String COMBINATE_AUTO_DOWN = "COMBINATE_AUTO_DOWN";
		public static String PACK_AUTO_DOWN = "PACK_AUTO_DOWN";
		public static String DETAIN_AUTO_DOWN = "DETAIN_AUTO_DOWN";
		public static String SINGLE_DELIVER_AUTO_DOWN = "SINGLE_DELIVER_AUTO_DOWN";
	}
	
	public static class EXCHANGE_RATE_TYPE {
		public static String COMMON_EXPENSE = "COMMON_EXPENSE";
		public static String CONSIGNMENT_EXPENSE = "CONSIGNMENT_EXPENSE";
	}
	
	public static class CURRENY {
		public static String USD = "USD";
		public static String CNY = "CNY";
		public static String CAD = "CAD";
		public static String EUR = "EUR";
		public static String JPY = "JPY";
	}
	
	public static class CONSIGNMENT_REF_TYPE {
		public static String DHL_TRACK_NO = "DHL_TRACK_NO";
		public static String COMBINE_COMPLETE_STATUS = "COMBINE_COMPLETE_STATUS";
	}
	
	public static class ATTACHMENT_REF_RELATION_TYPE {
		public static String STOCK_IN_PIECES_PHOTO = "STOCK_IN_PIECES_PHOTO";
	}
	
	public static class SINGLE_PIECES_DELIVERY_TYPE {
		public static String POST = "POST";
		public static String STANDARD = "STANDARD";
	}
	
	public static class SERVICE_PRODUCT_TYPE {
		public static String POST = "POST";
		public static String STANDARD = "STANDARD";
	}
	
	public static class PIECES_REF_TYPE {
		public static String BUSINESS_CUSTOMER_REF_CODE = "BUSINESS_CUSTOMER_REF_CODE";
	}
	
	public static class SERVICE_PRODUCT_FEE_WEIGHT {
		public static Integer NORMAL = 0;
		public static Integer JUST_GROSS_WEIGHT = 1;
	}
	
	public static class CHECK_PICK_TYPE {
		public static String PACK = "PACK";
		public static String COMBINE = "COMBINE";
		public static String NO = "NO";
	}
	
	public static class CHECK_PICK_RESULT_STATUS {
		public static Integer ERROR = 0;
		public static Integer RIGHT = 1;
	}
	
	public static class USER_ROLE_CATEGORY {
		public static String ROOT = "ROOT";
		public static String USER = "USER";
	}
	
	public static class DELIVERY_ORDER_STATUS {
		public static String INITIAL = "INITIAL";
		public static String FINISH = "FINISH";
	}
	
	public static class DELIVERY_ORDER_ITEM_STATUS {
		public static String INITIAL = "INITIAL";
		public static String CANCEL = "CANCEL";
		public static String FINISH = "FINISH";
	}
	
	public static class CONSIGNMENT_AUTO_DISASSEMBLE_STATUS {
		public static Integer NORMAL = 0;
		public static Integer DISASSEMBLE_SLAVE = 1;
		public static Integer DISASSEMBLE_MASTER = 2;
	}
	
	public static class CONSIGNMENT_AUDIT_STATUS {
		public static Integer WAIT_AUDIT = 0;
		public static Integer AUDIT_PASS = 1;
		public static Integer AUDIT_REJECT = 2;
	}
	
	public static class SEQUENCE_NUMBER_TYPE {
		public static String PIECES_NO = "PIECES_NO";
		public static String UNIT_NO = "UNIT_NO";
		public static String SECTOR_NO = "SECTOR_NO";
		public static String SYNC_TARGET_NO = "SYNC_TARGET_NO";
		public static String DELIVERY_ORDER_NO = "DELIVERY_ORDER_NO";
		public static String OUT_BATCH_NO = "OUT_BATCH_NO";
	}
	
	public static class OUT_BATCH_STATUS {
		public static String INITIAL = "INITIAL";
		public static String OUT = "OUT";
	}
	
}
