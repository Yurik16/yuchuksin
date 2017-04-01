package ru.job4j.innerClass;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.start.Input;

/**
 * Main class.
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 20.03.2017.
 */
public interface UserAction {
    /**
     *
     */
    int key();

    /**
     *
     */
    void execute(Input input, Tracker tracker);

    /**
     *
     */
    String info();
}
