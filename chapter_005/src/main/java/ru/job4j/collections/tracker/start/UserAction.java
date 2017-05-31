package ru.job4j.collections.tracker.start;

import ru.job4j.collections.tracker.Tracker;

/**
 * Interface.
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 20.03.2017.
 */
public interface UserAction {

    /**
     * The key of current user action.
     * @return number
     */
    int key();

    /**
     * doing the action what user choose.
     * @param input enter data
     * @param tracker existing tasks
     */
    void execute(Input input, Tracker tracker);

    /**
     * Showing what is doing now.
     * @return String
     */
    String info();
}
