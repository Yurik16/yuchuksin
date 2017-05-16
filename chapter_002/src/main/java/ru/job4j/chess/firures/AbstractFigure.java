package ru.job4j.chess.firures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public abstract class AbstractFigure {

    /**
     * Name of Figure.
     */
    private String name;

    /**
     * Position at Board.
     */
    private Cell position;


    /**
     * Color of figure.
     */
    private boolean isWhite;

    /**
     * Constructor of AbstractFigure.
     */
    public AbstractFigure(String name, Cell position, boolean isWhite) {
        this.position = position;
        this.name = name;
        this.isWhite = isWhite;
    }

    /**
     * way Abstract method.
     *
     * @param dist destination point.
     * @return array of Cells
     */
    public abstract Cell[] way(Cell dist);

    public abstract boolean isCorrectWay(Cell cell) throws ImpossibleMoveException;
    /**
     * Getter position.
     *
     * @return
     */
    public Cell getFigurePosition() {
        return this.position;
    }

    public boolean getFigureColor() {
        return isWhite;
    }

    public void setFigurePosition(Cell position) {
        this.position = position;
    }

    public Cell oneStepRight(Cell cell) {
        return new Cell(cell.getX() + 1, cell.getY());
    }

    public  Cell oneStepLeft(Cell cell) {
        return new Cell(cell.getX() - 1, cell.getY());
    }

    public Cell oneStepUp(Cell cell) {
        return new Cell(cell.getX(), cell.getY() + 1);
    }

    public  Cell oneStepDown(Cell cell) {
        return new Cell(cell.getX(), cell.getY() - 1);
    }
}
