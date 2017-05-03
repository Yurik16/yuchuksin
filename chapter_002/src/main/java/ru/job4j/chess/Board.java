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


    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, FigureNotFoundException {

        AbstractFigure movingFigure = null;

            for(AbstractFigure x : this.figures) {
                if(x.getFigurePosition().equals(source)) {
                    movingFigure = x;
                }
            }
        try {

        }
        catch(FigureNotFoundException ffe) {
            System.out.println(String.format("%s%n%s", ffe.getMessage(), "Cell is empty."));
            return false;
        }
        if(!movingFigure.isCorrectWay(source)) {
            throw new ImpossibleMoveException("Illegal  path for this figure.");
        }
        try {
            Cell[] resaltCellArray = movingFigure.way(dist);
        }
        catch(ImpossibleMoveException fwe) {
            System.out.println(String.format("%s%n%s", fwe.getMessage(), "There is another figure on the way."));
            return false;
        }
        return true;
    }
}
