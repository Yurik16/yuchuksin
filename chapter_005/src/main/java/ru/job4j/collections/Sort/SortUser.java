package ru.job4j.collections.Sort;

import ru.job4j.collections.Sort.model.User;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 03.06.2017.
 */
public class SortUser {

    /**
     * Sorting Users by comparing age of Users.
     *
     * @param list list of Users
     * @return TreeSet
     */
    Set<User> sort(List<User> list) {
        Set<User> sorted = new TreeSet<>();
        sorted.addAll(list);
        return sorted;
    }

    /**
     * Sorting Users by comparing name and age of Users.
     *
     * @param list List of Users
     * @return List of Users
     */
    public List<User> sortByAllFields(List<User> list) {

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() - (o2.getAge());
                }
                return result;
            }
        });
        return list;
    }

    /**
     * Sorting Users by comparing length of name of Users.
     *
     * @param list List of Users
     * @return List of Users
     */
    public List<User> sortByLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }
}
