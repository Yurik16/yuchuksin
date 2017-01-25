package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* RotateTest class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 25.01.2017
*/
public class SortTest {

	/**
	* sort creating new empty object Sort.
	*/
	private Sort sort = new Sort();

	/**
	* testArray this is array get in taste method.
	*/
	private final int[] testArray = {7, 4, 2, 8, 3, 6, 1, 0, 5};

	/**
	* compareArray resalting array for this test.
	*/
	private final int[] compareArray = {0, 1, 2, 3, 4, 5, 6, 7, 8};

	/**
	* whenDoSortArrayUpThenSort method compre two array is there the same.
	*/
	@Test
	public void whenDoSortArrayUpThenSort() {
		assertThat(this.compareArray, is(sort.sortArrayUp(this.testArray)));
	}
}