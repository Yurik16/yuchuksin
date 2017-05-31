package ru.job4j.collections.tracker.start;

import java.util.List;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 05.04.2017.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * ask asking user with checking entering data is it validate.
     *
     * @param question question for user
     * @param range list of validate data
     * @return key number of action
     */
    public int ask(String question, List<Integer> range) {
        boolean actual = true;
        int key = 6;
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

