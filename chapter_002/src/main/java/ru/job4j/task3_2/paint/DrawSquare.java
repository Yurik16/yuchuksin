package ru.job4j.task3_2.paint;

/**
 * Created by User on 15.03.2017.
 */
public class DrawSquare implements Strategy {

    /**
     * draw drawing Square.
     *
     * @param size height of square
     * @return bricksLine pseudo-graphic
     */
    @Override
    public String draw(int size) {
        StringBuilder bricksLine = new StringBuilder();
        String sp = System.getProperty("line.separator");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size * 2 - 2; j++) {
                if (i == 0 || j == 0 || i == size - 1 || j == size * 2 - 2) {
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
