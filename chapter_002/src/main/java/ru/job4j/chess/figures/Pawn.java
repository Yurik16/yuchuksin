package ru.job4j.chess.figures;

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
     * @param name     name of the figure
     * @param position position of the figure
     * @param isWhite  color of the figure
     */
    public Pawn(String name, Cell position, boolean isWhite) {
        super(name, position, isWhite);
    }

    /**
     * Calculates path that figure must pass.
     *
     * @param dist destination point.
     * @return cells array
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell origin = this.getFigurePosition();
        Cell[] result = new Cell[2];
         if (Math.abs((this.getFigurePosition().getY() - dist.getY())) == 2) {
            for (int i = 0; i < 2; i++) {
                if (this.getFigureColor()) {
                    result[i] = this.oneStepUp(this.getFigurePosition());
                    this.setFigurePosition(result[i]);
                } else {
                    result[i] = this.oneStepDown(this.getFigurePosition());
                    this.setFigurePosition(result[i]);
                }
            }
            this.setFigurePosition(origin);
            return result;
        } else {
             return new Cell[]{dist};
         }
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
        if (this.getFigureColor() && (this.getFigurePosition().getY() < cell.getY()) && (this.getFigurePosition().getY() == 2)) {
            if (movePawn(cell, 2)) {
                return true;
            }
        }
        if (this.getFigureColor() && (this.getFigurePosition().getY() < cell.getY())) {
            if (movePawn(cell, 1)) {
                return true;
            }
        }
        if (!this.getFigureColor() && (this.getFigurePosition().getY() > cell.getY()) && (this.getFigurePosition().getY() == 7)) {
            if (movePawn(cell, 2)) {
                return true;
            }
        }
        if (!this.getFigureColor() && (this.getFigurePosition().getY() > cell.getY())) {
            if (movePawn(cell, 1)) {
                return true;
            }
        }
        throw new ImpossibleMoveException("Destination cell can`t be touched.");
    }

    /**
     * Return boolean depends on "first move" of Pawn.
     *
     * @param cell destination cell of moving figure
     * @param step 1 or 2 cells to move
     * @return boolean
     */
    private boolean movePawn(Cell cell, int step) {
        if (this.getFigurePosition().getX() == cell.getX()) {
            if (Math.abs(this.getFigurePosition().getY() - cell.getY()) <= step) {
                if ((0 < cell.getX() && cell.getX() < 9) && (0 < cell.getY() && cell.getY() < 9)) {
                    return true;
                }
            }
        }
        return false;
    }
}
