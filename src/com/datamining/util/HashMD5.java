package com.datamining.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {

	public static String md5(String input) {
        
		StringBuffer md5 = new StringBuffer();
        if(null == input) return null;
         
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
        	md.update(input.getBytes());
        	byte byteData[] = md.digest();
        	//convert the byte to hex format
        	for (int i = 0; i < byteData.length; i++) {
        		md5.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        	}
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return md5.toString();
    }

}
