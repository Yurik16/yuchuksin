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
     * Sorting Users by comparing hashCode of Users
     *
     * @param list List of Users
     * @return List of Users
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, (o1, o2) -> o1.hashCode() - o2.hashCode());
        return list;
    }

    /**
     * Sorting Users by comparing length of name of Users
     *
     * @param list List of Users
     * @return List of Users
     */
    public List<User> sortLength(List<User> list) {
        Collections.sort(list, (o1, o2) -> o1.getName().length() - o2.getName().length());
        return list;
    }

    /**
     * Main method.
     *
     * @param args args
     */
    public static void main(String[] args) {
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Yetifoot", 55),
                new User("Nik", 22),
                new User("Arkim", 34),
                new User("Time", 19)));

        Set<User> set = new TreeSet<>();
        SortUser sortUser = new SortUser();
        System.out.println(list); // - original List
        set.addAll(list); // adding List to TreeSet
        System.out.println(set); // new TreeSet as sorted?
        sortUser.sort(list); // sorting? TreeSet
        System.out.println(sortUser.sort(list)); // result equals new TreeSet
        System.out.println(sortUser.sortHash(list));
        System.out.println(sortUser.sortLength(list));
    }
}
