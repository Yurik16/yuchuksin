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
public class KnightTest  {

    private final Cell cell = new Cell(5, 5);
    private final Knight knight = new Knight("Pawn", cell, true);
    private final Cell dest = new Cell(6, 8);
    private final Cell[] result = new Cell[]{new Cell(6, 8)};

    @Test
    public void whenDoWayMethodThenGetArrayOfCells() {
        assertThat(result, is(knight.way(dest)));
    }

    @Test
    public void whenDoIsCorrectWayThenGetBoolean() {
        assertThat(true, is(knight.isCorrectWay(dest)));
    }
}
