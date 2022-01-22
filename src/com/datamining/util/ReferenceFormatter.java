package com.datamining.util;

public class ReferenceFormatter {
	
	public static String getCompleteItemCode(String deptCode, String itemCode) {
		String result = deptCode+itemCode+"001";
		return result;
	}
	
}
