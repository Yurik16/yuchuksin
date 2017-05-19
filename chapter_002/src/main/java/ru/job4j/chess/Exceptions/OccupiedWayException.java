package ru.job4j.chess.Exceptions;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 04.05.2017.
 */
public class OccupiedWayException extends RuntimeException {

    /**
     * Exception for situation then path of the figure is occupied.
     *
     * @param msg description of exception
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
