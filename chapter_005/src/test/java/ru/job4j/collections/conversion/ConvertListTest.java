package ru.job4j.collections.conversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 23.05.2017.
 */
public class ConvertListTest {

    /**
     * Empty object ConversionList class.
     */
    private final ConvertList conversion = new ConvertList();

    /**
     *
     */
    private final List<Integer> startList = new ArrayList<Integer>();

    private final int[][] expectedToArray = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14, 15}, {16, 17, 18, 19, 20, 21, 22, 23}, {24, 25, 26, 27, 28, 29, 0, 0}};

    private final int[][] startAr = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

    private final List<Integer> expectedToList = new ArrayList<Integer>();

    /**
     *
     */
    @Test
    public void whenDoToArrayThenListGoesArray() {
        assertThat(expectedToArray, is(conversion.toArray(conversion.initList(startList, 30), 4)));
    }

    @Test
    public void whenDoToListThenArrayGoesList() {
        assertThat(conversion.initList(expectedToList, 9), is(conversion.toList(startAr)));
    }

}