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

    private final Cell cell = new Cell(5, 7);
    private final Pawn pawn = new Pawn("Pawn", cell, false);
    private final Cell dest = new Cell(5, 6);
    private final Cell[] result = new Cell[]{new Cell(5, 6)};
    //private final Cell[] result = new Cell[]{new Cell(5, 6), new Cell(5, 5)};

    /**
     * WhenDoWayMethodThenGetArrayOfCells compares two array, is the destination cell for Pawn is correct.
     */
    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(pawn.way(dest)));
    }

    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(pawn.isCorrectWay(dest)));
    }
}