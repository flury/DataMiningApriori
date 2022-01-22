package com.datamining.util;

public class PropertyUtil {

	public static String photoType(int photoTypeCode) {
		String photoTypeName = "";
		switch (photoTypeCode) {
		case 11:
			photoTypeName = "Design Interior";
			break;
		case 12:
			photoTypeName = "Design Tampak Depan";
			break;
		case 13:
			photoTypeName = "Rumah Minimalis";
			break;
		}
		return photoTypeName;
	}
	
	public static String provinsi(int provinsiCode) {
		String provinsiName = "";
		switch (provinsiCode) {
		case 11:
			provinsiName = "BANTEN";
			break;
		case 12:
			provinsiName = "JAKARTA UTARA";
			break;
		case 13:
			provinsiName = "JAKARTA TIMUR";
			break;
		case 14:
			provinsiName = "JAKARTA BARAT";
			break;
		case 15:
			provinsiName = "JAKARTA SELATAN";
			break;
		case 16:
			provinsiName = "JAWA BARAT";
			break;
		}
		return provinsiName;
	}
	
	public static String city(int cityCode) {
		String cityName = "";
		switch (cityCode) {
		case 11:
			cityName = "BOGOR";
			break;
		case 12:
			cityName = "DEPOK";
			break;
		case 13:
			cityName = "TANGERANG";
			break;
		case 14:
			cityName = "TANGERANG SELATAN";
			break;
		case 15:
			cityName = "SERPONG";
			break;
		}
		return cityName;
	}
	
	public static String sertifikatStatus(int statusCode) {
		String statusName = "";
		switch (statusCode) {
		case 11:
			statusName = "SHGB (Sertifikat Hak Guna Bangun)";
			break;
		case 12:
			statusName = "SHM (Sertifikat Hak Milik)";
			break;
		case 13:
			statusName = "PPJB (Perjanjian Pengikatan Jual Beli)";
			break;
		}
		return statusName;
	}
	
	public static String propertyType(int statusCode) {
		String statusName = "";
		switch (statusCode) {
		// Primary
		case 21:
			statusName = "CLUSTER";
			break;
		case 22:
			statusName = "RESIDENT";
			break;
		case 23:
			statusName = "REGENCY";
			break;
		case 24:
			statusName = "PERUMAHAN";
			break;
		// Secondary
		case 25:
			statusName = "HOUSE";
			break;
		case 26:
			statusName = "APARTMENT";
			break;
		case 27:
			statusName = "SHOP_HOUSE";
			break;
		case 28:
			statusName = "KONDOMINIUM";
			break;
		case 29:
			statusName = "LAND";
			break;
		case 30:
			statusName = "VILLA";
			break;
		}
		return statusName;
	}
	
}
