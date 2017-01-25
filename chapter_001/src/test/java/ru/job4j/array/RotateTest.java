package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* RotateTest class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 24.01.2017
*/
public class RotateTest {
	/**
	* exampleRotate creating new empty class Rotate.
	*/
	private Rotate exampleRotate = new Rotate();

	/**
	* arrayForward this is array get in taste method.
	*/
	private final int[] arrayForward = {1, 3, 5, 7, 12, 33};

	/**
	* arrayBackward resalting array for this test.
	*/
	private final int[] arrayBackward = {33, 12, 7, 5, 3, 1};

	/**
	* whenDoArrayRotateThenArrayRotate method that compare two array.
	*/
	@Test
	public void whenDoArrayRotateThenArrayFlip() {
		assertThat(this.arrayBackward, is(exampleRotate.arrayRotate(this.arrayForward)));
	}
}