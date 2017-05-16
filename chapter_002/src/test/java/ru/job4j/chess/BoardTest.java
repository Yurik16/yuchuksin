package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firures.AbstractFigure;
import ru.job4j.chess.firures.Queen;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 03.05.2017.
 */
public class BoardTest {
    @Test
    public void move() {
        AbstractFigure[] figures = {
                new Queen("name", new Cell(3, 1), true),
               // new Bishop("second", new Cell(4, 2), false)
        };

        Board board = new Board(figures);

            boolean result = board.move(new Cell(3,1), new Cell(6, 1));
            assertThat(result, is(true));

    }

}