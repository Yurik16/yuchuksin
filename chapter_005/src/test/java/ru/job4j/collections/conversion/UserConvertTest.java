package ru.job4j.collections.conversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 24.05.2017.
 */
public class UserConvertTest {

    /**
     * Empty object UresConvert class.
     */
    private final UserConvert userConvert = new UserConvert();

    /**
     * Empty List of User`s.
     */
    private final List<User> listStart = new ArrayList<>();

    /**
     * 1st User manual entry.
     */
    private final User user1 = new User(1, "Li", "Beijin");

    /**
     * 2nd User manual entry.
     */
    private final User user2 = new User(2, "Pete", "NewYork");

    /**
     * 3rd User manual entry.
     */
    private final User user3 = new User(3, "Tolik", "Rostov");

    /**
     * Expecting HashMap after process().
     */
    private final HashMap<Integer, User> mapExpect = new HashMap<>();

    /**
     * Compares two HashMap<Integer, User> 1st Map - manual filling, 2nd Map - using process().
     */
    @Test
    public void whenDoProcessThenMapGetsIdAndUser() {
        listStart.add(user1);
        listStart.add(user2);
        listStart.add(user3);
        mapExpect.put(1, user1);
        mapExpect.put(2, user2);
        mapExpect.put(3, user3);
        assertThat(mapExpect, is(userConvert.process(listStart)));

    }

}