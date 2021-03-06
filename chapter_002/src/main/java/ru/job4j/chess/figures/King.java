package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 16.05.2017.
 */
public class King extends AbstractFigure {

    /**
     * Constructor of King.
     *
     * @param name     name of the figure
     * @param position position of the figure
     * @param isWhite  color of the figure
     */
    public King(String name, Cell position, boolean isWhite) {
        super(name, position, isWhite);
    }

    /**
     * Calculates path that figure must pass.
     *
     * @param dist destination point.
     * @return cells array
     */
    @Override
    public Cell[] way(Cell dist) {
        return new Cell[]{dist};
    }

    /**
     * Checking is the destination point correct.
     *
     * @param cell destination point
     * @return boolean
     * @throws ImpossibleMoveException wrong destination point
     */
    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        if ((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
            if ((Math.abs(this.getFigurePosition().getX() - cell.getX()) < 2)
                    && (Math.abs(this.getFigurePosition().getY() - cell.getY()) < 2)) {
                return true;
            }
        } else {
            throw new ImpossibleMoveException("Destination cell can`t be touched.");
        }
        return false;
    }
}
