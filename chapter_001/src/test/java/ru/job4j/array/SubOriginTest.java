package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* SubOriginTest class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 30.01.2017
*/
public class SubOriginTest {

	/**
	* Creating new empty object SubOrigin.
	*/
	private SubOrigin someObj = new SubOrigin();

	/**
	* biglString this string contains substring.
	*/
	private final String biglString = "qwrpareqgparasonwrtg";

	/**
	* subString this string is substring of biglString.
	*/
	private final String subString = "parason";

	/**
	* whenDoContainsThenFindSubstring cheking contains method, can it find substring in bigger string.
	*/
	@Test
	public void whenDoContainsThenFindSubstring() {
		assertThat(this.someObj.contains(this.biglString, this.subString), is(true));
	}
}