package ru.job4j.area;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static java.lang.Math.*;

/**
* Point class making point with coordinats.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 17.01.2017
*/
public class Point {

	/**
	* Abscissa of this point.
	*/
	public double x;

	/**
	* Ordinate of this point.
	*/
	public double y;

	/**
	* Constructor for creating new object Point.
	* @param x abscissa
	* @param y ordinate
	*/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Calculate distance to needful point.
	* @param point to that point calculates distance
	* @return dist distance between two points
	*/
	public double distanceTo(Point point) {
		double dX = this.x - point.x;
		double dY = this.y - point.y;
		double dist = sqrt(pow(dX, 2) + pow(dY, 2));
		return dist;
	}
}