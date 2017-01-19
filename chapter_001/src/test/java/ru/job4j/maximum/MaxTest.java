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
	private Max max = new Max();

	/**
	* WhenDoMaxFromTwoThenSearchMaximum checks is this method returns maximum from two variables.
	*/
	@Test
	public void whenDoMaxFromTwoThenSearchMaximum() {
		assertThat(this.mTest, is(this.max.maxFromTwo(10, 5)));
	}

	/**
	* WhenDoMaxFromTwoThenSearchMaximum checks is this method returns maximum from two variables.
	*/
	@Test
	public void whenDoMaxFromThreeThenSearchMaximum() {
		
		assertThat(this.mTest, is(this.max.maxFromThree(1, 10, 5)));
	}
}