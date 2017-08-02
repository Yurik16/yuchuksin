package ru.job4j.collections.Sort.model;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.06.2017.
 */
public class User implements Comparable<User> {

    /**
     * Getter for name.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Name of User.
     */
    private String name;

    /**
     * Age of User.
     */
    private int age;

    /**
     * HashCode of object User.
     */
    private int hC;

    public int getAge() {
        return age;
    }

    /**
     * Constructor for User class.
     *
     * @param name name
     * @param age  age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.hC = this.hashCode();

    }

    /**
     * Comparing age of User.
     *
     * @param o User object
     * @return int
     */
    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }

    /**
     * toStirng for printing User object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("N=%s, A=%d}", name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + hC;
        return result;
    }
}

