package com.test.triton;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.MutableDateTime;

public class LamaWoolService {

	public boolean isWoolTooOldToSell(DateTime shearDate) {

		 MutableDateTime now = new MutableDateTime(); // Joda mutable DateTime instance	initialized to the current system date/time
		 
		 //Variable created to receive the numbers of the days between January 15, 2013 and today.
		 Integer daysToAddToCompareWithShearDate = getDaysToAddToCompareWithShearDate(now);
		 
		 //testing if the result is over 0 before turn it in negative number
		 if(daysToAddToCompareWithShearDate > 0){
			daysToAddToCompareWithShearDate = -daysToAddToCompareWithShearDate;
		 }
		 
		 now.addDays(daysToAddToCompareWithShearDate);
		 		 
		 return now.isBefore(shearDate);
	}
	
	/**
	 * Method to provide the numbers of the days that have passed 
	 * since the day before January 15, 2013
	 * 
	 * @param initDate
	 * 
	 * @return 
	 */
	protected static Integer getDaysToAddToCompareWithShearDate(MutableDateTime initDate){
		
		//day before January 15, 2013
		DateTime dateJanuaryFourteenJanuary2013 = new DateTime(2013, 01, 14, 00, 00);
		
		// numbers of the days that have passed 
		Integer dateToReturn = Days.daysBetween(dateJanuaryFourteenJanuary2013 , initDate).getDays();
		 
		//testing if the result is not null
		if(dateToReturn == null){
			dateToReturn = new Integer(0);
		}
		
		return dateToReturn;
	}
}
