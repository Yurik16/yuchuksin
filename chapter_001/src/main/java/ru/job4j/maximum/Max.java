package ru.job4j.maximum;

/**
* Max class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 18.01.2017
*/
public class Max {

	/**
	* maxFromTwo method compare two variables and takes maximum.
	* @param first first of two compared variables
	* @param second second of two compared variables
	*/
	public maxFromTwo(int first, int second) {
		int resultMax = 0;
		if (first > second) {
			resultMax = first;
		} else				{
			resultMax = second;
		}
		return resultMax;
	}

	/**
	* maxFromTree method compare tree variables and takes maximum.
	* @param first first of tree compared variables
	* @param second second of tree compared variables
	* @param third of tree compared variables
	*/
	public maxFromThree(int first, int second, int third) {
		int maxFthree = maxFromTwo(first, second);
		maxFthree = maxFromTwo(maxFthree, third);
		return maxFthree;
	}
}