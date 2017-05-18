package ru.job4j.chess;

import ru.job4j.chess.Exceptions.FigureNotFoundException;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;
import ru.job4j.chess.Exceptions.OccupiedWayException;
import ru.job4j.chess.figures.AbstractFigure;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class Board {

    /**
     * Figures array  at this board.
     */
    private AbstractFigure[] figures = new AbstractFigure[32];

    /**
     * Constructor of Board.
     *
     * @param figures all figures at this board
     */
    Board(AbstractFigure[] figures) {
        this.figures = figures;
    }

    /**
     * Two dimension array with 64 cells.
     */
    private Cell[][] board = new Cell[8][8];

    /**
     * Initiate chess board.
     */
    public void initBorad() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                board[i][j] = new Cell(i + 1, j + 1);
            }
        }
    }

    /**
     * Method which moving figure.
     *
     * @param source start cell
     * @param dist destination cell
     * @return boolean
     * @throws ImpossibleMoveException can`t move like that
     * @throws FigureNotFoundException there is no figure at this cell
     * @throws OccupiedWayException another figure on the way
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        AbstractFigure movingFigure = null;

        for (AbstractFigure x : this.figures) {
            if (x.getFigurePosition().equals(source)) {
                movingFigure = x;
            }
        }
        if (movingFigure == null) {
            throw new FigureNotFoundException("There is no any figure at this Cell.");
        }
        if (movingFigure.isCorrectWay(dist)) {

            Cell[] resultCellArray = movingFigure.way(dist);
            for (AbstractFigure x : this.figures) {
                for (Cell cellFromWay : resultCellArray) {
                    if (x.getFigurePosition().equals(cellFromWay)) {
                        throw new OccupiedWayException("There is another figure on this way.");
                    }
                }
            }
            movingFigure.setFigurePosition(dist);
            return true;
        }
        return false;
    }
}
