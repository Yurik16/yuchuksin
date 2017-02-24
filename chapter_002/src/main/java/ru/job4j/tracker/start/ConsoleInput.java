package ru.job4j.tracker.start;

import java.util.Scanner;

/**
 * Created by User on 21.02.2017.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return this.scanner.nextLine();
    }
}
