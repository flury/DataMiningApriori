package com.datamining.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class PasswordEncryptor {

	public static String encrypt(String seed, String message) {
		
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		
		encryptor.setPassword(seed);
		
		return encryptor.encrypt(message);
	}
}
