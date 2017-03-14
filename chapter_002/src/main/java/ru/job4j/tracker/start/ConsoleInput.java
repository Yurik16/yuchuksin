package ru.job4j.tracker.start;

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
}
