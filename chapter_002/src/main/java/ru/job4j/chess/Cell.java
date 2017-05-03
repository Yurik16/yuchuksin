package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class Cell {

    /**
     * Position of Cell at Board.
     */
    final private int X;
    final private int Y;

    public Cell(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (X != cell.X) return false;
        return Y == cell.Y;
    }

    @Override
    public int hashCode() {
        int result = X;
        result = 31 * result + Y;
        return result;
    }
}
