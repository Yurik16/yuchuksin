package ru.job4j.array;

import java.util.Arrays;

/**
* Dublicat class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 26.01.2017
*/
public class Dublicat {

	/**
	* delDublicat method delete dublicats from String array.
	* @param array array with dublicats
	* @return result
	*/
	public String[] delDublicat(String[] array) {
		String tmp;
		int counter = 0;
		for (int i = 0; i < array.length - counter; i++) {
			// find dublicats of array[i]
			for (int j = i + 1; j < array.length - counter; j++) {
				if (array[i].equals(array[j])) {
					// pushing dublicats to the end of array
					for (int k = j; k < array.length - 1; k++) {
						tmp = array[k];
						array[k] = array[k + 1];
						array[k + 1] = tmp;
					}
					// couter for cutting loop and result array
					counter++;
					j--;
				}
			}
		}
		String[] result = Arrays.copyOf(array, (array.length - counter));
		return result;
	}
}