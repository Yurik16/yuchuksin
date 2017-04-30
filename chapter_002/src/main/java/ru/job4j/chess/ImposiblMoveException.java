package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class ImposiblMoveException extends IndexOutOfBoundsException {

    public ImposiblMoveException(String s) {
        super(s);
    }
}
