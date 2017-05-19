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
public class PawnTest {

    /**
     * Position for figure.
     */
    private final Cell cell = new Cell(5, 7);

    /**
     * New figure.
     */
    private final Pawn pawn = new Pawn("Pawn", cell, false);

    /**
     * Destination cell.
     */
    private final Cell dest = new Cell(5, 5);
    //private final Cell[] result = new Cell[]{new Cell(5, 6)};

    /**
     * Expecting result - path from figure position to destination cell.
     */
    private final Cell[] result = new Cell[]{new Cell(5, 6), new Cell(5, 5)};

    /**
     * Compares two path array.
     */
    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(pawn.way(dest)));
    }

    /**
     * Compares is it the wright destination cell.
     */
    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(pawn.isCorrectWay(dest)));
    }
}