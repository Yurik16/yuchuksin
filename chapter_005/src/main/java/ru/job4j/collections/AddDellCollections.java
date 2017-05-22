package ru.job4j.collections;

import java.util.Collection;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 22.05.2017.
 */
public interface AddDellCollections {

    long add(Collection<String> collection, int amount);

    long delete(Collection<String> collection, int amount);
}
