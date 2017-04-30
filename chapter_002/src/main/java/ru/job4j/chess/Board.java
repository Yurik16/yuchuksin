package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class Board {
    private AbstractFigure[] figures;

    public Board(AbstractFigure[] figures) {
        this.figures = figures;
    }

    public boolean move(Cell source, Cell dist) throws ImposiblMoveException, FigureNotFoundException {
        try {

        }
        catch (ImposiblMoveException ime) {

        }
        return true;
    }
}
