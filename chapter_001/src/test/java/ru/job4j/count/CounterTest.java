package ru.job4j.count;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* CounterTest class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 19.01.2017
*/
public class CounterTest {

	/**
	* ChekSum total sum of even in tested range.
	*/
	private int chekSum = 432;

	/**
	* Making empty object Counter.
	*/
	private Counter countE = new Counter();

	/**
	* whenDoAddThenCalculateSumOfEven cheks the sum that this method calculate.
	*/
	@Test
	public whenDoAddThenCalculateSumOfEven() {
		assertThat(chekSum, is(this.countE.add(11, 42)));
	}

}