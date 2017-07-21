package ru.job4j.collections.Bank;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.07.2017.
 */
public class Account {

    /**
     * Quantity of money at Account of User.
     */
    int value;

    /**
     * Current Bank account.
     */
    int requisites;

    /**
     * Default constructor of Account.
     *
     * @param value money
     * @param requisites number
     */
    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }
}
