package ru.job4j.task3_2.paint;

/**
 * Created by User on 15.03.2017.
 */
public class DrawTriangle implements Strategy {

    /**
     * draw drawing Triangle.
     *
     * @param size height of triangle
     * @return bricksLine pseudo-graphic
     */
    @Override
    public String draw(int size) {
        StringBuilder bricksLine = new StringBuilder();
        String sp = System.getProperty("line.separator");
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= size * 2 - 1; j++) {
                if (j == (size - i) || j == (size + i) || i == size - 1) {
                    bricksLine.append("*");
                } else {
                    bricksLine.append(" ");
                }
            }
            bricksLine.append(sp);
        }
        return bricksLine.toString();
    }
}
