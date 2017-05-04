package ru.job4j.chess;

import ru.job4j.chess.Exceptions.FigureNotFoundException;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;
import ru.job4j.chess.Exceptions.OccupiedWayException;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class Board {

    private AbstractFigure[] figures = new AbstractFigure[32];

    public Board(AbstractFigure[] figures) {
        this.figures = figures;
    }

    public Cell[][] board = new Cell[8][8];

    public void initBorad() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i + 1, j + 1);
            }
        }
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        AbstractFigure movingFigure = null;

        for (AbstractFigure x : this.figures) {
            if (x.getFigurePosition().equals(source)) {
                movingFigure = x;
            } else throw new FigureNotFoundException("There is no any figure at this Cell.");
        }
        movingFigure.isCorrectWay(dist);

        Cell[] resaltCellArray = movingFigure.way(dist);
        for (AbstractFigure x : this.figures) {
            for (Cell cellFromWay : resaltCellArray) {
                if (x.getFigurePosition().equals(cellFromWay)) {
                    throw new OccupiedWayException("There is another figure on this way.");
                }
            }
        }
        movingFigure.setFigurePosition(dist);
        return true;
    }
}
