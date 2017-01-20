package ru.job4j.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* FactorialTest class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 19.01.2017
*/
public class FactorialTest {

	/**
	* ChekRes knowing result of factorial.
	*/
	private final int chekRes = 720;

	/**
	* FactorialTest making new empty object Factorial.
	* @see Factorial
	*/
	private Factorial factorialTest = new Factorial();

	/**
	* WhenDoFctrlThenGetFactorial cheks is this method calculates factorial.
	*/
	@Test
	public void whenDoFctrlThenGetFactorial() {
		assertThat(this.chekRes, is(this.factorialTest.fctrl(6)));
	}
}