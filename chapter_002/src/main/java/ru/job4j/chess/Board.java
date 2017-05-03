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
        try {
            for(AbstractFigure x : this.figures) {
                if(x.getFigurePosition().equals(source)) {
                    movingFigure = x;
                }
            }
        }
        catch(FigureNotFoundException ffe) {
            System.out.println(String.format("%s%n%s", ffe.getMessage(), "Cell is empty."));
            return false;
        }
        if(!movingFigure.isCorrectWay(source)) {
            throw new ImpossibleMoveException("Illegal path for this figure.");
        }
            Cell[] resaltCellArray = movingFigure.way(dist);
            for(AbstractFigure x : this.figures) {
                for(Cell cellFromWay : resaltCellArray) {
                    if(x.getFigurePosition().equals(cellFromWay)){
                        throw new ImpossibleMoveException("There is another figure on the way.");
                    }
                }
            }
        return true;
    }
}
