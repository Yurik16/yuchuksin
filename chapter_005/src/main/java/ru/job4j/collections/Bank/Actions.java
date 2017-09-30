package ru.job4j.collections.Bank;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.07.2017.
 */
public class Actions {

    private Map<User, List<Account>> clients;

    public Actions(Map<User, List<Account>> clients) {
        this.clients = clients;
    }

    /**
     * Adding User.
     *
     * @param name     User name
     * @param passport User passport ID
     */
    public void addUser(String name, int passport) {
        List<Account> newList = new ArrayList<>();
        User user = new User(name, passport);
        clients.put(user, newList);
    }

    /**
     * Delete User.
     *
     * @param name     finding User name
     * @param passport finding User passport ID
     * @return boolean
     */

    public void delUser(String name, int passport) {
        User misterX = new User(name, passport);
        if (clients.containsKey(misterX)) {
            clients.remove(misterX);
        }
    }

    /**
     * Adding Account to existing User.
     *
     * @param user User name
     * @param acc  bank account
     */
    public void addAccount(User user, Account acc) {
        clients.get(user).add(acc);
    }


    /**
     * Delete one of User accounts.
     *
     * @param user User name
     * @param acc  bank account
     */
    public void deleteAccount(User user, Account acc) {
        List<Account> list = clients.get(user);
        for(Account x : list) {
            if(x.equals(acc)) {
                list.remove(x);
            }
        }
        clients.put(user, list);
    }

    /**
     * Show all accounts of User.
     *
     * @param user name of User
     * @return list of User`s accounts
     */
    public List<Account> getListOfUserAccounts(User user) {
        return clients.get(user);
    }

    /**
     * Transfer money from srcUser to dstUser.
     *
     * @param srcUser    name of User
     * @param srcAccount bank account
     * @param dstUser    name of User
     * @param dstAccount bank account
     * @param amount     transfer sum
     * @return boolean
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transaction = false;
        if (clients.containsKey(srcUser) && clients.containsKey(dstUser)) {
            for(Account x : clients.get(srcUser)) {
                if(x.equals(srcAccount) && x.getValue() >= amount) {
                    x.setValue(x.getValue() - amount);
                }
            }
            for(Account x : clients.get(dstUser)) {
                if(x.equals(dstAccount)) {
                    x.setValue(x.getValue() + amount);
                }
            }
            transaction = true;
        }
        return transaction;
    }
}
