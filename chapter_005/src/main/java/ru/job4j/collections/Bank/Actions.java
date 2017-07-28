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
        clients.get(user).add(acc);
    }


    /**
     * Delete one of User accounts.
     *
     * @param user User name
     * @param acc  bank account
     */
    public void deleteAccount(User user, Account acc) {
        /*Iterator<Map.Entry<User, List<Account>>> it = clients.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<User, List<Account>> client = it.next();
            if (clients.containsKey(user)) {
                if (client.getValue().contains(acc)) {
                    client.getValue().remove(client.getValue().indexOf(acc));
                }
            }
        }*/
        clients.get(user).remove(acc);

    }

    /**
     * Show all accounts of User.
     *
     * @param user name of User
     * @return list of User`s accounts
     */
    public List<Account> getListOfUserAccounts(User user) {
        /*List result = new ArrayList();
        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (user.equals(entry.getKey())) {
                result.addAll(entry.getValue());
            }
        }
        return result;*/
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
        Actions action = new Actions((HashMap<User, List<Account>>) clients);
        if (clients.containsKey(srcUser) && clients.containsKey(dstUser)) {
            List<Account> srcList = clients.get(srcUser);
            List<Account> dstList = clients.get(dstUser);
            double srcValue = srcList.get(srcList.indexOf(srcAccount)).getValue();
            double dstValue = dstList.get(dstList.indexOf(dstAccount)).getValue();
            int srcReq = srcList.get(srcList.indexOf(srcAccount)).getRequisites();
            int dstReq = dstList.get(dstList.indexOf(dstAccount)).getRequisites();
            if (srcList.contains(srcAccount) && dstList.contains(dstAccount) && srcValue >= amount) {
                for(Map.Entry<User, List<Account>> entry : clients.entrySet()) {
                    if(entry.getKey().equals(srcUser)) {
                        for(Account account : entry.getValue()) {
                            if(account.equals(srcAccount)) {

                            }
                        }
                    }
                }
                /*srcValue -= amount;
                dstValue += amount;
                int indexSrc = srcList.indexOf(srcAccount);
                int indexDst = dstList.indexOf(dstAccount);
                srcList.remove(indexSrc);
                dstList.remove(indexDst);
                srcList.add(new Account(srcValue, srcReq));
                dstList.add(new Account(dstValue, dstReq));
                ((HashMap<User, List<Account>>) clients).put(srcUser, srcList);
                ((HashMap<User, List<Account>>) clients).put(dstUser, dstList);*/
                transaction = true;
            }
        }
        return transaction;
    }
}
