package ru.job4j.area;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* TriangleTest class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 17.01.2017
*/
public class TriangleTest {

	/**
	* Making object Triangle.
	* @param a first point of this triangle
	* @param a second point of this triangle
	* @param a third point of this triangle
	*/
	private Triangle trOne = new Triangle(new Point(-2, 0), new Point(2, -5), new Point(3, 3))

	/**
	* Cheking value of this triangle area.
	*/
	private final double chekS = 6.4;

	/**
	* whenDoAreaMethodThenCalculatesAreaOfTriangle calculates area of this triangle.
	*/
	public void whenDoAreaMethodThenCalculatesAreaOfTriangle() {
		double result = this.trOne.area();
		assertThat(chekS, is(closeTo(result, 0.1)));
	}
}