package com.datamining.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class PeriodFormater {

	/**
	 * For DateTime Formatter Intialize
	 * @param String formatter ex. "d MMMM yyyy" or "dd-MM-yyyy"
	 * @return DateTime format ex.31-11-2014 or 1 January 2014
	 */
	public static DateTimeFormatter simpleDateFormatter(String formatter) {
		DateTimeFormatter dateFmtComplete = DateTimeFormat.forPattern(formatter);
		return dateFmtComplete;
	}
	
	/**
	 * For Calculate How Long DateTime
	 * @param in 
	 * @param out 
	 * @param seeds
	 * @return ? Years or ? Months ? Years
	 */
	public static String getPeriodFormatter(DateTime in, DateTime out, String seeds) {
		
		DateTime dateIn = new DateTime(in);
		DateTime dateOut = new DateTime(out);
		
		Period period = new Period(dateIn, dateOut);
		PeriodFormatter formatter = null;
		
		if (seeds.equals("age")) {
			formatter = new PeriodFormatterBuilder()
				.appendYears().appendSuffix(" Years Old ")
				.printZeroNever()
				.toFormatter();
		} else if (seeds.equals("longWork")) {
			formatter = new PeriodFormatterBuilder()
				.appendYears().appendSuffix(" Tahun ")	
				.appendMonths().appendSuffix(" Bulan ")
				.printZeroNever()
				.toFormatter();
		}
		
		String resultPeriod = formatter.print(period);
		return resultPeriod;
	}
	
	public static String getDayName() {
		DateTime newDate = new DateTime(new Date());
		String dayName = newDate.dayOfWeek().getAsText();
		return dayName;
	}
	
	public static String getLocalTimeNow() {
		DateTime newDate = new DateTime(new Date());
		String localTimeNow = newDate.toLocalTime().toString("HH:mm");
		return localTimeNow;
	}
	
	public static Integer getShortShift(LocalTime timeNow) {
		Integer idShift = 0;
		LocalTime firstTime1 = new LocalTime(06,00);
		LocalTime firstTime2 = new LocalTime(11,00);
		
		LocalTime secondTime1 = new LocalTime(11,00);
		LocalTime secondTime2 = new LocalTime(16,00);
		
		LocalTime thirdTime1 = new LocalTime(16,00);
		LocalTime thirdTime2 = new LocalTime(21,00);
		
		if (timeNow.isAfter(firstTime1) && timeNow.isBefore(firstTime2)) {	//Shift 1
			idShift = 4;
		} else if (timeNow.isAfter(secondTime1) && timeNow.isBefore(secondTime2)) { //Shift 2
			idShift = 5;
		} else if (timeNow.isAfter(thirdTime1) && timeNow.isBefore(thirdTime2)) { //Shift 3
			idShift = 6;
		}
		return idShift;
	}
	
	public static Integer getNormalShift(LocalTime timeNow) {
		Integer idShift = 0;
		LocalTime firstTime1 = new LocalTime(06,00);
		LocalTime firstTime2 = new LocalTime(14,00);
		
		LocalTime secondTime1 = new LocalTime(14,00);
		LocalTime secondTime2 = new LocalTime(22,00);
		
		LocalTime thirdTime1 = new LocalTime(22,00);
		LocalTime thirdTime2 = new LocalTime(06,00);
		
		if (timeNow.isAfter(firstTime1) && timeNow.isBefore(firstTime2)) {	//Shift 1
			idShift = 1;
		} else if (timeNow.isAfter(secondTime1) && timeNow.isBefore(secondTime2)) { //Shift 2
			idShift = 2;
		} else if (timeNow.isAfter(thirdTime1) && timeNow.isBefore(thirdTime2)) { //Shift 3
			idShift = 3;
		}
		return idShift;
	}
	
	public static DateTime startDateFormater(Date startPeriode) {
		DateTime currentDate = new DateTime(startPeriode);
		String currDate = currentDate.toString(simpleDateFormatter(Constant.DATE_FORMAT_EN));
		DateTime startCurrDate = new DateTime(currDate);
		return startCurrDate;
	}
	
	public static DateTime endDateFormater(Date endPeriode) {
		DateTime currentDate = new DateTime(endPeriode);
		String currDate = currentDate.toString(simpleDateFormatter(Constant.DATE_FORMAT_EN));
		DateTime startCurrDate = new DateTime(currDate);
		DateTime endCurrDate = startCurrDate.plusHours(23).plusMinutes(59).plusSeconds(59);
		return endCurrDate;
	}
	
	
}