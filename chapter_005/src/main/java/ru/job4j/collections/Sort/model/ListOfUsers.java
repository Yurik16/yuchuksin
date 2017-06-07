package ru.job4j.collections.Sort.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 07.06.2017.
 */
public class ListOfUsers {

    List<User> listOfUser = new ArrayList<>();

    public ListOfUsers(List<User> list) {
        this.listOfUser = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfUsers that = (ListOfUsers) o;
        int count = 0;
        if (listOfUser.size() == that.listOfUser.size()) {
            Iterator<User> itList = listOfUser.listIterator();

            for (int i = 0; i < listOfUser.size(); i++) {
                if (that.listOfUser.contains(itList.next())) {
                    count++;
                }
            }
            return listOfUser.size() == count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
