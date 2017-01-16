package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Class CalculatorTest.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @version $Id@
* @since 15.01.2017
*/
public class CalculatorTest {

	/**
	* testArgOne first value for making this test.
	*/
	private final double testArgOne = 6;

	/**
	* testArgTwo second value for making this test.
	*/
	private final double tesrArgTwo = 3;

	/**
	* Making new empty object.
	* @see Calculator
	*/
	private Calculator calc = new Calculator();

	/**
	* whenDoAddMethodThanGetAddition method compare result of additional.
	*/
	@Test
	public void whenDoAddMethodThanGetAddition() {
		double testRes = this.testArgOne + this.tesrArgTwo;
		double testValues = this.calc.add(this.testArg1, this.tesrArg2);
		assertThat(testRes, is(testValues));
	}

	/**
	* whenDoSubstructMethodThanGetSubstration method compare result of substraction.
	*/
	@Test
	public void whenDoSubstructMethodThanGetSubstration() {
		double testRes = this.testArgOne - this.testArgTwo;
		double testValues = this.calc.add(this.testArgOne, this.tesrArgTwo);
		assertThat(testRes, is(testValues));
	}

	/**
	* whenDoDivMethodThanGetSubstration method compare result of division.
	*/
	@Test
	public void whenDoDivMethodThanGetDivision() {
		double testRes = this.testArgOne / this.testArgTwo;
		double testValues = this.calc.add(this.testArgOne, this.tesrArgTwo);
		assertThat(testRes, is(testValues));
	}
	/**
	* whenDoMultipleMethodThanGetMultiplication method compare result of multiplication.
	*/
	@Test
	public void whenDoMultipleMethodThanGetMultiplication() {
		double testRes = this.testArgOne * this.testArgTwo;
		double testValues = this.calc.add(this.testArgOne, this.tesrArgTwo);
		assertThat(testRes, is(testValues));
	}
}