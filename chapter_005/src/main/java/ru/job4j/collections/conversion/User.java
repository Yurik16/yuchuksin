package ru.job4j.collections.conversion;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 24.05.2017.
 */
public class User {

    /**
     * Unique number.
     */
    private int id;

    /**
     * Name of User.
     */
    private String name;

    /**
     * City name.
     */
    private String city;

    /**
     * Getter for the id of the User.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Constructor for User.
     *
     * @param id   unique number
     * @param name name of User
     * @param city city name
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
