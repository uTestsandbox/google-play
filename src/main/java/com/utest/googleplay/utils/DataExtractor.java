package com.utest.googleplay.utils;

public class DataExtractor {

	public static int getStarCountFromText(String startCountText) {
		int startCount = Integer.parseInt(startCountText.substring(1, startCountText.length()-1));
		return startCount;
	}

	
	public static double getStarsFromText(String starText) {
		String[] startTextArr = starText.split(" ");
		return Double.parseDouble(startTextArr[2]);
	}
	
}
