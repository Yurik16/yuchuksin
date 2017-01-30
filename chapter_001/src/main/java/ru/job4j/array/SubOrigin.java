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
		int count = 0;
		for (int i = 0; i < originArray.length - subArray.length; i++) {
			if (originArray[i] == (subArray[0])) {
				for (int j = 0; j < subArray.length - 1; j++) {
					if (subArray[j + 1] == (originArray[i + 1])) {
						count++;
					} else {
						count = 0;
					}
				}
			}
			if (count == subArray.length) {
				break;
			}
		}
		boolean result = count < 1 ? true : false;
		return result;
	}
}