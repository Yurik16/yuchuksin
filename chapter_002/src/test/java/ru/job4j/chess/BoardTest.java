package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.AbstractFigure;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.King;
import ru.job4j.chess.figures.Knight;
import ru.job4j.chess.figures.Pawn;
import ru.job4j.chess.figures.Queen;
import ru.job4j.chess.figures.Rook;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 03.05.2017.
 */
public class BoardTest {

    /**
     * Figures array  at this board.
     */
    private final AbstractFigure[] figures = {
            new Pawn("P 1 w", new Cell(5, 2), true),
            new Pawn("P 1 b", new Cell(4, 7), false),
            new Rook("R 1 b", new Cell(3, 2), false),
            new Knight("N 1 w", new Cell(2, 1), true),
            new Bishop("B 1 b", new Cell(5, 1), false),
            new Queen("Q b", new Cell(6, 1), false),
            new King("K b", new Cell(5, 5), false)
    };

    /**
     * whenMoveWhitePawnE2E4ThenPawnGo moving white Pawn on two cell up - first move.
     */
    @Test
    public void whenMovePawnE2E4ThenPawnGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(5, 2), new Cell(5, 4));
        assertThat(result, is(true));
    }

    /**
     * whenMoveWhitePawnE2E3ThenPawnGo moving white Pawn on one cell up.
     */
    @Test
    public void whenMovePawnE2E3ThenPawnGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(5, 2), new Cell(5, 3));
        assertThat(result, is(true));
    }

    /**
     * whenMoveWhitePawnD7D5ThenPawnGo moving black Pawn on two cell down - first move.
     */
    @Test
    public void whenMovePawnD7D5ThenPawnGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(4, 7), new Cell(4, 5));
        assertThat(result, is(true));
    }

    /**
     * whenMoveWhitePawnD7D6ThenPawnGo moving black Pawn on one cell down.
     */
    @Test
    public void whenMovePawnD7D6ThenPawnGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(4, 7), new Cell(4, 6));
        assertThat(result, is(true));
    }

    /**
     * whenMoveRookC2A2ThenRookGo moving black Rook.
     */
    @Test
    public void whenMoveRookC2A2ThenRookGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(3, 2), new Cell(1, 2));
        assertThat(result, is(true));
    }

    /**
     * whenMoveKnightB1A3ThenKnightGo moving white Knight.
     */
    @Test
    public void whenMoveKnightB1A3ThenKnightGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(2, 1), new Cell(1, 3));
        assertThat(result, is(true));
    }

    /**
     * whenMoveBishopE1A5ThenBishopGo moving black Bishop.
     */
    @Test
    public void whenMoveBishopE1A5ThenBishopGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(5, 1), new Cell(1, 5));
        assertThat(result, is(true));
    }

    /**
     * whenMoveQueenD1A6ThenQueenGo moving black Queen.
     */
    @Test
    public void whenMoveQueenD1A6ThenQueenGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(6, 1), new Cell(8, 3));
        assertThat(result, is(true));
    }

    /**
     * whenMoveQueenD1D6ThenQueenGo moving black Queen.
     */
    @Test
    public void whenMoveQueenD1D6ThenQueenGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(6, 1), new Cell(6, 6));
        assertThat(result, is(true));
    }

    /**
     * whenMoveQueenD1D6ThenQueenGo moving black King.
     */
    @Test
    public void whenMoveKingE8D7ThenKingGo() {

        Board board = new Board(this.figures);
        boolean result = board.move(new Cell(5, 5), new Cell(6, 4));
        assertThat(result, is(true));
    }
}