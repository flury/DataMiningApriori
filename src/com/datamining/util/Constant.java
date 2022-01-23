package com.datamining.util;

import java.math.BigDecimal;

public class Constant {
	
	public static final String DATE_FORMAT_COMPLETE = "d MMMM yyyy";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String DATE_FORMAT_MIN = "ddMMyyyy";
	public static final String DATE_FORMAT_EN = "yyyy-MM-dd";
	public static final String DATE_FORMAT_MONTH = "d MMM yyyy";
	public static final String MONTH_FORMAT = "MM";
	public static final String TIME_FORMAT = "hh:mm";
	public static final String DATE_TIME_FORMAT = "dd-MM-yyyy hh:mm";
	public static final String MONTH_YEAR_FORMAT = "MMMM yyyy";
	
	public static final String 	CURRENCY_FORMAT = "#,###";
	public static final int 	DEFAULT_PAGE_SIZE = 50;
	public static final String 	REGEXP = "^[0-9]+$";
	public static final String 	REGEXP_REMOVE_DOT_CHAR = "[^a-zA-Z0-9]+";
	public static final String 	STR_EMPTY = "";
	
	/* 1024 MB = 1073741824 Bytes */
	public static final Integer MAX_UPLOAD_SIZE = 1073741824;
	public static final Integer MAX_UPLOAD_SIZE_20MB = 20;
	
	public static final String SESS_USER_ID = "SessUserID";
	public static final String SESS_USER_NAME = "SessUserName";
	public static final String SESS_USER_TYPE_ID = "SessUserTypeID";
	public static final String SESS_USER_TYPE_NAME = "SessUserTypeName";
	public static final String SESS_LOGIN_DEFAULT = "SessLoginDefault";
	
	public static final Integer SYSADM 				= 11;
	public static final Integer ACCOUNT_MANAGEMENT 	= 31;
	public static final Integer PARAMETER_SYSTEM 	= 62;
	
	public static final Integer AGENT_STAFF 		= 61;
	public static final Integer AGENT_KOORDINATOR 	= 60;
	
	public static final Integer EMAIL_STATUS_NOT_SENT = 1;
	public static final Integer EMAIL_STATUS_SENT = 2;
	
	public static final String NOT_DELIVERY = "draft";
	public static final String DELIVERY = "sent";
	
	public static final String PAYMENT_NOT_PAID = "not paid";
	public static final String PAYMENT_PAID = "paid";
	
	public static final String NORMAL_INQUIRY_LOG = "NORMAL_INQUIRY_LOG";
	public static final String NORMAL_ALERT_LOG = "NORMAL_ALERT_LOG";
	public static final String NORMAL_ALERT_LOG_CSV = "NORMAL_ALERT_LOG_CSV";
	public static final String NORMAL_ALERT_LOG_ZIP = "NORMAL_ALERT_LOG_ZIP";
	
	public static final String LOG_INFO = "INFO";
	public static final String LOG_DEBUG = "DEBUG";
	public static final String LOG_ERROR = "ERROR";
	
	public static final String STATUS_WAITING = "waiting";
	public static final String STATUS_APPROVE = "approve";
	public static final String STATUS_REJECT = "reject";
	
	public static final String UPLOAD_STATUS_WAITING = "WAITING";
	public static final String UPLOAD_STATUS_PROCESS = "PROCESS";
	public static final String UPLOAD_STATUS_FAILED = "FAILED";
	public static final String UPLOAD_STATUS_DONE = "DONE";
	
	public static final String SYSTEM_GENERATE = "SYSTEM_GENERATE";
	
	public static final String PROGRESS_NEW = "NEW";
	public static final String PROGRESS_BOOKING = "BOOKING";
	public static final String PROGRESS_SOLD = "SOLD";
	public static final String PROGRESS_CANCELED = "CANCELED";
	
	public static final BigDecimal COMMISSION_FEE = new BigDecimal(2.5);
	
	public static final String PROPERTY_STATUS_INDENT = "INDENT";
	public static final String PROPERTY_STATUS_READY = "READY";
	
	public static final String FLOW_DRAFT = "DRAFT";
	public static final String FLOW_APPLY = "APPLY";
	public static final String FLOW_APPROVED = "APPROVED";
	public static final String FLOW_SENDBACK = "SENDBACK";
	public static final String FLOW_CANCELED = "CANCELLED";
	
	public static final String PUBLISHED = "PUBLISHED";
	public static final String NOT_PUBLISH = "NOT_PUBLISH";
	
	public static final String SEVERTIY_NORMAL = "NORMAL";
	public static final String SEVERTIY_MEDIUM = "MEDIUM";
	public static final String SEVERTIY_HIGH = "HIGH";
	
	public static final String PROPERTY_PRIMARY 		= "PRIMARY";
	public static final String PROPERTY_SECONDARY 		= "SECONDARY";
	
	public static final String PROPERTY_SELL_PRIMARY 		= "SELL_PRIMARY";
	public static final String PROPERTY_SELL_SECONDARY 		= "SELL_SECONDARY";
	public static final String PROPERTY_SELL_APARTMENT_RUKO = "SELL_APARTMENT_RUKO";
	public static final String PROPERTY_SELL_LAND_PLOTS 	= "SELL_LAND_PLOTS";
	
	public static final String PROPERTY_RENT_HOUSE			= "RENT_HOUSE";
	public static final String PROPERTY_RENT_RUKO 			= "RENT_RUKO";
	public static final String PROPERTY_RENT_APARTEMENT 	= "RENT_APARTEMENT";
	
	public static final String PROPERTY_SELL = "JUAL";
	public static final String PROPERTY_RENT = "SEWA";
	
	// Advertising Type
	public static final String ADV_TYPE_NORMAL = "NORMAL";
	public static final String ADV_TYPE_HOT_LISTING = "HOT_LISTING";
	public static final String ADV_TYPE_POPULAR_PROJECT = "POPULAR_PROJECT";
	public static final String ADV_TYPE_EXCLUSIVE_LISTING = "EXCLUSIVE_LISTING";
	
	public static final String ANGKATAN_13 = "13";
	public static final String ANGKATAN_14 = "14";
	public static final String ANGKATAN_15 = "15";
	public static final String ANGKATAN_16 = "16";
	public static final String JK_PRIA = "Pria";
	public static final String JK_WANITA = "Wanita";
	public static final String PM_BEASISWA = "BEASISWA";
	public static final String PM_NILAIRAPOR_DOWN_7 = "Nilai Rapor < 7.00";
	public static final String PM_NILAIRAPOR_UP_7 = "Nilai Rapor >= 7.00";
	public static final String NS_SMA = "SMA";
	public static final String NS_SMK = "SMK";
	public static final String KOTA_SEKOLAH_JAKARTA = "JAKARTA";
	public static final String KOTA_SEKOLAH_TANGERANG = "TANGERANG";
	public static final String KOTA_SEKOLAH_LUAR_KOTA = "LUAR KOTA";
	public static final String JURUSAN_TEKNIK_INFORMATIKA = "TEKNIK INFORMATIKA";
	public static final String JURUSAN_NON_TEKNIK_INFORMATIKA = "NON TEKNIK INFORMATIKA";
	public static final BigDecimal IPK = new BigDecimal(3.50);
	public static final BigDecimal LAMA_STUDI = new BigDecimal(4.00);
	public static final String PRODI_TEKNIK_INFORMATIKA = "TEKNIK INFORMATIKA";
	public static final String PRODI_SISTEM_INFORMASI = "SISTEM INFORMASI";
	
}
