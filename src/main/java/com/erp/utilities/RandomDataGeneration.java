package com.erp.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGeneration {
	
	public static String generationRandomNumber()
	{
		return RandomStringUtils.randomAlphabetic(4) + "/24-25"; // Random Stack Number
	}
	
	public static String generateRandomEmail() {
        return RandomStringUtils.randomAlphabetic(5) + "@example.com";  // Random email
    }

}
