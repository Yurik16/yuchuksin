package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.util.Arrays;

/**
* class Tracker.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @version 1.0.0
* @since 18.02.2017
*/
public class Tracker {

    /**
     * items list of objects Item.
     */
    private Item[] items = new Item[10];

    /**
     * count countes for Item.
     */
    private int count = 0;

    /**
     * addItem adding new object Item in array items.
     *
     * @param item new object of Item
     * @return item
     */
    public Item addItem(Item item) {
        item.setId(String.valueOf(this.count));
        this.items[this.count++] = item;
        return item;
    }

    /**
     * findById finds Item by name.
     *
     * @param id of searching Item
     * @return result searching Item by id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item x : this.items) {
            if (x != null && x.getId().equals(id)) {
                result = x;
                break;
            }
        }
        return result;
    }

    /**
     * findByName find Item by name.
     *
     * @param name of searching Item
     * @return result searching Item by name
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item x : this.items) {
            if (x != null && x.getName().equals(name)) {
                result = x;
                break;
            }
        }
        return result;
    }

    /**
     * redactItem edit Item.
     *
     * @param item object of Item
     */
    public void redactItem(Item item) {
        for (int i = 0; i < this.count; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
            }
        }
    }

    /**
     * deleteItem purge all variables of Item.
     * @param id unique name of Item
     */
    public void deleteItem(String id) {
        for (int i = 0; i < this.count; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
                count--;
            }
            this.items[i+1] = this.items[i];
        }
        Item[] result = Arrays.copyOf(this.items, this.items.length - 1);
        this.items = result;

    }

    /**
     * getListOfItems getting list of all Items.
     * @return list array of all Item
     */
    public Item[] getListOfItems() {
        Item[] list = new Item[count];
        for (int i = 0; i < this.count; i++) {
            list[i] = this.items[i];
        }
        return list;
    }
}
