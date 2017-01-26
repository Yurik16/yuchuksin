package ru.job4j.array;

/**
* RotateTwoD class.
* @author Yury Chuksin (chiksin.yury@gmail.ru)
* @since 26.01.2017
*/
public class RotateTwoD {

	/**
	* rotateTwoDarray this method rotate two-demensional array.
	* @param array two-demensional array
	* @return resArray
	*/
	public int[][] rotateTwoDarray(int[][] array) {
		int[][] resArray = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array.length; k++) {
				resArray[k][array.length - 1 - i] = array[i][k];
			}
		}
		return resArray;
	}
}