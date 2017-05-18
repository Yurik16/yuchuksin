package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class Cell {

    /**
     * Position x of Cell at Board.
     */
    private final int x;

    /**
     * Position y of Cell at Board.
     */
    private final int y;

    /**
     * Constructor for Cell.
     *
     * @param x ordinate
     * @param y abscissa
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    /**
     * Getter for ordinate.
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for abscissa.
     *
     * @return y
     */
    public int getY() {
        return y;
    }
}
