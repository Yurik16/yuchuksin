package ru.job4j.chess.Exceptions;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class ImpossibleMoveException extends IndexOutOfBoundsException {

    public ImpossibleMoveException(String s) {
        super(s);
    }
}
