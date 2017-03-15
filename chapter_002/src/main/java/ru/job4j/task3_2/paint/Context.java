package ru.job4j.task3_2.paint;

/**
 * Created by User on 15.03.2017.
 */
public class Context {
    /**
     * strategy container for switching implementations.
     */
    private Strategy strategy;

    /**
     * constructor of Context.
     *
     * @param strategy kine of implement
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * init pushes pseudo-graphic.
     *
     * @param size height of element
     * @return pseudo-graphic
     */
    public String init(int size) {
        return strategy.draw(size);
    }
}
