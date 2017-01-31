package ru.job4j.array;

/**
* SubOrigin class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 29.01.2017
*/
public class SubOrigin {

	/**
	* isItSub method find substring in bigger string.
	* @param origin big string
	* @param sub substring
	* @return result
	*/
	public boolean contains(String origin, String sub) {
		char[] originArray = origin.toCharArray();
		char[] subArray = sub.toCharArray();
		int count = subArray.length - 1;
		for (int i = 0; i < originArray.length - subArray.length; i++) {
			if (originArray[i] == (subArray[0])) {
				for (int j = 1; j < subArray.length; j++) {
					if (subArray[j] == (originArray[i + j])) {
						count--;
					} else {
						break;
					}
				}
			}
			if (count == 0) {
				break;
			}
			count = subArray.length - 1;
		}
		boolean result = (count == 0) ? true : false;
		return result;
	}
}