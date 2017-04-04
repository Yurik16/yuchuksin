package ru.job4j.innerClass;

import ru.job4j.tracker.start.ConsoleInput;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 05.04.2017.
 */
public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        boolean actual = true;
        int key = 7;
        do {
            try {
                key = super.ask(question, range);
                actual = false;
            } catch (MenuOutException moe) {
                System.out.println("Wrong number.");
            } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                    System.out.println("Enter the number, please.");
            }
        } while (actual);
        return key;
    }
}

