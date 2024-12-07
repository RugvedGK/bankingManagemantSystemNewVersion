package com.demo_bank_v2.helper;

import java.util.UUID;

public class Token {

	public static String generateToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}
}
