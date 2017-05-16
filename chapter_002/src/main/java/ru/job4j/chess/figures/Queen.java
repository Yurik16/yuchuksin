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

    @Override
    public Cell[] way(Cell dist) {
        Cell temp = new Cell(this.getFigurePosition().getX(),this.getFigurePosition().getY());
        Bishop bishop = new Bishop("bishop", temp,true);
        Rook rook = new Rook("rook", temp, true);
        if(this.getFigurePosition().getX() == dist.getX() || this.getFigurePosition().getY() == dist.getY()) {
            return bishop.way(dist);
        } else {
            return rook.way(dist);
        }
    }

    @Override
    public boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        boolean result;
        Cell temp = new Cell(this.getFigurePosition().getX(),this.getFigurePosition().getY());
        Bishop bishop = new Bishop("bishop", temp,true);
        Rook rook = new Rook("rook", temp, true);
        try {
            result = bishop.isCorrectWay(cell);
        }
        catch (ImpossibleMoveException ime) {
            result = rook.isCorrectWay(cell);
        }
            return result;
    }
}
