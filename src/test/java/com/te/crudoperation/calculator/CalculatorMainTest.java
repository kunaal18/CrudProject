package com.te.crudoperation.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorMainTest {
	private Calculator c = new Calculator();

//	@Test
//	void contextLoads() {
//
//	}

	@Test
	@Disabled
	void testSum() {
		int expectedResult = 17;
		int actualResult = c.doSum(12, 3, 2);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testProduct() {
		int expectedResult = 6;
		int actualResult = c.doProduct(3, 2);
		assertThat(actualResult).isEqualTo(expectedResult);

	}

	@Test
	void testCompareNums() {
		Boolean actualResult = c.compareTwoNums(3, 3);
		assertThat(actualResult).isTrue();

	}

}
