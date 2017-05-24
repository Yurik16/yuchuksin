package ru.job4j.collections.conversion;

import java.util.HashMap;
import java.util.List;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 24.05.2017.
 */
public class UserConvert {

    public UserConvert() {
    }

    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
