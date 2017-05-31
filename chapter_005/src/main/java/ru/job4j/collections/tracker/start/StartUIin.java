package ru.job4j.collections.tracker.start;

import ru.job4j.collections.tracker.Tracker;

/**
 * Main class.
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 20.03.2017.
 */
public class StartUIin {
    /**
     * creating new class Input.
     */
    private final Input input;

    /**
     * creating new class Tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * StartUI constructor of class.
     *
     * @param input   what kind of interface is using
     * @param tracker list of Items
     */
    public StartUIin(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Screening menu and asking what to do form User.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        UserAction[] listOfAct = menu.fillActions();
        int[] listOfPoints = menu.fillRange(listOfAct);
        int key;
        while (true) {
            menu.show();
            key = input.ask("Enter 1 ... 7", listOfPoints);
            menu.act(key);
            if (key == 7) {
                if ("y".equals(input.ask("EXIT!?('y')"))) {
                    break;
                }
            }
        }
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        /**
         * Creating new object of Console Interface.
         */
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();

        StartUIin startUIin = new StartUIin(input, tracker);
        startUIin.init();
    }
}
