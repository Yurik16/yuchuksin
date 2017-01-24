package ru.job4j.piramid;

/**
* Piramid class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 21.01.2017
*/
public class Piramid {

	/**
	* buildPiramid method prints piramid in pseudographic.
	* @param h hight of piramid
	* @return bricksLine.toString() pseudographic
	*/
	public String buildPiramid(int h) {
		StringBuilder bricksLine = new StringBuilder();
		String sr = System.getProperty("line.separator");
			for (int i = 0; i < h; i++) {
				for (int j = 1; j <= h * 2 - 1; j++) {
					if (j == (h - i) || j == (h + i) || j == h || i == h - 1) {
						bricksLine.append("^");
					}	else {
						bricksLine.append(" ");
					}
				}
			bricksLine.append(sr);
	}
	return bricksLine.toString();
	}
}