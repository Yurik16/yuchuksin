package ru.job4j.collections.Bank;

import java.util.*;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 21.07.2017.
 */
public class Actions {

    private Map<User,List<Account>> clients = new HashMap<>();

    public Actions(HashMap<User, List<Account>> clients) {
        this.clients = clients;
    }

    /**
     * Adding User.
     *
     * @param name User name
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
     * @param name finding User name
     * @param passport finding User passport ID
     * @return boolean
     */

    public void delUser(String name, int passport) {
        User misterX = new User(name, passport);
        if(clients.containsKey(misterX)) {
            clients.remove(misterX);
        }
    }

    /**
     * Adding Account to existing User.
     *
     * @param user User name
     * @param val money
     * @param req ID of bank account
     */
    public void addAccount(User user, int val, int req) {
        for(Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if(user.equals(entry.getKey())) {
                entry.getValue().add(new Account(val, req));
            }
        }
    }

    /**
     * Delete one of User accounts.
     *
     * @param requisites ID of bank account
     */
    public void deleteAccount(int requisites) {
        Iterator<Map.Entry<User, List<Account>>> it = clients.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<User, List<Account>> client = it.next();
            if(client.getValue().contains(requisites)) {
                client.getValue().remove(client.getValue().indexOf(requisites));
            }
        }
    }

    /**
     * Show all accounts of User.
     *
     * @param user name of User
     * @return ArrayList
     */
    public List<Account> getListOfUser(User user) {
        List result = new ArrayList();
        for(Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if(user.equals(entry.getKey())) {
               result.addAll(entry.getValue());
            }
        }
        return result;
    }
}
