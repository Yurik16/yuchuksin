package ru.job4j.collections.Bank;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.07.2017.
 */
public class Actions {

    private Map<User, List<Account>> clients = new HashMap<>();

    public Actions(HashMap<User, List<Account>> clients) {
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
        List<Account> temp = clients.get(user);
        temp.add(acc);
    }


    /**
     * Delete one of User accounts.
     *
     * @param user User name
     * @param acc  bank account
     */
    public void deleteAccount(User user, Account acc) {
        Iterator<Map.Entry<User, List<Account>>> it = clients.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<User, List<Account>> client = it.next();
            if (clients.containsKey(user)) {
                if (client.getValue().contains(acc)) {
                    client.getValue().remove(client.getValue().indexOf(acc));
                }
            }
        }
    }

    /**
     * Show all accounts of User.
     *
     * @param user name of User
     * @return list of User`s accounts
     */
    public List<Account> getListOfUser(User user) {
        List result = new ArrayList();
        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (user.equals(entry.getKey())) {
                result.addAll(entry.getValue());
            }
        }
        return result;
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
        Actions action = new Actions((HashMap<User, List<Account>>) clients);
        if (clients.containsKey(srcUser) && clients.containsKey(dstUser)) {

            List<Account> sorceList = clients.get(srcUser);
            List<Account> destList = clients.get(dstUser);
            double srcValue = sorceList.get(sorceList.indexOf(srcAccount)).getValue();
            int srcRequis = sorceList.get(sorceList.indexOf(srcAccount)).getRequisites();

            if (sorceList.contains(srcAccount) && destList.contains(dstAccount) && srcValue >= amount) {
                Account srcNew = new Account((srcValue - amount), srcRequis);
                action.deleteAccount(srcUser, srcAccount);
                action.addAccount(srcUser, srcNew);
                transaction = true;
            }
        }
        return transaction;
    }
}
