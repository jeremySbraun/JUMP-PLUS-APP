package com.dollarsbank.utility;

public class ColorsUtility {

	
	 
	 private final static String RED_COLOR = "\033[31m" ;
	 private final static String BLUE_COLOR = "\033[34m";
	 private final static String GREEN_COLOR = "\033[32m";
	 private final static String YELLOW_COLOR = "\033[33m";
	 private static final String WHITE_COLOR = "\u001B[37m";
	 private final static String ENDING_SEQUENCE = "\0";
	 public static final String ANSI_RESET = "\u001B[0m";
	
	 
	 
	 private enum COLOR_SEQUENCE{
		 RED, BLUE, GREEN, YELLOW, WHITE
	 }
	 
	 
	 public static String applyColor(String sequence, String colorRequested, boolean continueThis) {
		
		 
		 COLOR_SEQUENCE color = COLOR_SEQUENCE.valueOf(colorRequested);
		 
		 String coloString= "";
		 
		 
		 switch(color) {
		 case RED: coloString = RED_COLOR + sequence;
			 break;
			 
		 case BLUE: coloString = BLUE_COLOR + sequence;
			 break;
		 case GREEN: coloString = GREEN_COLOR + sequence;
			 break;
		 case YELLOW: coloString = YELLOW_COLOR + sequence;
			 break;
			 
		 case WHITE: coloString = WHITE_COLOR + sequence;
			 break;
		 default:
			 return sequence;
		 }
		 
		 if(continueThis) {
			 coloString = coloString + ENDING_SEQUENCE;
		 }
		 
		 else {
		 
		 coloString = coloString + ANSI_RESET;
		 
		 }
		
		 return coloString;
		 
	 }
	 
	 
}
