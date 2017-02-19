package ru.job4j.tracker;

/**
* Item class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 18.02.2017
*/
public class Item {

	/**
	* name name of Item.
	*/
	private String name;

	/**
	* description short describe of Item.
	*/
	private String description;

	/**
	* time date of create Item.
	*/
	private long time;

	/**
	* comment comment of Item.
	*/
	private String comment;

	/**
	* id unique name of Item.
	*/
	private String id;

	/**
	* Item constructor.
	* @param name name of Item
	* @param description short describe of Item
	* @param time date of create Item
	*/
	public Item(String name, String description, long time) {
		this.name = name;
		this.description = description;
		this.time = time;

	}

	/**
	* getName getter for name of Item.
	* @return name name of Item
	*/
	public String getName() {
		return this.name;
	}

	/**
	* setName setter for name of Item.
	* @param name name of Item
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* getDesc getter for description of Item.
	* @return description
	*/
	public String getDesc() {
		return this.description;
	}

	/**
	* setDesc setter for description of Item.
	* @param description short describe of Item
	*/
	public void setDesc(String description) {
		this.description = description;
	}

	/**
	* getTime getter for time of Item.
	* @return time date of create Item
	*/
	public long getTime() {
		return this.time;
	}

	/**
	* setTime setter for time of Item.
	* @param time date of create Item
	*/
	public void setTime(long time) {
		this.time = time;
	}

	/**
	* getComment getter for comment of Item.
	* @return comment
	*/
	public String getComment() {
		return this.comment;
	}

	/**
	* setComment setter for comment of Item.
	* @param comment date of create Item
	*/
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	* getId getter for id of Item.
	* @return id unique name of Item
	*/
	public String getId() {
		return this.id;
	}

	/**
	* setId setter for id of Item.
	* @param id unique name of Item
	*/
	public void setId(String id) {
		this.id = id;
	}
}