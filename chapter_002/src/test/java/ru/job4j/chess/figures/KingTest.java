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

    /**
     * Position for figure.
     */
    private final Cell cell = new Cell(5, 1);

    /**
     * New figure.
     */
    private final King figure = new King("figure", cell, true);

    /**
     * Destination cell.
     */
    private final Cell dest = new Cell(4, 1);

    /**
     * Expecting result - path from figure position to destination cell.
     */
    private final Cell[] result = new Cell[]{new Cell(4, 1)};

    /**
     * Compares two path array.
     */
    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(figure.way(dest)));
    }

    /**
     * Compares is it the wright destination cell.
     */
    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(figure.isCorrectWay(dest)));
    }
}