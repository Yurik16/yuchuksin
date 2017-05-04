package ru.job4j.chess;

import java.util.Arrays;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.05.2017.
 */
public class Bishop extends AbstractFigure {
    /**
     * Constructor of Bishop.
     *
     * @param name
     * @param position
     */
    public Bishop(String name, Cell position) {
        super(name, position);
    }


    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] result = new Cell[7];
        int count = 0;
            if(this.getFigurePosition().getX() < dist.getX() && this.getFigurePosition().getY() < dist.getY()) {
                for (int i = 0; i < dist.getX() - this.getFigurePosition().getX(); i++) {
                    result[count++] = this.oneStepUp(this.oneStepRight(this.getFigurePosition()));
                }
            }
            if(this.getFigurePosition().getX() < dist.getX() && this.getFigurePosition().getY() > dist.getY()) {
                for (int i = 0; i < dist.getX() - this.getFigurePosition().getX(); i++) {
                    result[count++] = this.oneStepDown(this.oneStepRight(this.getFigurePosition()));
                }
            }
            if(this.getFigurePosition().getX() > dist.getX() && this.getFigurePosition().getY() > dist.getY()) {
                for (int i = 0; i < this.getFigurePosition().getX() - dist.getX(); i++) {
                    result[count++] = this.oneStepDown(this.oneStepLeft(this.getFigurePosition()));
                }
            }
            if(this.getFigurePosition().getX() > dist.getX() && this.getFigurePosition().getY() < dist.getY()) {
                for (int i = 0; i < this.getFigurePosition().getX() - dist.getX(); i++) {
                    result[count++] = this.oneStepUp(this.oneStepLeft(this.getFigurePosition()));
                }
            }
        return Arrays.copyOf(result, count);
    }

    @Override
    boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        if((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
            if ((this.getFigurePosition().getX() + this.getFigurePosition().getY() == cell.getX() + cell.getY()) ||
                    this.getFigurePosition().getX() - this.getFigurePosition().getY() == cell.getX() - cell.getY()) {
                return true;
            }
        }
        return false;
    }
}
