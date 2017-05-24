package ru.job4j.collections.conversion;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 24.05.2017.
 */
public class User {

    private int id;
    private String name;
    private String city;

    public int getId() {
        return id;
    }

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
