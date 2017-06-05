package ru.job4j.collections.Sort.model;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.06.2017.
 */
public class User implements Comparable<User>{

    /**
     * Getter for name.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    private String name;

    private int age;

    private int hC;

    /**
     * Constructor for User class.
     *
     * @param name name
     * @param age age
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", @" + hC +
                '}';
    }
}
