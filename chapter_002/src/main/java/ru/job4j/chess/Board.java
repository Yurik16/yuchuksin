package ru.job4j.chess;

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

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, FigureNotFoundException {

        AbstractFigure movingFigure = null;

        for(AbstractFigure x : this.figures) {
                if(x.getFigurePosition().equals(source)) {
                    movingFigure = x;
                }
                else throw new FigureNotFoundException("There is on any figure at this Cell.");
            }

        if(!movingFigure.isCorrectWay(dist)){
            throw new ImpossibleMoveException("This figure can`t move that way.");
        }
            Cell[] resaltCellArray = movingFigure.way(dist);
            for(AbstractFigure x : this.figures) {
                for(Cell cellFromWay : resaltCellArray) {
                    if(x.getFigurePosition().equals(cellFromWay)){
                        throw new ImpossibleMoveException("There is another figure on this way.");
                    }
                }
            }
        movingFigure.setFigurePosition(dist);
        return true;
    }
}
