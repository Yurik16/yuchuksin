package ru.job4j.collections;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.05.2017.
 */
public class LinkedL implements IdurationTime {

    List<String> storageLinfed = new LinkedList<>();
    List<String> storageArray = new ArrayList<>();
    Set<String> storageSet = new TreeSet<>();

    @Override
    public long add(Collection<String> collection, StringLine line, int amount) {
        long timeStart = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }

    @Override
    public long delete(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        int firstElem;
        for (int i = 0; i < amount; i++) {
            collection.remove(firstElem);
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }
}
