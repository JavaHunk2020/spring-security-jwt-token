package com.cubic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OWO {
	
	public static void main(String[] args) {
		String date = "20-May-22";
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy",Locale.US);
		  //convert String to LocalDate
		  LocalDate localDate = LocalDate.parse(date, formatter);
		  System.out.println(localDate);
	}

}
