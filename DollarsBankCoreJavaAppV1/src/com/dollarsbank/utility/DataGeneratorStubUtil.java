package com.dollarsbank.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataGeneratorStubUtil {

	private static final String PHONEREGEX_STRING = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
	private static final String PASSWORDREGEX_STRING = "(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z]).{8,}";
	
	public static boolean phoneRegex(String contactString) {
		Pattern phonePattern = Pattern.compile(PHONEREGEX_STRING);
		Matcher matcher = phonePattern.matcher(contactString);
		System.out.println("Phone Matches:" + matcher.matches());
		return matcher.matches();
	}
	
	public static boolean passwordRegex(String passwordString) {
		Pattern passwordPattern = Pattern.compile(PASSWORDREGEX_STRING);
		Matcher matcher = passwordPattern.matcher(passwordString);
		return matcher.matches();
	}
	
	
	public static double checkForDouble(String checkString) {
		
		try {
		double value =Double.parseDouble(checkString);
		
		if(value < 0) {
			System.out.print(ColorsUtility.applyColor("\nInvalid input! A valid positive number must be inputed.", "RED", false));
			return -1;
		}
		return value;
		
		}catch(Exception e){
			System.out.print(ColorsUtility.applyColor("\nInvalid input! A valid positive number must be inputed.", "RED", false));
			return -1;
		}
		
	}
	
	public static String formatDouble(Double number) {
		String format = String.format("$%.2f", number);
		return format;
	}
	
}
