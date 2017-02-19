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
	* @return item
	*/
	public Item addItem(Item item) {
		this.items[this.count++] = item;
		return item;
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
	* redactItem edit Item.
	* @param item object of Item
	*/
	public void redactItem(Item item) {
		for (int i = 0; i < this.count; i++) {
			if (this.items[i] != null && this.items[i].getId().equals(item.getId)) {
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
			if (this.items[i] != null && this.items[i].getId().equals(item.getId)) {
				this.items[i] = null;
			}
		}
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
	
	/**
	* findByFilter find Item by filter.
	* @param item object of Item
	* @return result
	*/
	public Item findByFilter(Item item) {
		Item result = null;
		for (Item x : this.items) {

		}
	}
} 