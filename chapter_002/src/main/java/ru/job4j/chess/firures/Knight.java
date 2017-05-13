package ru.job4j.chess.firures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 13.05.2017.
 */
public class Knight extends AbstractFigure {

    public Knight(String name, Cell position, boolean white) {
        super(name, position, white);
    }

    @Override
    public Cell[] way(Cell dist) {
        Cell[] result = {dist};
        return result;
    }

    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {

        if (((Math.abs(this.getFigurePosition().getX() - cell.getX()) == 1 &&
                Math.abs(this.getFigurePosition().getY() - cell.getY()) == 3) &&
                ((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) ||
                ((Math.abs(this.getFigurePosition().getY() - cell.getY()) == 1 &&
                        Math.abs(this.getFigurePosition().getX() - cell.getX()) == 3) &&
                        ((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9))))) {
            return true;
        } else throw new ImpossibleMoveException("Destination cell can`t be touched.");
    }
}
