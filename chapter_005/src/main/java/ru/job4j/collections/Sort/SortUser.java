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

    public List<User> sortHash(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        return list;
    }

    public List<User> sortLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }

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
