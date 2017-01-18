package ru.job4j.area;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static java.lang.Math.*;

/**
* Class PointTest.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 17.01.2017
*/
public class PointTest {

	/**
	* Knowing distance between two cheking points.
	*/
	private final double chekD = 10.12;

	/**
	* Making new object - start point.
	* @see Point
	*/
	private Point startP = new Point(-4.5, 2);

	/**
	* Making new object - end point.
	* @see Point
	*/
	private Point endP = new Point(4, -3.5);
	
	/**
	* whenDistanceToWhenGetChekD method calculates distance between two points.
	*/
	@Test
	public void whenDistanceToWhenGetChekD() {
		double dc = this.startP.distanceTo(this.endP);
		assertThat(chekD, is(closeTo(dc, 0.01)));
	}
}