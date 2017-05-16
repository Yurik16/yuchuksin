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
public class BishopTest  {

    private final Cell cell = new Cell(4, 4);
    private final Bishop figure = new Bishop("figure", cell, true);
    private final Cell dest = new Cell(1, 7);
    private final Cell[] result = new Cell[]{new Cell(3, 5), new Cell(2, 6), new Cell(1, 7)};

    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(figure.way(dest)));
    }

    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(figure.isCorrectWay(dest)));
    }
}