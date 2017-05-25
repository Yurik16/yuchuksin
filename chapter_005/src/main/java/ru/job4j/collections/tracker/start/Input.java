package ru.job4j.collections.tracker.start;

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

    /**
     * ask asking user.
     *
     * @param question question
     * @param range list
     * @return key
     */
    int ask(String question, int[] range);
}
