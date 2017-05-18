package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

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
     * @param name     name of the figure
     * @param position position of the figure
     * @param isWhite  color of the figure
     */
    public Bishop(String name, Cell position, boolean isWhite) {
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

        Cell origin = this.getFigurePosition(); //origin original position of figure
        Cell[] result = new Cell[7];
        int count = 0;
        int deltaX = Math.abs(this.getFigurePosition().getX() - dist.getX());

        if (this.getFigurePosition().getX() < dist.getX() && this.getFigurePosition().getY() < dist.getY()) {
            for (int i = 0; i < deltaX; i++) {
                result[count++] = this.oneStepUp(this.oneStepRight(this.getFigurePosition()));
                this.setFigurePosition(result[i]); // setting new position of figure
            }
        }
        if (this.getFigurePosition().getX() < dist.getX() && this.getFigurePosition().getY() > dist.getY()) {
            for (int i = 0; i < deltaX; i++) {
                result[count++] = this.oneStepDown(this.oneStepRight(this.getFigurePosition()));
                this.setFigurePosition(result[i]); // setting new position of figure
            }
        }
        if (this.getFigurePosition().getX() > dist.getX() && this.getFigurePosition().getY() > dist.getY()) {
            for (int i = 0; i < deltaX; i++) {
                result[count++] = this.oneStepDown(this.oneStepLeft(this.getFigurePosition()));
                this.setFigurePosition(result[i]); // setting new position of figure
            }
        }
        if (this.getFigurePosition().getX() > dist.getX() && this.getFigurePosition().getY() < dist.getY()) {
            for (int i = 0; i < deltaX; i++) {
                result[count++] = this.oneStepUp(this.oneStepLeft(this.getFigurePosition()));
                this.setFigurePosition(result[i]); // setting new position of figure
            }
        }
        this.setFigurePosition(origin); // get back original position to moving figure
        return Arrays.copyOf(result, count);
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
        if (((this.getFigurePosition().getX() + this.getFigurePosition().getY() == cell.getX() + cell.getY()) ||
                this.getFigurePosition().getX() - this.getFigurePosition().getY() == cell.getX() - cell.getY()) &&
                (0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
            return true;
        } else throw new ImpossibleMoveException("Destination cell can`t be touched.");
    }
}
