package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 30.04.2017.
 */
public class FigureNotFoundException extends RuntimeException{
    public FigureNotFoundException(String message) {
        super(message);
    }
}
