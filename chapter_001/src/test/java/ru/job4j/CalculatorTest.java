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
	* @param testArgOne first value for making this test
	*/
	private final double testArgOne = 6;
	/**
	* @param testArgTwo second value for making this test
	*/
	private final double tesrArgTwo = 3;
	/**
	* Making new empty object.
	* @see Calculator
	*/
	private Calculator calc = new Calculator();
	/**
	* Test add.
	*/
	@Test
	/**
	* whenDoAddMethodThanGetAddition method compare result of additional
	*/
	public void whenDoAddMethodThanGetAddition() {
		/**
		* @param testRes correct result of cheking method
		*/
		double testRes = this.testArgOne + this.tesrArgTwo;
		/**
		* @param testValues geting result from cheking method
		*/
		double testValues = this.calc.add(this.testArg1, this.tesrArg2);
		assertThat(testRes, is(testValues));
	}
	/**
	* Test add.
	*/
	@Test
	/**
	* whenDoSubstructMethodThanGetSubstration method compare result of substraction
	*/
	public void whenDoSubstructMethodThanGetSubstration() {
		double testRes = this.testArgOne - this.testArgTwo;
		double testValues = this.calc.add(this.testArgOne, this.tesrArgTwo);
		assertThat(testRes, is(testValues));
	}
	/**
	* Test add.
	*/
	@Test
	/**
	* whenDoDivMethodThanGetSubstration method compare result of division
	*/
	public void whenDoDivMethodThanGetDivision() {
		double testRes = this.testArgOne / this.testArgTwo;
		double testValues = this.calc.add(this.testArgOne, this.tesrArgTwo);
		assertThat(testRes, is(testValues));
	}
	/**
	* Test add.
	*/
	@Test
	/**
	* whenDoMultipleMethodThanGetMultiplication method compare result of multiplication
	*/
	public void whenDoMultipleMethodThanGetMultiplication() {
		double testRes = this.testArgOne * this.testArgTwo;
		double testValues = this.calc.add(this.testArgOne, this.tesrArgTwo);
		assertThat(testRes, is(testValues));
	}
}