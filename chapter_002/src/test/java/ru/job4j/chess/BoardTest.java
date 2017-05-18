package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.AbstractFigure;
import ru.job4j.chess.figures.Bishop;

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
                new Bishop("name", new Cell(4, 4), true),
                new Bishop("2nd", new Cell(3, 2), false),
                new Bishop("3rd", new Cell(3, 1), true),
                new Bishop("4th", new Cell(5, 1), false)
        };

        Board board = new Board(figures);

            boolean result = board.move(new Cell(4,4), new Cell(1, 7));
            assertThat(result, is(true));

    }

}