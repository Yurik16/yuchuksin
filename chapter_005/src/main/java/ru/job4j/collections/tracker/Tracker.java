package ru.job4j.collections.tracker;


import ru.job4j.collections.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;
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
    private List<Item> items = new ArrayList<>();

    /**
     * count counter for Item.
     */
    private int count = 0;

    /**
     * Default constructor of class Tracker.
     */
    public Tracker() {}

    /**
     * Constructor of class Tracker.
     *
     * @param items List of Items
     */
    public Tracker(List<Item> items) {
        this.items = items;
    }

    /**
     * Default object Tracker
     */
    private Tracker tracker = new Tracker(items);

    /**
     * addItem adding new object Item in array items.
     *
     * @param item new object of Item
     * @return item
     */
    public Item addItem(Item item) {
        //item.setId(String.valueOf(rnd.nextInt(200)));
        item.setId(String.valueOf(count + 1));
        this.items.add(item);
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
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item x : this.items) {
            if (x != null && x.getName().equals(name)) {
                result.add(x);
            }
        }
        return result;
    }

    /**
     * findByDesc find Item by description.
     *
     * @param desc of searching Item
     * @return result searching Item by name
     */
    public List<Item> findByDesc(String desc) {
        List<Item> result = new ArrayList<>();
        for (Item x : this.items) {
            if (x != null && x.getDesc().equals(desc)) {
                result.add(x);
            }
        }
        return result;
    }

    /**
     * redactItem edit Item.
     *
     * @param item new object of Item
     * @param id name of wanted Item
     */
    public void redactItem(String id, Item item) {
        Item ask = findById(id);
        for (Item x : items) {
            if (x != null && x.getId().equals(ask.getId())) {
                x = item;
                x.setId(ask.getId());
            }
        }
    }

    /**
     * deleteItem delete Item by using ID of this Item.
     *
     * @param id unique name of Item
     */
    public void deleteItem(String id) {
        for (Item x : items) {
            if (x != null && x.getId().equals(id)) {
                items.remove(items.indexOf(x));
            }
        }
    }

    /**
     * getListOfItems getting list of all Items.
     *
     * @return list array of all Item
     */
    public List<Item> getListOfItems() {
        List<Item> list = new ArrayList<>();
        list.addAll(items);
        return list;
    }

    /**
     * addComment adding comments.
     *
     * @param name    name of wanted Item to add comment
     * @param comment comment for Item
     */
    public void addComment(String name, String comment) {
        Item item = tracker.findByName(name).get(0);
        item.setComment(comment);
    }
}
