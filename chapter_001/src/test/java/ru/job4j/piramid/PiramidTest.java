package ru.job4j.piramid;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* PiramidTest class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 24.01.2017
*/
public class PiramidTest {

	/**
	* string1 1st test string.
	*/
	private final String string1 = "    ^    ";

	/**
	* string2 2nd test string.
	*/
	private final String string2 = "   ^^^   ";

	/**
	* string3 3rd test string.
	*/
	private final String string3 = "  ^ ^ ^  ";

	/**
	* string4 4th test string.
	*/
	private final String string4 = " ^  ^  ^ ";

	/**
	* string5 5th test string.
	*/
	private final String string5 = "^^^^^^^^^";

	/**
	* sr line separator.
	*/
	private final String sr = System.getProperty("line.separator");

	/**
	* string1 1st test string.
	*/
	private final String stringTest = String.format("%s%s%s%s%s%s%s%s%s%s", string1, sr, string2, sr, string3, sr, string4, sr, string5, sr);

	/**
	* Making empty object Piramid.
	*/
	private Piramid piramid = new Piramid();

	/**
	* WhenDoBuildPiramidThenPrintsPiramid cheks is that method prints piramid in pseudographic.
	*/
	@Test
	public void whenDoBuildPiramidThenPrintsPiramid() {
		assertThat(stringTest, is(this.piramid.buildPiramid(5)));
	}
}