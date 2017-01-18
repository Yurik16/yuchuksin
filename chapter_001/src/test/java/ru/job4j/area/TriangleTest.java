package ru.job4j.area;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static java.lang.Math.*;

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
	private Triangle trOne = new Triangle(a, b, c) {
		trOne.a = new Point(-2, 0);
		trOne.b = new Point(2, -5);
		trOne.c = new Point(3, 3);
	}	

	/**
	* Cheking value of this triangle area.
	*/
	private final chekS = 6.4;

	/**
	* whenDoAreaMethodWhenCalculatesAreaOfTriangle calculates area of this triangle.
	*/
	public void whenDoAreaMethodWhenCalculatesAreaOfTriangle() {
		double result = this.trOne.area();
		assertThat(chekS, is(closeTo(result, 0.1)));
	}