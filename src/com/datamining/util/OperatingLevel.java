package com.datamining.util;

public class OperatingLevel {
	
	public static Integer getOperatingLevel(String departmentCode) {
		Integer operatingLevel = 0;
		
		if (departmentCode.equals("20")) {
			operatingLevel = 18;
		} else if (departmentCode.equals("21")) {
			operatingLevel = 17;
		} else if (departmentCode.equals("22")) {
			operatingLevel = 16;
		} else if (departmentCode.equals("23")) {
			operatingLevel = 15;
		} else if (departmentCode.equals("24")) {
			operatingLevel = 14;
		}
		
		return operatingLevel;
	}
	
	public static String getDepartementCode(Integer operatingLevel) {
		String departementCode = "";
		
		if (operatingLevel == 18) {
			departementCode = "20";
		} else if (operatingLevel == 17) {
			departementCode = "21";
		} else if (operatingLevel == 16) {
			departementCode = "22";
		} else if (operatingLevel == 15) {
			departementCode = "23";
		} else if (operatingLevel == 14) {
			departementCode = "24";
		}
		
		return departementCode;
	}

}
