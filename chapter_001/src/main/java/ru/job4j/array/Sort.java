package ru.job4j.array;

/**
* Sort class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 25.01.2017
*/
public class Sort {

	/**
	* sortArrayUp method that sort array by increase numbers.
	* @param array array that will be sorted
	* @return array
	*/
	public int[] sortArrayUp(int[] array) {
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array.length - 1 - i; k++) {
				if (array[k] > array[k + 1]) {
					tmp = array[k];
					array[k] = array[k + 1];
					array[k + 1] = tmp;
				}
			}
		}
		return array;
	}
}