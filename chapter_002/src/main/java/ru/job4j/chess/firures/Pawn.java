package ru.job4j.chess.firures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 05.05.2017.
 */
public class Pawn extends AbstractFigure {


    /**
     * Constructor of Pawn.
     *
     * @param name name of the figure
     * @param position position of the figure
     * @param isWhite color of the figure
     */
    public Pawn(String name, Cell position, boolean isWhite) {
        super(name, position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {

        Cell[] result = {dist};
        return result;
    }

    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        if(this.getFigureColor()) {
            if(this.getFigurePosition().getX() == cell.getX() && ((this.getFigurePosition().getY() + 1) == cell.getY()) &&
                    (0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
                return true;
            }
        } else {
            if(this.getFigurePosition().getX() == cell.getX() && ((this.getFigurePosition().getY() - 1) == cell.getY())) {
                return true;
            }
        }
        throw new ImpossibleMoveException("Destination cell can`t be touched.");
    }
}
