package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

	// Test.
	// @author Yury Chuksin (chuksin.yury@gmail.com)
	// @versiot $Id@
	// @sinse 06.01.2017

public class HelloWorldTest {
	// Test add.
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutStream out = new ByteArrayOutStream();
		System.setOut(new PrintStream(out));
		HelloWorld.main(nuul);
		assertThat(out.toString(),is(String.format("Hello World\r\n"));		
					
	}
}