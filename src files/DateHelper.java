package com.rohit.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateHelper {

	public static List<String> listOfDates() {
		int n=7;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, n); // n is the number of days upto which to be calculated
		Date futureDate = calendar.getTime();
		List<String> listDates = returnListOfDatesBetweenTwoDates(new Date() , futureDate);
		
		return listDates;
		

	}


	public static List<String> returnListOfDatesBetweenTwoDates(java.util.Date fromDate, java.util.Date toDate) 
	{
		List<String> listOfDates = new ArrayList();
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(fromDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(toDate);
		while (startCal.getTimeInMillis() < endCal.getTimeInMillis())
		{
			java.util.Date date = startCal.getTime();
			listOfDates.add(new SimpleDateFormat("yyyy-MM-dd").format(date).trim());
			startCal.add(Calendar.DATE, 1);
		}
return listOfDates;
}
	
	

}
