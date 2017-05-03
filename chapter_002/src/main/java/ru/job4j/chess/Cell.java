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
    final private String[] position = new String[2];

    private AbstractFigure figure;

    /**
     * Default constructor for Cell.
     * @param position coordinate
     */
    public Cell(String[] position) {
        this.position[0] = position[0];
        this.position[1] = position[1];
        this.figure = null;
    }

    /**
     * Constructor for Cell with figure on it.
     * @param position coordinate
     */
    public Cell(String[] position, AbstractFigure figure) {
        this.position[0] = position[0];
        this.position[1] = position[1];
        this.figure = figure;
    }

    /**
     * Getter Figure from Cell.
     */
    public AbstractFigure getFigure() {
        return this.figure;
    }

    /**
     * Getter literal coordinate from Cell.
     */
    public String getPositionX() {
        return this.position[0];
    }

    /**
     * Getter numerical coordinate from Cell.
     */
    public String getPositionY() {
        return this.position[1];
    }
}
