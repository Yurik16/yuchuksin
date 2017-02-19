package ru.job4j.tracker;

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
	* count countes for Item
	*/
	private int count = 0;

	/**
	* addItem adding new object Item in array items.
	* @param item new object of Item
	*/
	public addItem(Item item) {
		this.items[this.count++] = item;
	}

	/**
	* findById finds Item by name.
	* @param id of searching Item
	* @return x searching Item by id
	*/
	public Item findById(String id) {
		for (Item x : this.items) {
			if (x != null && x.getId().equals(id)) {
				return x;
				break;
			}
		}
	}
	
	/**
	* findByName find Item by name.
	* @param name of searching Item
	* @return x searching Item by name
	*/
	public Item findByName(Strng name) {
		for (Item x : this.items) {
			if (x != null && x.getName().equals(name)) {
				return x;
				break;
	}

	/**
	* editItem edit name of Item.
	* @param id unique name of Item
	* @param name new name of existing Item
	*/
	public void editItem(String id, Item item) {
		this.items.findById(id).setName(item.name);
		this.items.findById(id).setDesc(item.description);
		this.items.findById(id).setTime(item.time);
		this.items.findById(id).setComment(item.comment);

	}

	/**
	* deleteItem purge all variables of Item.
	* @param id unique name of Item
	*/
	public deleteItem(String id) {
		this.items.findById(id).setName(null);
		this.items.findById(id).setDesc(null);
		this.items.findById(id).setTime(null);
		this.items.findById(id).setComment(null);
		this.items.findById(id).setId(null);
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