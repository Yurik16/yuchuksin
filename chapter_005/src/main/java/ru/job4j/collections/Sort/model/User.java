package ru.job4j.collections.Sort.model;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.06.2017.
 */
public class User implements Comparable<User>{

    public String getName() {
        return name;
    }

    private String name;

    private int age;

    private int hC;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.hC = this.hashCode();

    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", @" + hC +
                '}';
    }
}
