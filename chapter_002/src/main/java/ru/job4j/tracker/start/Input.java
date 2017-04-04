package ru.job4j.tracker.start;

/**
 * Created by User on 21.02.2017.
 */
public interface Input {

    /**
     * ask interface for Tracker.
     *
     * @param question depends of implementation
     * @return null
     */
    String ask(String question);

    int ask(String question, int[] range);
}
