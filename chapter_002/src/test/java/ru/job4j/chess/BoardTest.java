package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 03.05.2017.
 */
public class BoardTest {

    final private AbstractFigure[] figures = {
            new Pawn("P 1 w", new Cell(5, 2), true),
            new Pawn("P 1 b", new Cell(4, 7), false),
            new Rook("R 1 b", new Cell(3, 2), false),
            new Knight("N 1 w", new Cell(3, 1), true),
            new Bishop("B 1 b", new Cell(5, 1), false),
            new Queen("Q b", new Cell(5, 1), false),
            new King("K b", new Cell(5, 1), false)
    };

    /**
     * whenMoveWhitePawnE2E4ThenPawnGo moving white Pawn on two cell up - first move.
     */
    @Test
    public void whenMovePawnE2E4ThenPawnGo() {

        Board board = new Board(figures);
        boolean result = board.move(new Cell(5, 2), new Cell(5, 4));
        assertThat(result, is(true));

    }

    /**
     * whenMoveWhitePawnE2E3ThenPawnGo moving white Pawn on one cell up.
     */
    @Test
    public void whenMovePawnE2E3ThenPawnGo() {

        Board board = new Board(figures);
        boolean result = board.move(new Cell(5, 2), new Cell(5, 3));
        assertThat(result, is(true));

    }

    /**
     * whenMoveWhitePawnD7D5ThenPawnGo moving white Pawn on two cell down - first move.
     */
    @Test
    public void whenMovePawnD7D5ThenPawnGo() {

        Board board = new Board(figures);
        boolean result = board.move(new Cell(4, 7), new Cell(4, 5));
        assertThat(result, is(true));

    }

    /**
     * whenMoveWhitePawnD7D6ThenPawnGo moving white Pawn on one cell down.
     */
    @Test
    public void whenMovePawnD7D6ThenPawnGo() {

        Board board = new Board(figures);
        boolean result = board.move(new Cell(4, 7), new Cell(4, 6));
        assertThat(result, is(true));

    }
}