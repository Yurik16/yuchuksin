package ru.job4j.chess.firures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

import java.util.Arrays;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 05.05.2017.
 */
public class Rook extends AbstractFigure {

    public Rook(String name, Cell position, boolean white) {
        super(name, position, white);
    }

    @Override
    public Cell[] way(Cell dist) {
        Cell[] result = new Cell[7];
        int cout = 0;
        if(this.getFigurePosition().getX() == dist.getX()) {
            for (int i = 0; i < Math.abs(this.getFigurePosition().getY() - dist.getY()); i++) {
                if(this.getFigurePosition().getY() < dist.getY()) {
                    result[cout++] = this.oneStepUp(this.getFigurePosition());
                } else {
                    result[cout++] = this.oneStepDown(this.getFigurePosition());
                }
            }
        }
        if(this.getFigurePosition().getY() == dist.getY()) {
            for (int i = 0; i < Math.abs(this.getFigurePosition().getY() - dist.getY()); i++) {
                if(this.getFigurePosition().getX() < dist.getX()) {
                    result[cout++] = this.oneStepRight(this.getFigurePosition());
                } else {
                    result[cout++] = this.oneStepLeft(this.getFigurePosition());
                }
            }
        }
        return Arrays.copyOf(result, cout);
    }

    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        if ((this.getFigurePosition().getX() == cell.getX() ||
                this.getFigurePosition().getY() == cell.getY()) &&
                (0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
            return true;
        } else throw new ImpossibleMoveException("Destination cell can`t be touched.");
    }
}
