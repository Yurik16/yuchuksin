package ru.job4j.collections.tracker;

import org.junit.Test;
import ru.job4j.task3_2.paint.Context;
import ru.job4j.task3_2.paint.DrawSquare;
import ru.job4j.task3_2.paint.DrawTriangle;

import static org.junit.Assert.assertThat;

/**
 * Created by User on 15.03.2017.
 */
public class StartDrawTest {

    /**
     * string1 1st test string.
     */
    private final String string1 = "  *  ";

    /**
     * string2 2nd test string.
     */
    private final String string2 = " * * ";

    /**
     * string3 3rd test string.
     */
    private final String string3 = "*****";

    /**
     * sr line separator.
     */
    private final String sr = System.getProperty("line.separator");

    /**
     * string1 1st test string.
     */
    private final String stringTestTriangle = String.format("%s%s%s%s%s%s", string1, sr, string2, sr, string3, sr);

    /**
     * Making object Context.
     */
    private Context contextT = new Context(new DrawTriangle());

    /**
     * WhenDoInitImplementsDrawTriangleThenPrintsTriangle cheks is that method prints triangle in pseudo-graphic.
     */
    @Test
    public void whenDoInitImplementsDrawTriangleThenPrintsTriangle() {
        assertThat(stringTestTriangle, is(this.contextT.init(3)));
    }

    /**
     * string1 1st test string.
     */
    private final String string4 = "*****";

    /**
     * string2 2nd test string.
     */
    private final String string5 = "*   *";

    /**
     * string3 3rd test string.
     */
    private final String string6 = "*****";

    /**
     * string1 1st test string.
     */
    private final String stringTestSquare = String.format("%s%s%s%s%s%s", string4, sr, string5, sr, string6, sr);

    /**
     * Making object Context.
     */
    private Context contextD = new Context(new DrawSquare());

    /**
     * whenDoInitImplementsDrawSquareThenPrintsTriangle cheks is that method prints square in pseudo-graphic.
     */
    @Test
    public void whenDoInitImplementsDrawSquareThenPrintsTriangle() {
        assertThat(stringTestSquare, is(this.contextD.init(3)));
    }
}