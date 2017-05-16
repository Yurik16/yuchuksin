package ru.job4j.chess.firures;

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
     * @param name name of the figure
     * @param position position of the figure
     * @param isWhite color of the figure
     */

    public King(String name, Cell position, boolean isWhite) {
        super(name, position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) {
        return new Cell[]{dist};
    }

    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        if((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
            if(((Math.abs(this.getFigurePosition().getX() - cell.getX()) == 1) && (this.getFigurePosition().getY() == cell.getY())) ||
                    (Math.abs(this.getFigurePosition().getY() - cell.getY()) == 1) && (this.getFigurePosition().getX() == cell.getX())) {
                return true;
            } else throw new ImpossibleMoveException("Destination cell can`t be touched by King.");
        } else throw new ImpossibleMoveException("Destination cell can`t be touched.");
    }
}
