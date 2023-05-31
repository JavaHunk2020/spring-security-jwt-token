package com.cubic;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;

public class Mama {
	
	public static void main(String[] args) {
		try {
			Mac.getInstance("HmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
