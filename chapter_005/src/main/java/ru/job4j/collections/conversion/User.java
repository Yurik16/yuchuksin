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

    /**
     * Override equals.
     *
     * @param o User object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (!name.equals(user.name)) {
            return false;
        }
        return city.equals(user.city);
    }

    /**
     * Override hashCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
