package ru.job4j.collections;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.05.2017.
 */
public class CompareTimeAddDel {

    public CompareTimeAddDel() {
    }

    public long add(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }

    public long delete(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(Integer.toString(i));
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }

    public static void main(String[] args) {

        CompareTimeAddDel storage = new CompareTimeAddDel();
        int cycles = 100000;
        List<String> storageLinked = new LinkedList<>();
        List<String> storageArray = new ArrayList<>();
        Set<String> storageSet = new TreeSet<>();
        long timeL = storage.add(storageLinked, cycles);
        long timeA = storage.add(storageArray, cycles);
        long timeS = storage.add(storageSet, cycles);

        System.out.println(String.format("Time of adding to Lin - %s", timeL));
        System.out.println(String.format("Time of adding to Arr - %s", timeA));
        System.out.println(String.format("Time of adding to Set - %s", timeS));
        System.out.println(String.format("Time of delete to Lin - %s", storage.delete(storageLinked, cycles)));
        System.out.println(String.format("Time of delete to Arr - %s", storage.delete(storageArray, cycles)));
        System.out.println(String.format("Time of delete to Set - %s", storage.delete(storageSet, cycles)));
    }
}
