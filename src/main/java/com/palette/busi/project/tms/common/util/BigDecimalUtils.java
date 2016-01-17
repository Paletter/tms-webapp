package com.palette.busi.project.tms.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtils {

	public static BigDecimal ZERO = BigDecimal.ZERO;
	public static BigDecimal ONE = BigDecimal.ONE;
	public static BigDecimal THREE = new BigDecimal(3);
	
	public static DecimalFormat SCALE_THREE_FORMAT = new DecimalFormat("0.000");
	
	public static boolean isMoreThanZero(BigDecimal decimal) {
		if(decimal != null) {
			return decimal.compareTo(ZERO) > 0;
		}
		return false;
	}
	
	public static boolean isMoreAndEqualZero(BigDecimal decimal) {
		if(decimal != null) {
			return decimal.compareTo(ZERO) >= 0;
		}
		return false;
	}
	
	public static boolean isZero(BigDecimal decimal) {
		if(decimal != null) {
			return decimal.compareTo(ZERO) == 0;
		}
		return false;
	}
	
	public static Integer compare(BigDecimal b1, Integer i2) {
		if(b1 == null) b1 = ZERO;
		if(i2 == null) i2 = 0;
		return b1.compareTo(BigDecimal.valueOf(i2));
	}
	
	public static Integer compare(BigDecimal b1, BigDecimal b2) {
		if(b1 == null) b1 = ZERO;
		if(b2 == null) b2 = ZERO;
		return b1.compareTo(b2);
	}
	
	public static Integer compare(BigDecimal b1, Double d2) {
		if(b1 == null) b1 = ZERO;
		if(d2 == null) d2 = Double.valueOf(0);
		return b1.compareTo(BigDecimal.valueOf(d2));
	}
	
	public static BigDecimal multiply(BigDecimal b1, BigDecimal b2) {
		if(b1 == null || b2 == null) return ZERO;
		return b1.multiply(b2);
	}
	
	public static BigDecimal multiply(BigDecimal b1, Integer i2) {
		if(b1 == null || i2 == null) return ZERO;
		BigDecimal b2 = new BigDecimal(i2);
		return b1.multiply(b2);
	}

	public static BigDecimal multiply(BigDecimal b1, BigDecimal b2, int scale) {
		if(b1 == null || b2 == null) return ZERO;
		return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
		if(b1 == null && b2 == null) return ZERO;
		if(b1 == null) return b2;
		if(b2 == null) return b1;
		return b1.add(b2);
	}
	
	public static BigDecimal add(BigDecimal b1, Integer i2) {
		if(b1 == null && i2 == null) return ZERO;
		if(b1 == null) return new BigDecimal(i2);
		if(i2 == null) return b1;
		return b1.add(new BigDecimal(i2));
	}
	
	public static BigDecimal subtract(BigDecimal b1, BigDecimal b2) {
		if(b1 == null && b2 == null) return ZERO;
		if(b1 == null) return b2;
		if(b2 == null) return b1;
		return b1.subtract(b2);
	}
	
	public static BigDecimal subtract(BigDecimal b1, BigDecimal b2, int scale) {
		if(b1 == null && b2 == null) return ZERO;
		if(b1 == null) return b2.setScale(scale, BigDecimal.ROUND_HALF_UP);
		if(b2 == null) return b1.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}
	
	public static boolean equals(BigDecimal b1, BigDecimal b2) {
		if(b1 == null || b2 == null) return false;
		return b1.equals(b2);
	}
	
	public static BigDecimal divide(BigDecimal b1, BigDecimal b2, Integer scale) {
		if(b1 == null || b2 == null || isZero(b2)) return ZERO;
		if(scale == null) scale = 2;
		return b1.divide(b2, scale);
	}
	
	public static BigDecimal divide(BigDecimal b1, Integer i2, Integer scale) {
		if(b1 == null || i2 == null || i2 == 0) return ZERO;
		BigDecimal b2 = new BigDecimal(i2);
		if(scale == null) scale = 2;
		return b1.divide(b2, scale);
	}
	
	public static BigDecimal divide(BigDecimal b1, BigDecimal b2) {
		if(b1 == null || b2 == null || isZero(b2)) return ZERO;
		return b1.divide(b2, 2);
	}
	
	public static BigDecimal divide(BigDecimal b1, Integer i2) {
		if(b1 == null || i2 == null || i2 == 0) return ZERO;
		BigDecimal b2 = new BigDecimal(i2);
		return b1.divide(b2, 2);
	}
	
	public static BigDecimal getBiggerOrEqual(BigDecimal b1, BigDecimal b2) {
		if(b1 == null && b2 == null) return null;
		if(b1 == null && b2 != null) return b2;
		if(b1 != null && b2 == null) return b1;
		return compare(b1, b2) >= 0 ? b1 : b2;
	}
	
	public static BigDecimal getLessOrEqual(BigDecimal b1, BigDecimal b2) {
		return compare(b1, b2) <= 0 ? b1 : b2;
	}
	
	public static BigDecimal setScaleOfLimit(BigDecimal b, Integer scale, Double limit) {
		if(b == null || scale == null || limit == null) {
			return ZERO;
		}
		
		BigDecimal floatValue = b.subtract(new BigDecimal(b.intValue()));
		if(compare(floatValue, limit) > 0) {
			return b.setScale(scale, BigDecimal.ROUND_UP);
		} else {
			return b.setScale(scale, BigDecimal.ROUND_DOWN);
		}
	}
}
