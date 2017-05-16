package ru.job4j.chess.figures;


import org.junit.Test;
import ru.job4j.chess.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 16.05.2017.
 */
public class QueenTest  {

    private final Cell cell = new Cell(5, 5);
    private final Queen figure = new Queen("figure", cell, true);
    private final Cell dest = new Cell(5, 1);
    private final Cell[] result = new Cell[]{new Cell(5, 4), new Cell(5, 3), new Cell(5, 2), new Cell(5, 1)};

    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(figure.way(dest)));
    }

    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(figure.isCorrectWay(dest)));
    }
}
