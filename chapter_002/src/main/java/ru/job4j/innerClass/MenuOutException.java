package ru.job4j.innerClass;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 05.04.2017.
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
