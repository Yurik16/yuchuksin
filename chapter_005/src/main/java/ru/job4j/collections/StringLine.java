package ru.job4j.collections;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.05.2017.
 */
public class StringLine {

    public String[] doArray(int amount) {
        String[] result = new String[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = Integer.toString(i);
        }
        return result;
    }
}
