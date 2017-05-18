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

    private final Cell cell = new Cell(5, 3);
    private final Pawn pawn = new Pawn("Pawn", cell, true);
    private final Cell dest = new Cell(5, 4);
    private final Cell[] result = new Cell[]{new Cell(5, 4)};
    //private final Cell[] result = new Cell[]{new Cell(5, 3), new Cell(5, 4)};

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