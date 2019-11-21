package com.patentmanager.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**          
 * @description：  日期封装类
 * @author  dupeng
 * @date：2019年11月20日  15:15:24
 * @version  V1.0
 */

public class DateUtil {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Date str2Date(String timeStr) throws ParseException{
		Date toDate = new Date();
		if(timeStr.contains("Z")){
			String UTCString = timeStr.replace("Z", " UTC");
			SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			toDate =  utcFormat.parse(UTCString);
		}

		else {
			toDate = format.parse(timeStr);
		}
		return toDate;
	}
	public static Date obj2Date(Object timeStr) throws ParseException{
		Date toDate = format.parse(timeStr.toString());
		return toDate;
	}
	
	public static Object timeStamp2Obj(Object timestamp){
		Object date = format.format(timestamp);
		return date;
	}
	
	public static Timestamp obj2TimeStamp(Object timeStr){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(timeStr.toString());
		return ts;
	}
	public static Timestamp str2TimeStamp(String timeStr){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(timeStr);
		return ts;
	}
	
	public static String getNowDateStr(){
		Date now = new Date();
		return  format.format(now);
	}
}
