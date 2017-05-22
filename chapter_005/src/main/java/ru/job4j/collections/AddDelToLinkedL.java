package ru.job4j.collections;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 22.05.2017.
 */
public class AddDelToLinkedL extends AbstractAddDelete implements AddDellCollections {

    public AddDelToLinkedL(LinkedList<String> collection) {
        super(collection);
    }

    @Override
    public long add(Collection<String> collection, int amount) {
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
        for (int i = 0; i < amount; i++) {
            collection.remove(Integer.toString(i));
        }
        long timeFinish = System.nanoTime();
        return timeFinish - timeStart;
    }
}
