package ru.job4j.maximum;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* MaxTest class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 18.01.2017
*/
public class MaxTest {
	/**
	* maximum value of maximum from two variables.
	*/
	private final int mTest = 10;

	/**
	* Making new empty object Max.
	* @see Max
	*/
	public Max max = new Max();

	/**
	* WhenDoMaxFromTwoThenSearchMaximum checks is this method returns maximum from two variables.
	*/
	@Test
	public void WhenDoMaxFromTwoThenSearchMaximum() {
		assertThat(this.mTest, is(max.maxFromTwo(10, 5));
	}
}