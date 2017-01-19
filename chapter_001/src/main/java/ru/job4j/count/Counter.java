package ru.job4j.count;

/**
* Counter class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 19.01.2017
*/
public class Counter {

	/**
	* Add method calculates sum of even numbers in selected range.
	* @param start start of range
	* @param finish end of range
	* @return sum sum of even numbers in selected range
	*/
	public int add(int start, int finish) {
		int sum = o;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}
}