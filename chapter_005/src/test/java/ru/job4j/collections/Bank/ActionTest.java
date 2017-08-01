package ru.job4j.collections.Bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 25.07.2017.
 */
public class ActionTest {

    private final User userA = new User("Tom", 111);
    private final User userB = new User("Jerry", 222);
    private final User userC = new User("And", 333);

    private final Account accountAusd = new Account(500, 1333);
    private final Account accountAeur = new Account(300, 2333);
    private final Account accountBusd = new Account(1500, 1444);
    private final Account accountBeur = new Account(1200, 2444);
    private final Account accountCusd = new Account(10, 1555);
    private final Account accountCeur = new Account(5, 2555);

    private final List<Account> listAuser = Arrays.asList(accountAusd, accountAeur);
    private final List<Account> listBuser = Arrays.asList(accountBusd, accountBeur);
    private final List<Account> listCuser = Arrays.asList(accountCusd, accountCeur);

    private Map<User, List<Account>> testMap = new HashMap<User, List<Account>>() {{
        put(userA, listAuser);
        put(userB, listBuser);
    }};

    /**
     * Checks is addUser method adding User to Map.
     */
    @Test
    public void whenDoAddUserThenAddingUserToMap() {
        Actions actions = new Actions(testMap);
        Map<User, List<Account>> result = new HashMap<User, List<Account>>() {{
            put(userA, listAuser);
            put(userB, listBuser);
            put(userC, new ArrayList<>());
        }};
        actions.addUser("And", 333);
        assertThat(result, is(testMap));
    }

    /**
     * Checks is delUser method delete User from Map.
     */
    @Test
    public void whenDoDeleteUserThenUserDeleteFromMap() {
        Map<User, List<Account>> needToDeleteUser = new HashMap<User, List<Account>>() {{
            put(userA, listAuser);
            put(userB, listBuser);
            put(userC, listCuser);
        }};
        Actions actions = new Actions(needToDeleteUser);
        actions.delUser("And", 333);
        assertThat(testMap, is(needToDeleteUser));
    }

    /**
     * Checks is addAccount method adds Account to User.
     */
    @Test
    public void whenDoAddAccountThenAddingAccToUserAtMap() {
        List<Account> halfOfUserC = Collections.singletonList(accountCusd);
        Map<User, List<Account>> result = new HashMap<User, List<Account>>() {{
            put(userA, listAuser);
            put(userB, listBuser);
            put(userC, halfOfUserC);
        }};
        Map<User, List<Account>> mapToAddAccount = new HashMap<User, List<Account>>() {{
            put(userA, listAuser);
            put(userB, listBuser);
            put(userC, new ArrayList<>());
        }};
        Actions actions = new Actions(mapToAddAccount);
        actions.addAccount(userC, accountCusd);
        assertThat(result, is(mapToAddAccount));
        }

    /**
     *
     */
        @Test
        public void whenDoDelAccountThenDeletingAccountFromUserAtMap() {
            Map<User, List<Account>> mapToDelAcc = new HashMap<User, List<Account>>() {{
                put(userA, listAuser);
                put(userB, listBuser);
            }};
            Actions actions = new Actions(mapToDelAcc);
            /*Map<User, List<Account>> mapResult = new HashMap<User, List<Account>>() {{
                put(userA, listAuser);
                put(userB, new ArrayList<>(Collections.singletonList(accountBeur)));
            }};

            assertThat(mapResult, is(mapToDelAcc));*/
            actions.deleteAccount(userB, accountBusd);
        }
    /**
     * Compares two lists - 1st List getting by using getListOfUser method and 2nd manual entering List.
     */
    @Test
    public void whenDoGetListOfUserAccountsThenListReturns() {
        Actions actions = new Actions(testMap);
        List<Account> result = Arrays.asList(new Account(500, 1333), new Account(300, 2333));
        assertThat(result, is(actions.getListOfUserAccounts(userA)));
    }

    /**
     * Checking is transfer from userB to userA is correct.
     */
    @Test
    public void whenDoTransferMoneyThenMonetGoesFromSrcUserToDstUser() {
        Actions actions = new Actions(testMap);
        boolean result = actions.transferMoney(userB, accountBeur, userA, accountAeur, 1000);
        assertThat(true, is((accountAeur.getValue() == 1300) && (accountBeur.getValue() == 200) && result));
    }
}
