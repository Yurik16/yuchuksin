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
     * The list that will be changed with toArray().
     */
    private final List<Integer> startList = conversion.initList(30);

    /**
     * Expected result after toArray().
     */
    private final int[][] expectedToArray = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14, 15}, {16, 17, 18, 19, 20, 21, 22, 23}, {24, 25, 26, 27, 28, 29, 0, 0}};

    /**
     * The array that will be changed with toList().
     */
    private final int[][] startAr = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

    /**
     * Expected result after toList().
     */
    private final List<Integer> expectedToList = conversion.initList(9);

    /**
     * The list that will be changed with convert().
     */
    private final List<int[]> startIntArray = new ArrayList<>();

    /**
     * sample array one.
     */
    private final int[] one = new int[]{0, 1, 2};

    /**
     * sample array two.
     */
    private final int[] two = new int[]{0, 1, 2, 3, 4};

    /**
     * sample array three.
     */
    private final int[] thr = new int[]{0, 1};

    /**
     * sample array four.
     */
    private final int[] fou = new int[]{0, 1, 2, 3, 4, 5};

    /**
     * Expected result after convert().
     */
    private final List<Integer> expectedIntList = new ArrayList<>();

    /**
     * Compares two array.
     */
    @Test
    public void whenDoToArrayThenListGoesArray() {
        assertThat(expectedToArray, is(conversion.toArray(startList, 4)));
    }

    /**
     * Compares two List.
     */
    @Test
    public void whenDoToListThenArrayGoesList() {
        assertThat(expectedToList, is(conversion.toList(startAr)));
    }

    /**
     * Cheks is the convert() makes from List of integer arrays with different length single List of integer.
     */
    @Test
    public void whenDoConvertThenListOfIntArrayGoesList() {
        startIntArray.add(one);
        startIntArray.add(two);
        startIntArray.add(thr);
        startIntArray.add(fou);

        expectedIntList.add(0);
        expectedIntList.add(1);
        expectedIntList.add(2);
        expectedIntList.add(0);
        expectedIntList.add(1);
        expectedIntList.add(2);
        expectedIntList.add(3);
        expectedIntList.add(4);
        expectedIntList.add(0);
        expectedIntList.add(1);
        expectedIntList.add(0);
        expectedIntList.add(1);
        expectedIntList.add(2);
        expectedIntList.add(3);
        expectedIntList.add(4);
        expectedIntList.add(5);
        assertThat(expectedIntList, is(conversion.convert(startIntArray)));
    }

}