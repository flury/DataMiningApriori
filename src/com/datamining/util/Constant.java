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
	
	public static final String LOG_INFO = "INFO";
	public static final String LOG_DEBUG = "DEBUG";
	public static final String LOG_ERROR = "ERROR";
	
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
