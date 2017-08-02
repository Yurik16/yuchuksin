package ru.job4j.collections.Bank;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.07.2017.
 */
public class User {

    /**
     * 1st and 2nd name of User.
     */
    String name;

    /**
     * Serial No of User`s passport.
     */
    int passport;

    /**
     * Default constructor.
     *
     * @param name 1st and 2nd name of User
     * @param passport Serial No of User`s passport
     */

    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Default overriding equals.
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (passport != user.passport) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    /**
     * Default overriding hashCode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }

}
