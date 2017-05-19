package ru.job4j.chess.Exceptions;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class FigureNotFoundException extends RuntimeException {

    /**
     * Exception for situation then figure on marked cell is absent.
     *
     * @param message description of exception
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
