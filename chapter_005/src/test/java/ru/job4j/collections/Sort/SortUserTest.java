package ru.job4j.collections.Sort;

import org.junit.Test;
import ru.job4j.collections.Sort.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 05.06.2017.
 */
public class SortUserTest {

    /**
     * New empty object SortUser.
     */
    private SortUser sortUser = new SortUser();

    private User user1 = new User("Yetifoot", 55);
    private User user2 = new User("Nik", 22);
    private User user3 = new User("Arkim", 34);
    private User user4 = new User("Time", 19);

    private List<User> startList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));

    /**
     * Compare two lists, is method Sorting Users by age of Users.
     */
    @Test
    public void whenDoSortThenSortByAge() {

        List<User> expected = new ArrayList<>(Arrays.asList(user4, user2, user3, user1));
        assertThat(expected.toArray(), is(sortUser.sort(startList).toArray()));
    }

    /**
     * Compare two lists, is method Sorting Users by hashCode of Users.
     */
    @Test
    public void whenDoSortHashThenSortByHashCode() {

        List<User> expected = new ArrayList<>(Arrays.asList(user3, user2, user4, user1));
        assertThat(expected.toArray(), is(sortUser.sortByAllFields(startList).toArray()));
    }

    /**
     * Compare two lists, is method Sorting Users by name length of Users.
     */
    @Test
    public void whenDoSortLengthThenSortByNameLength() {

        List<User> expected = new ArrayList<>(Arrays.asList(user2, user4, user3, user1));
        assertThat(expected.toArray(), is(sortUser.sortByLength(startList).toArray()));
    }
}