package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* DublicatTest class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 27.01.2017
*/
public class DublicatTest {

	/**
	* dubl creating new empty class Dublicat.
	*/
	private Dublicat dubl = new Dublicat();

	/**
	* exampl array with duplicats for testing.
	*/
	private final String[] exampl = {"1", "k", "5", "6", "7", "2", "3", "1", "9", "2", "9", "k", "4", "0", "3", "15", "16", "17"};

	/**
	* chekArray resalting array for this test.
	*/
	private final String[] chekArray = {"1", "k", "5", "6", "7", "2", "3", "9", "4", "0", "15", "16", "17"};

	/**
	* whenDoDelDublicatThenDublicatsDelete method that compare two array is there the same.
	*/
	@Test
	public void whenDoDelDublicatThenDublicatsDelete() {
		assertThat(this.chekArray, is(this.dubl.delDublicat(this.exampl)));
	}
}