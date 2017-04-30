package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class Cell {

    /**
     * Coordinate X at Board.
     */
    private char abscissa;

    /**
     * Coordinate Y at Board.
     */
    private short ordinate;

    /**
     * Constructor for Cell class.
     * @param abscissa
     * @param ordinate
     */
    public Cell(char abscissa, short ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }
}
