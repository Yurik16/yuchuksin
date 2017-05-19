package ru.job4j.chess.figures;

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
     *
     * @param name name of figure
     * @param position cell
     * @param isWhite boolean
     */
    AbstractFigure(String name, Cell position, boolean isWhite) {
        this.name = name;
        this.position = position;
        this.isWhite = isWhite;
    }

    /**
     * way Abstract method.
     *
     * @param dist destination point.
     * @return array of Cells
     */
    public abstract Cell[] way(Cell dist);

    /**
     * Calculates path that figure must pass.
     *
     * @param cell destination point
     * @return cell array
     * @throws ImpossibleMoveException my exception
     */
    public abstract boolean isCorrectWay(Cell cell) throws ImpossibleMoveException;

    /**
     * Getter position.
     *
     * @return cell
     */
    public Cell getFigurePosition() {
        return this.position;
    }

    /**
     * Getter for color of figure.
     *
     * @return boolean
     */
    boolean getFigureColor() {
        return isWhite;
    }

    /**
     * Setter for figure position.
     *
     * @param position cell
     */
    public void setFigurePosition(Cell position) {
        this.position = position;
    }

    /**
     * Moving figure on right.
     *
     * @param cell position of moving figure
     * @return cell
     */
    public Cell oneStepRight(Cell cell) {
        return new Cell(cell.getX() + 1, cell.getY());
    }

    /**
     * Moving figure on left.
     *
     * @param cell position of moving figure
     * @return cell
     */
    public  Cell oneStepLeft(Cell cell) {
        return new Cell(cell.getX() - 1, cell.getY());
    }

    /**
     * Moving figure up.
     *
     * @param cell position of moving figure
     * @return cell
     */
    public Cell oneStepUp(Cell cell) {
        return new Cell(cell.getX(), cell.getY() + 1);
    }

    /**
     * Moving figure down.
     *
     * @param cell position of moving figure
     * @return cell
     */
    public  Cell oneStepDown(Cell cell) {
        return new Cell(cell.getX(), cell.getY() - 1);
    }
}
