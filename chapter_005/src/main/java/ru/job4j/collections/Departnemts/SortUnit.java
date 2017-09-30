package ru.job4j.collections.Departnemts;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.08.2017.
 */
public class SortUnit {

    public Set<Unit> sortUp(List<Unit> list) {
        Set<Unit> sorted = new TreeSet<>();
        sorted.addAll(list);
        return sorted;
    }

    public List<Unit> sortDownList(List<Unit> list) {
        Collections.sort(list, new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        return list;
    }

    List<Unit> sortStraight(List<Unit> list) {
        Collections.sort(list, new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        return list;
    }

    List<Unit> sortLetterAndDigit(List<Unit> list) {
        Collections.sort(list, new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                int length = o1.getName().length() < o2.getName().length() ? o1.getName().length() : o2.getName().length();
                for(int i = 0; i < length; i++) {
                    int equl = o1.getName().charAt(i)
                }
                return 0;
            }
        });
        return list;
    }

    public static void main(String[] args) {

        List<Unit> list = Arrays.asList(new Unit("K2\\SK1\\SSK1"),
                                        new Unit("K2\\SK1\\SSK2"),
                                        new Unit("K2\\SK1"),
                                        new Unit("K1\\SK1\\SSK2"),
                                        new Unit("K1\\SK2"),
                                        new Unit("K2"),
                                        new Unit("K1"),
                                        new Unit("K1\\SK1"),
                                        new Unit("K1\\SK1\\SSK1"));
        List<Unit> listP = Arrays.asList(new Unit("K1"), new Unit("K10"), new Unit("K5"));
        SortUnit sortUnit = new SortUnit();
        System.out.println(list.toString());
        System.out.println(sortUnit.sortUp(list).toString());
        System.out.println(sortUnit.sortDownList(list).toString());
        System.out.println(sortUnit.sortStraight(listP).toString());
    }
}
