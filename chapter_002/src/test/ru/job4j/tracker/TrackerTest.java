package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

.java.ulil.Date.*;

/**
* Class TrackerTest.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since 19.02.2017
*/

public class TrackerTest {
    /**
     * tracker create new empty object Tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * date new empty object Date.
     */
    Date date = new Date();

    /**
     * itemsR control array for test.
     */
    private Item[] itemsR = new Item[new Item("name1", "descipt1", date.getTime()), new Item("name2", "descipt2", date.getTime())];

    /**
     * itemT1 create new test object Item.
     */
	private final Item itemT1 = new Item("name1", "descipt1", date.getTime());

    /**
     * itemT2 create new test object Item.
     */
    private final Item itemT2 = new Item("name2", "descipt2", date.getTime());

    /**
     * itemT3 create new test object Item.
     */
    private final Item itemT3 = new Item("changeName", "changeDescript", date.getTime());

    /**
     * whenDoAddItemthenGetAddingItemToArray compare two array.
     */
    @Test
    public void whenDoAddItemthenGetAddingItemToArray() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        assertThat(this.itemsR, is(this.tracker.getListOfItems()));
    }

    /**
     * whenDoFindByNameThenGetItemByName compare two array with finding one by name.
     */
    @Test
    public void whenDoFindByNameThenGetItemByName() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        assartThat(this.itemT2, is(this.tracker.findByName("name2")));
    }

    /**
     * whenFindByIdThenGetItemById compare two array with finding one by id.
     */
    @Test
    public void whenFindByIdThenGetItemById() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        assertThat(this.itemT1, is(this.tracker.findById("1")));
    }

    /**
     * whenDoRedactItemThenGetEditItem method must update Item.
     */
    @Test
    public void whenDoRedactItemThenGetEditItem() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        this.itemT3.setComment("new comment");
        this.itemT3.setId("2");
        assertThat(this.itemT3, is(this.tracker.redactItem(new Item("changeName", "changeDescript", this.date.getTime(), "new comment", "2"))));
    }

    /**
     * whenDoDeleteItemThenGetEraseOneItem method must delete Item.
     */
    @Test
    public void whenDoDeleteItemThenGetEraseOneItem() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        Item itemNull = this.tracker.deleteItem("1");
        assertThat(null, is(itemNull));
    }

    /**
     * whenDoGetListOfItemsThenGetArrayList method must get all items.
     */
    @Test
    public void whenDoGetListOfItemsThenGetArrayList() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        assertThat(this.itemsR, is(this.tracker.getListOfItems()));
    }
}