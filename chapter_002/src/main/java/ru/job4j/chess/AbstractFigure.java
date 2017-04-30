package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
abstract class AbstractFigure {

    /**
     *
     */
    final Cell position;

    /**
     *
     */
    public AbstractFigure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell dist) throws ImposiblMoveException;
}
