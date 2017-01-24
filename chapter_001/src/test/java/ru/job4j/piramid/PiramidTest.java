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
	private String string1 = "    ^    ";

	/**
	* string2 2nd test string.
	*/
	private String string2 = "   ^^^   ";

	/**
	* string3 3rd test string.
	*/
	private String string3 = "  ^ ^ ^  ";

	/**
	* string4 4th test string.
	*/
	private String string4 = " ^  ^  ^ ";

	/**
	* string5 5th test string.
	*/
	private String string5 = "^^^^^^^^^";

	/**
	* sr line separator.
	*/
	private String sr = System.getProperty("line.separator");

	/**
	* stringTest testing result string.
	*/
	StringBuilder stringTest = new StringBuilder();
	stringTest.append(this.string1, this.sr, this.string2, this.sr, this.string3, this.sr, this.string4, this.sr, this.string5);

	/**
	* Making empty object Piramid.
	*/
	private Piramid piramid = new Piramid();

	/**
	* WhenDoBuildPiramidThenPrintsPiramid cheks is that method prints piramid in pseudographic.
	*/
	@Test
	public void whenDoBuildPiramidThenPrintsPiramid() {
		assertThat(stringTest.toString(), is(this.piramid.buildPiramid(5)));
	}
}