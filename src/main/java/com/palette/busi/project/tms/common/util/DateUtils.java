package com.palette.busi.project.tms.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import com.palette.busi.project.tms.common.constant.CodeConstants;

public class DateUtils {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");

    public static Date parse(final String source) throws ParseException {
        if (source == null || source.trim().length() == 0) {
            return null;
        }
        if (source.length() <= dateTimeFormat.toPattern().length()
                && source.length() >= dateTimeFormat.toPattern().length() - 5) {
        	return dateTimeFormat.parse(source);
        }
        if (source.length() <= dateFormat.toPattern().length()
                && source.length() >= dateFormat.toPattern().length() - 2) {
            return dateFormat.parse(source);
        }
        if (source.length() <= monthFormat.toPattern().length()
                && source.length() >= monthFormat.toPattern().length() - 1) {
            return monthFormat.parse(source);
        }
        return dateTimeFormat.parse(source);
    }

    public static String parse(final Date source, SimpleDateFormat sdf) throws ParseException {
        return sdf.format(source);
    }
    
    public static String addDay(String dateStr, String format) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date d = sf.parse(dateStr);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, 1);
		return sf.format(c.getTime());
    }
    
    public static String addDay(String dateStr, SimpleDateFormat format) throws ParseException {
    	Date d = format.parse(dateStr);
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	c.add(Calendar.DATE, 1);
    	return format.format(c.getTime());
    }
    
    public static Date getCurrentGMTDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        try {
            return parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getGMTDateByTimezone(int timezone, Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(new SimpleTimeZone(timezone, "GMT"));
        return parse(dateFormat.format(date));
    }
    
    public static String parseTimeToGMTDateTime(String date, SimpleDateFormat sdf) throws ParseException {
    	Date d = sdf.parse(date);
    	SimpleDateFormat gmtSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	gmtSdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    	return gmtSdf.format(d);
    }
    
    public static String parseGMTDateTimeToLocalTimeZone(String date, SimpleDateFormat sdf) throws ParseException {
    	Date d = sdf.parse(date);
    	
    	Calendar cal = Calendar.getInstance();
		TimeZone timeZone = cal.getTimeZone();
    	
		SimpleDateFormat localSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		localSdf.setTimeZone(timeZone);
    	return localSdf.format(d);
    }
    
    public static String parseGMTDateTimeToLocalTimeZone(Date date) throws ParseException {
    	Calendar cal = Calendar.getInstance();
    	TimeZone localTimeZone = cal.getTimeZone();
    	TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
    	
    	Date target = new Date(date.getTime() - gmtTimeZone.getRawOffset() + localTimeZone.getRawOffset());
    	return dateTimeFormat.format(target);
    }
    
    public static String getCurrentDate(String countryCode, String format) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    	if(countryCode.equals(CodeConstants.COUNTRY_CODE.US)) {
    		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    	} else {
    		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    	}
    	return dateFormat.format(new Date());
    }
}
