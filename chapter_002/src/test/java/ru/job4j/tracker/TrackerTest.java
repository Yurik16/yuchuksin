package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
     * itemT1 create new test object Item.
     */
	private final Item itemT1 = new Item("name1", "descipt1", 100);

    /**
     * itemT2 create new test object Item.
     */
    private final Item itemT2 = new Item("name2", "descipt2", 200);

    /**
     * itemT3 create new test object Item.
     */
    private final Item itemT3 = new Item("changeName", "changeDescript", 300);

    /**
     * itemsR control array for test.
     */
    private Item[] itemsR = {this.itemT1, this.itemT2};

    /**
     * whenDoAddItemThenGetAddingItemToArray compare two array.
     */
    @Test
    public void whenDoAddItemThenGetAddingItemToArray() {
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
        assertThat(this.itemT2, is(this.tracker.findByName("name2")[0]));
    }

    /**
     * whenFindByIdThenGetItemById compare two array with finding one by id.
     */
    @Test
    public void whenFindByIdThenGetItemById() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        assertThat(this.itemT1, is(this.tracker.findById(this.tracker.getListOfItems()[0].getId())));
    }

    /**
     * whenDoRedactItemThenGetEditItem method must update Item.
     */
    @Test
    public void whenDoRedactItemThenGetEditItem() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        this.itemT3.setComment("new comment");
        this.itemT3.setId("1");
        this.tracker.redactItem(this.itemT2.getId(), this.itemT3);
        Item[] itemsOfTracker = this.tracker.getListOfItems();
        assertThat(this.itemT3, is(itemsOfTracker[1]));
    }

    /**
     * whenDoDeleteItemThenGetEraseOneItem method must delete Item.
     */
    @Test
    public void whenDoDeleteItemThenGetEraseOneItem() {
        this.tracker.addItem(this.itemT1);
        this.tracker.addItem(this.itemT2);
        this.tracker.deleteItem("1");
        assertThat(null, is(this.tracker.findById("1")));
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