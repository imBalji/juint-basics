package com.learn;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) @DisplayName(value = "When running someMath")
class SomeMathTest {
	
	SomeMath someMath;
	
	//	The Below method doesn't need to be static if it were PER_CLASS
	@BeforeAll
	void pre_inti() {
		System.out.println("Before all method");
	}
	
	@BeforeEach
	void init() {
		someMath = new SomeMath();
	}
	
	@Nested @DisplayName(value = "Testing add method")
	class addTests {
		
		@Test @DisplayName(value = "positive numbers")
		void testAdd() {
			assertEquals(2, someMath.add(1, 1), "should return positive sum");
		}
		
		@Test @DisplayName(value = "add negative numbers")
		void testAdd2() {
			assertEquals(-2, someMath.add(-1, -1), "should return negative sum");
		}
	}
	
	@Test
	void testMultiply() {
//		assertEquals(2, someMath.multiply(1, 1), "The add method");
		assertAll(
				() -> assertEquals(4, someMath.multiply(2, 2)), 
				() -> assertEquals(0, someMath.multiply(0, 2)), 
				() -> assertEquals(-2, someMath.multiply(2, -1)) 
				);
	}
	
	@RepeatedTest(3)
	void testDivide(RepetitionInfo repetitionInfo) {
		System.out.println(repetitionInfo.getCurrentRepetition());
		assertThrows(ArithmeticException.class, () -> someMath.divide(2, 0), "Divide by Zero");
	}
	
	@Test @DisplayName(value = "Testing Circle Radius")
	void testCircleRadius() {
		assertEquals(314.1592653589793, someMath.computeCircleArea(10), "Should return correct circle area");
	}
	
	@Test @Disabled @DisplayName(value = "Testing Disabled")
	void  testDisabled() {
		fail("This test should be disabled");
	}
}