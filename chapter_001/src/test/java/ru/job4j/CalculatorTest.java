package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
	* Test add.
	*/
	@Test
	double private testArg1 = 6;
	double private tesrArg2 = 3;
	
	Calculator calc = new Calculator;
	
	/**
	* whenDoAddMethodThanGetAddition method compare result of additional
	* @params args
	*/
	public void whenDoAddMethodThanGetAddition() {
		double testRes = this.testArg1 + this.tesrArg2;
		double testValues = calc.add(this.testArg1, this.tesrArg2);
		assertThat(testRes, is(testValues));
	}
	
}