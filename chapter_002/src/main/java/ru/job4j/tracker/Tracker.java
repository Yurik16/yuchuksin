package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.util.Random;

/**
 * class Tracker.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @version 1.0.0
 * @since 18.02.2017
 */
public class Tracker {
    /**
     *
     */
    private Random rnd = new Random();
    /**
     * items list of objects Item.
     */
    private Item[] items = new Item[10];

    /**
     * count counter for Item.
     */
    private int count = 0;

    /**
     * addItem adding new object Item in array items.
     *
     * @param item new object of Item
     * @return item
     */
    public Item addItem(Item item) {
        //item.setId(String.valueOf(rnd.nextInt(200)));
        item.setId(String.valueOf(count + 1));
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
    public Item[] findByName(String name) {
        Item[] result = new Item[10];
        int pos = 0;
        for (Item x : this.items) {
            if (x != null && x.getName().equals(name)) {
                result[pos++] = x;
            }
        }
        return cutArray(result);
    }

    /**
     * findByDesc find Item by description.
     *
     * @param desc of searching Item
     * @return result searching Item by name
     */
    public Item[] findByDesc(String desc) {
        Item[] result = new Item[10];
        int pos = 0;
        for (Item x : this.items) {
            if (x != null && x.getDesc().equals(desc)) {
                result[pos++] = x;
            }
        }
        return cutArray(result);
    }

    /**
     * redactItem edit Item.
     *
     * @param item new object of Item
     * @param id name of wanted Item
     */
    public void redactItem(String id, Item item) {
        Item ask = findById(id);
        for (int i = 0; i < this.count; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(ask.getId())) {
                this.items[i] = item;
                this.items[i].setId(ask.getId());
            }
        }
    }

    /**
     * deleteItem purge all variables of Item.
     *
     * @param id unique name of Item
     */
    public void deleteItem(String id) {
        for (int i = 0; i < this.count; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
            }
        }
        this.items = cutArray(this.items);
        count--;
    }

    /**
     * cutArray cuting null-tales.
     *
     * @param item Item which have null-tail
     * @return result
     */
    public Item[] cutArray(Item[] item) {
        Item[] result = new Item[item.length];
        int k = 0;
        for (int i = 0; i < item.length; i++) {
            if (item[i] != null) {
                result[i] = item[k];
                k++;
            }
            if (item[i] == null) {
                for (int j = i; j < this.count; j++) {
                    result[i] = item[k + 1];
                }
                k += 2;
            }
        }
        return result;
    }

    /**
     * getListOfItems getting list of all Items.
     *
     * @return list array of all Item
     */
    public Item[] getListOfItems() {
        Item[] list = new Item[count];
        for (int i = 0; i < this.count; i++) {
            list[i] = this.items[i];
        }
        return list;
    }

    /**
     * addComment adding comments.
     *
     * @param name    name of wanted Item to add comment
     * @param comment comment for Item
     */
    public void addComment(String name, String comment) {
        Item item = findByName(name)[0];
        item.setComment(comment);
    }
}
