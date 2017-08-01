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
    double value;

    /**
     * Current Bank account.
     */
    int requisites;

    /**
     * Default constructor of Account.
     *  @param value money
     * @param requisites number
     */
    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) return false;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }
}
