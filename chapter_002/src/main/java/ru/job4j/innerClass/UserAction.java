package ru.job4j.innerClass;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.start.Input;

/**
 * Created by User on 20.03.2017.
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
