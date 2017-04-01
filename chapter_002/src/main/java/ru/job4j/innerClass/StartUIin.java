package ru.job4j.innerClass;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.start.ConsoleInput;
import ru.job4j.tracker.start.Input;

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

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] listOfActions = {1, 2, 3, 4, 5, 6};
        int key;
        while (true) {
            menu.show();
            System.out.println("7. Exit");
            key = Integer.valueOf(input.ask("Enter 1 ... 7"));
            for (int x : listOfActions) {
                if (x == key) {
                    menu.act(key);
                }
            }
            if (key == 7) {
                if ("y".equals(input.ask("EXIT!?('y')"))) {
                    break;
                }
            }
            System.out.println("... choose you action again");
        }
    }

    public static void main(String[] args) {
        /**
         * Creating new object of Console Interface.
         */
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();

        StartUIin startUIin = new StartUIin(input, tracker);
        startUIin.init();
    }
}
