package ru.job4j.array;

/**
* Rotate class.
* @author Yury Chuksin (chuksin.yury@gmail.ru)
* @since 24.01.2017
*/
public class Rotate {

	/**
	* arrayRotate method that flip the array.
	* @param array any one-dimensional array
	* @return array flipped array
	*/
	public int[] arrayRotate(int[] array) {
		int tmp = 0;
		for (int i = 0; i < (array.length / 2); i++) {
			tmp = array[(array.length - 1) - i];
			array[(array.length - 1) - i] = array[i];
			array[i] = tmp;
		}
		return array;
	}
}