package com.me.pojo;

import org.joda.time.*;
import org.joda.time.chrono.GregorianChronology;

public class ChargeCalculation {
	public static double chargeCalculation(LocalDate purchaseDate, int billCycleDay, double baseFee) {		
		LocalDate    cycleDateStart;
		LocalDate    cycleDateEnd;
		double rval = 0.0;
		int cycleDays = 1;
		int numDays;
		double dailyRate;
			
		LocalDate endOfMonth = purchaseDate.dayOfMonth().withMaximumValue();
		if(purchaseDate.getDayOfMonth() < billCycleDay) {						
			cycleDateEnd = new LocalDate(purchaseDate.getYear(), purchaseDate.getMonthOfYear(), (billCycleDay < endOfMonth.getDayOfMonth()) ? billCycleDay : endOfMonth.getDayOfMonth());
			cycleDateStart = cycleDateEnd.minusMonths(1);
			if(cycleDateStart.getDayOfMonth() != billCycleDay) {
				if(cycleDateStart.dayOfMonth().withMaximumValue().getDayOfMonth() < billCycleDay) {
					cycleDateStart = cycleDateStart.dayOfMonth().withMaximumValue();
				} else {
					cycleDateStart = cycleDateStart.plusDays(billCycleDay - cycleDateStart.getDayOfMonth());
				}
			}
		} else {
			cycleDateStart = new LocalDate(purchaseDate.getYear(), purchaseDate.getMonthOfYear(), (billCycleDay < endOfMonth.getDayOfMonth()) ? billCycleDay : endOfMonth.getDayOfMonth());
			cycleDateEnd = cycleDateStart.plusMonths(1);						
		}
		
		numDays = Days.daysBetween(purchaseDate, cycleDateEnd).getDays();
		cycleDays = Days.daysBetween(cycleDateStart, cycleDateEnd).getDays();
		if(numDays == 0)
			numDays = cycleDays;
		
		dailyRate = baseFee / ((cycleDays != 0) ? cycleDays : 1);
		
		rval = round((numDays * dailyRate), 2);
		
		return rval;
	}
	
	public static double round(double val, double decimalPlaces)
	{
		double multiple = Math.pow(10.0D, decimalPlaces);
				
		return (Math.round(val * multiple)/multiple);
	}
}
