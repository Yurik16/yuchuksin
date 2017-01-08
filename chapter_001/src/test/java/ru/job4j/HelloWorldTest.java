package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class Test.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @version $Id@
* @since 06.01.2017
*/

public class HelloWorldTest {
	/**
	* Test add.
	*/
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		HelloWorld.main(null);
		assertThat(out.toString(), is("Hello World\r\n"));
	}
}