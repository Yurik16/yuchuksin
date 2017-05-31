package ru.job4j.collections.tracker.start;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 31.05.2017.
 */
public class MenuOutException extends RuntimeException {

    /**
     * MenuOutException my exception.
     *
     * @param msg explain what is wrong in entering data
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
