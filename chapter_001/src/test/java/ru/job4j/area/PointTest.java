package ru.job4j.area;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

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
	private final Point startP = new Point(-4.5, 2);

	/**
	* Making new object - end point.
	* @see Point
	*/
	private final Point endP = new Point(4, -3.5);

	/**
	* Knowing ordinate of endP.
	*/
	private final double endPx = 4;

	/**
	* Knowing abscissa of endP.
	*/
	private final double endPy = -3.5;

	/**
	* whenDistanceToThenGetChekD method calculates distance between two points.
	*/
	@Test
	public void whenDistanceToThenGetChekD() {
		double dc = this.startP.distanceTo(this.endP);
		assertThat(chekD, is(closeTo(dc, 0.01)));
	}

	/**
	* whenGetXthanReturnXcoordinat test method that returns ordinate.
	*/
	@Test
	public void whenGetXthanReturnXcoordinat() {
		assertThat(this.endPx, is(this.endP.getX()));
	}

	/**
	* whenGetYthanReturnAbscissa test method that returns abscissa.
	*/
	@Test
	public void whenGetYthanReturnAbscissa() {
		assertThat(this.endPy, is(this.endP.getY()));
	}
}