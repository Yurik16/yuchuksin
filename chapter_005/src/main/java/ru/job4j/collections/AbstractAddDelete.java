package ru.job4j.collections;

import java.util.Collection;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 22.05.2017.
 */
public abstract class AbstractAddDelete {

    Collection collection;

    public AbstractAddDelete(Collection<String> collection) {
        this.collection = collection;
    }
}

