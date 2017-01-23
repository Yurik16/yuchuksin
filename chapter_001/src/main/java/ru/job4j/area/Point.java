package ru.job4j.area;

/**
* Point class making point with coordinats.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 17.01.2017
*/
public class Point {

	/**
	* Abscissa of this point.
	*/
	private double x;

	/**
	* Ordinate of this point.
	*/
	private double y;

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
	* xxx.
	* @return x
	*/
	public double getX() {
		return this.x;
	}

	/**
	* yyy.
	* @return y
	*/
	public double getY() {
		return this.y;
	}

	/**
	* Calculate distance to needful point.
	* @param point to that point calculates distance
	* @return dist distance between two points
	*/
	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
	}
}