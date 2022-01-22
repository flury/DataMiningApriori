package com.datamining.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GlobalUtil {

	public static Date trimDate(Date date,boolean trim) throws ParseException{
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		if(trim){
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
		}else{
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);
		}
		return calendar.getTime();
	}
	
	public static Date getTimeByTimeZone(Integer timezone) throws ParseException {
		SimpleDateFormat sdfServer = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdfClient = new SimpleDateFormat("HH:mm");
		
		//Check timezone
		if (timezone.compareTo(new Integer(0)) < 0) {
			sdfClient.setTimeZone(TimeZone.getTimeZone("GMT" + timezone));
		} else {
			sdfClient.setTimeZone(TimeZone.getTimeZone("GMT+" + timezone));
		}
		
		return sdfServer.parse(sdfClient.format(new Date()));
	}
	
	public static BigDecimal dividePercent(BigDecimal valueOne, BigDecimal valueTwo) {
		return valueOne.divide(valueTwo, 2, RoundingMode.HALF_UP);
	}
	
	public static int getHoursTime(Date clientTime) {
		
		try { 
			clientTime = getTimeByTimeZone(7); 
		} catch (ParseException e) { 
			e.getMessage(); 
		}
		
		//	Get Hours with Calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(clientTime);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		
		return hours;
	}
	
	/**
	 * Check Interval Contains
	 * @param low
	 * @param high
	 * @param n
	 * @return true or false
	 */
	public static Boolean intervalContains(int low, int high, int n) {
	    return n >= low && n <= high;
	}
	
	public static BigDecimal multiply(int quantity, int price) {
		BigDecimal qty = new BigDecimal(quantity);
		BigDecimal prc = new BigDecimal(price);
		return qty.multiply(prc);
	}
	
	public static String formatMonthOfYear(int getMonthOfYear) {
		String formatMonth = "";
		switch (getMonthOfYear) {
		case 1:
			formatMonth = "01";
			break;
		case 2:
			formatMonth = "02";
			break;
		case 3:
			formatMonth = "03";
			break;
		case 4:
			formatMonth = "04";
			break;
		case 5:
			formatMonth = "05";
			break;
		case 6:
			formatMonth = "06";
			break;
		case 7:
			formatMonth = "07";
			break;
		case 8:
			formatMonth = "08";
			break;
		case 9:
			formatMonth = "09";
			break;
		}
		
		return formatMonth;
	}
	
}
