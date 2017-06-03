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

    Set<User> sort(List<User> list) {
        Set<User> sorted = new TreeSet<>();
        sorted.addAll(list);
        return sorted;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Yeti", 19),
                new User("Nik", 22),
                new User("Akim", 34),
                new User("Tim", 50)));
        SortUser sortUser = new SortUser();
        sortUser.sort(list);
        System.out.println(list);
        System.out.println(sortUser.sort(list));
    }
}
