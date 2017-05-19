package ru.job4j.chess.Exceptions;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class ImpossibleMoveException extends RuntimeException {

    /**
     * Exception for situation then figure can`t move on destination cell.
     *
     * @param s description of exception
     */
    public ImpossibleMoveException(String s) {
        super(s);
    }
}
