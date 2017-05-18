package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 16.05.2017.
 */
public class Queen extends AbstractFigure {

    /**
     * Constructor of Queen.
     *
     * @param name name of the figure
     * @param position position of the figure
     * @param isWhite color of the figure
     */

    public Queen(String name, Cell position, boolean isWhite) {
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

        Cell temp = new Cell(this.getFigurePosition().getX(),this.getFigurePosition().getY());
        Bishop bishop = new Bishop("bishop", temp,true);
        Rook rook = new Rook("rook", temp, true);

        try {
            rook.isCorrectWay(dist);
            return rook.way(dist);
        }
        catch (ImpossibleMoveException ime) {
            return bishop.way(dist);
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

        Cell temp = new Cell(this.getFigurePosition().getX(),this.getFigurePosition().getY());
        Bishop bishop = new Bishop("bishop", temp,true);
        Rook rook = new Rook("rook", temp, true);

        try {
            rook.isCorrectWay(cell);
            return true;
        }
        catch(ImpossibleMoveException ime) {
            bishop.isCorrectWay(cell);
            return  true;
        }
    }
}
