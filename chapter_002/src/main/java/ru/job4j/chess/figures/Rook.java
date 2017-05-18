package ru.job4j.chess.figures;

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

    /**
     * Constructor of Rook.
     *
     * @param name name of the figure
     * @param position position of the figure
     * @param isWhite color of the figure
     */

    public Rook(String name, Cell position, boolean isWhite) {
        super(name, position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) {
        Cell origin = this.getFigurePosition();
        Cell[] result = new Cell[7];
        int count = 0;
        int deltaX = Math.abs(this.getFigurePosition().getX() - dist.getX());
        int deltaY = Math.abs(this.getFigurePosition().getY() - dist.getY());

        if(this.getFigurePosition().getX() == dist.getX()) {
            for (int i = 0; i < deltaY; i++) {
                if(this.getFigurePosition().getY() < dist.getY()) {
                    result[count++] = this.oneStepUp(this.getFigurePosition());
                    this.setFigurePosition(result[i]);
                } else {
                    result[count++] = this.oneStepDown(this.getFigurePosition());
                    this.setFigurePosition(result[i]);
                }
            }
        }
        if(this.getFigurePosition().getY() == dist.getY()) {
            for (int i = 0; i < deltaX; i++) {
                if(this.getFigurePosition().getX() < dist.getX()) {
                    result[count++] = this.oneStepRight(this.getFigurePosition());
                    this.setFigurePosition(result[i]);
                } else {
                    result[count++] = this.oneStepLeft(this.getFigurePosition());
                    this.setFigurePosition(result[i]);
                }
            }
        }
        this.setFigurePosition(origin);
        return Arrays.copyOf(result, count);
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
