package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 13.05.2017.
 */
public class Knight extends AbstractFigure {

    /**
     * Constructor of Knight.
     *
     * @param name     name of the figure
     * @param position position of the figure
     * @param isWhite  color of the figure
     */
    public Knight(String name, Cell position, boolean isWhite) {
        super(name, position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) {
        return new Cell[]{dist};
    }

    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        if ((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
          if (((Math.abs(this.getFigurePosition().getX() - cell.getX()) == 1
                  && (Math.abs(this.getFigurePosition().getY() - cell.getY()) == 2)))
              || ((Math.abs(this.getFigurePosition().getY() - cell.getY()) == 1
                    && Math.abs(this.getFigurePosition().getX() - cell.getX()) == 2)
                    && ((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)))) {
              return true;
          }
        } else {
            throw new ImpossibleMoveException("Destination cell can`t be touched by Knight.");
        }
        return false;
    }
}
