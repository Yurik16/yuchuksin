package ru.job4j.chess;

import org.junit.Test;

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
    public void move() throws Exception {
        AbstractFigure[] figures = {
                new Bishop("name", new Cell(1, 1))
        };

        Board board = new Board(figures);
        boolean resalt = board.move(new Cell(1,1), new Cell(2, 2));
        assertThat(resalt, is(true));
    }

}