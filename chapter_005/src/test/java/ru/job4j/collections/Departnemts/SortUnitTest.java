package ru.job4j.collections.Departnemts;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 03.08.2017.
 */
public class SortUnitTest {
    @Test
    public void whenDoSortStraightThanRegularSort() throws Exception {
        SortUnit sortUnit = new SortUnit();
        List<Unit> list = Arrays.asList(new Unit("K2"), new Unit("K1"), new Unit("K3"));
        List<Unit> result = Arrays.asList(new Unit("K3"), new Unit("K2"), new Unit("K1"));
        assertThat(result, is(sortUnit.sortStraight(list)));
    }

}