package ru.job4j.collections.tracker.start;

import ru.job4j.innerClass.MenuOutException;

import java.util.Scanner;

/**
 * Created by User on 21.02.2017.
 */
public class ConsoleInput implements Input {
    /**
     * scanner new Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * ask 1st implementation of interface Input.
     *
     * @param question menu questions
     * @return user input
     */
    public String ask(String question) {
        System.out.println(question);
        return this.scanner.nextLine();
    }

    /**
     * ask asking user.
     *
     * @param question question for user
     * @param range list of validate data
     * @return key number of action
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(ask(question));
        for (int x : range) {
            if (x == key) {
                return key;
            }
        }
        throw new MenuOutException("Out of menu range!");
    }
}
