package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 18.05.2017.
 */
public class KingTest {

    private final Cell cell = new Cell(5, 1);
    private final King figure = new King("figure", cell, true);
    private final Cell dest = new Cell(4, 1);
    private final Cell[] result = new Cell[]{ new Cell(4, 1)};

    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(figure.way(dest)));
    }

    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(figure.isCorrectWay(dest)));
    }
}