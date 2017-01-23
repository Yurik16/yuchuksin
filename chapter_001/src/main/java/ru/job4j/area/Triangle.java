package ru.job4j.area;

/**
* Triangle class making triangle with three points.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 17.01.2017
*/


public class Triangle {
	/**
	* First point of triangle.
	*/
	private Point a;

	/**
	* Second point of triangle.
	*/
	private Point b;

	/**
	* Third point of triangle.
	*/
	private Point c;

	/**
	* Constructor for creating new object Triangle with tree points.
	* @param a First point of triangle
	* @param b Second point of triangle
	* @param c Third point of triangle
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	* Calculate area between tree points.
	* @return areaS
	*/
	public double area() {
		/**
		* Cheking is from this three points are triangle.
		*/
		if (((a.getX() == b.getX()) && (b.getX() == c.getX())) || ((a.getY() == b.getY()) && (b.getY() == c.getY()))) {
			System.out.println("This is not triangle");
		}

		/**
		* Calculate perimetor of Triangle.
		*/
		double perim = (a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a)) / 2;

		/**
		* Calculate area of Triangle.
		*/
		double areaS = Math.sqrt(perim * (perim - a.distanceTo(b)) * (perim - b.distanceTo(c)) * (perim - c.distanceTo(a)));

		return areaS;
	}
}