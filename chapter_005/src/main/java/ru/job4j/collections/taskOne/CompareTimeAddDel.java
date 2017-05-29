package ru.job4j.collections.taskOne;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.05.2017.
 */
public class CompareTimeAddDel {

    /**
     * Default constructor.
     */
    public CompareTimeAddDel() {
    }

    /**
     * Calculates time in milli sec form adding.
     *
     * @param collection List or Set
     * @param amount     adding acts
     * @return time milli sec
     */
    public long add(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }

    /**
     * Calculates time in milli sec form deleting.
     *
     * @param collection List or Set
     * @param amount     del acts
     * @return time milli sec
     */
    public long delete(Collection<String> collection, int amount) {
        Iterator<String> it = collection.iterator();
        long timeStart = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            it.next();
            it.remove();
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }

    /**
     * Main method.
     *
     * @param args args
     */
    public static void main(String[] args) {

        CompareTimeAddDel storage = new CompareTimeAddDel();
        int cycles = 100000;
        LinkedList<String> storageLinked = new LinkedList<>();
        ArrayList<String> storageArray = new ArrayList<>();
        TreeSet<String> storageSet = new TreeSet<>();
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
