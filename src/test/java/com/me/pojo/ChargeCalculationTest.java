package com.me.pojo;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.me.pojo.ChargeCalculation;

public class ChargeCalculationTest {

	@Test
	public void testChargeCalculation1() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(1970,1,1), 1, 100.00);
		Assert.assertEquals("Test 1 failed...", 100.00, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation2() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(1970,1,1), 15, 100.00);
		Assert.assertEquals("Test 2 failed...", 45.16, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation3() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(1970,1,1), 31, 100.00);
		Assert.assertEquals("Test 3 failed...", 96.77, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation4() {
		// Leap Year Tests
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(2004,2,1), 1, 100.00);
		Assert.assertEquals("Test 4 failed...", 100.00, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation5() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(2004,2,1), 15, 100.00);
		Assert.assertEquals("Test 5 failed...", 45.16, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation6() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(2004,2,1), 31, 100.00);
		Assert.assertEquals("Test 6 failed...", 96.55, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation7() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(2004,2,29), 1, 100.00);
		Assert.assertEquals("Test 7 failed...", 3.45, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation8() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(2004,2,29), 15, 100.00);
		Assert.assertEquals("Test 8 failed...", 51.72, testVal, 0.001);
	}
	
	@Test
	public void testChargeCalculation9() {
		double testVal = ChargeCalculation.chargeCalculation(new LocalDate(2004,2,29), 31, 100.00);
		Assert.assertEquals("Test 9 failed...", 100.00, testVal, 0.001);		
	}

	@Test
	public void testRound1() {
		double testVal = ChargeCalculation.round(0.666676, 2);
		Assert.assertEquals("Test 9 failed...", 0.67, testVal, 0.001);
	}

	@Test
	public void testRound2() {
		double testVal = ChargeCalculation.round(0.666676, 3);
		Assert.assertEquals("Test 9 failed...", 0.667, testVal, 0.0001);
	}
	
	@Test
	public void testRound3() {
		double testVal = ChargeCalculation.round(0.666646, 4);
		Assert.assertEquals("Test 9 failed...", 0.6666, testVal, 0.0001);
	}
}
