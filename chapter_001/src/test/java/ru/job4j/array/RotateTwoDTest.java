package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* RotateTwoDTest class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 26.01.2017
*/
public class RotateTwoDTest {

	/**
	* array1 create new empty class RotateTwoD.
	*/
	private RotateTwoD array1 = new RotateTwoD();

	/**
	* twoDarray this is two-dimensional array get in taste method.
	*/
	private final int[][] twoDarray = {
		{1, 2, 3, 4},
		{1, 2, 3, 4},
		{1, 2, 3, 4},
		{1, 2, 3, 4}
		};

	/**
	* resaltArray resalt array for this test.
	*/
	private final int[][] resaltArray = {
		{1, 1, 1, 1},
		{2, 2, 2, 2},
		{3, 3, 3, 3},
		{4, 4, 4, 4}
		};

	/**
	* whenDoRotateTwoDarrayThenTwistArray method that compares two array.
	*/
	@Test
	public void whenDoRotateTwoDarrayThenTwistArray() {
		assertThat(this.resaltArray, is(this.array1.rotateTwoDarray(this.twoDarray)));
	}
}