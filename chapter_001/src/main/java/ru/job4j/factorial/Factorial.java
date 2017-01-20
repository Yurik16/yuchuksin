package ru.job4j.factorial;

/**
* Factorial class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 19.01.2017
*/
public class Factorial {

	/**
	* Fctrl method calculates factorial of asked number.
	* @param number asked number
	* @return result
	*/
	public int fctrl(int number) {
		int result = o;
		for (int i = 1; i < number; i++) {
			result = result * (i + 1);
		}
		return result;
	}
}