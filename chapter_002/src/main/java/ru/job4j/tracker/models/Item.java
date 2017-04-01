package ru.job4j.tracker.models;

import java.util.Date;

/**
 * Item class.
 *
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
     * creating new class Date.
     */
    private Date date = new Date();

    /**
     * Item constructor.
     *
     * @param name        name of Item
     * @param description short describe of Item
     * @param time        date of create Item
     */
    public Item(String name, String description, long time) {
        this.name = name;
        this.description = description;
        this.time = time;
    }

    /**
     * getName getter for name of Item.
     *
     * @return name name of Item
     */
    public String getName() {
        return this.name;
    }

    /**
     * setName setter for name of Item.
     *
     * @param name name of Item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getDesc getter for description of Item.
     *
     * @return description
     */
    public String getDesc() {
        return this.description;
    }

    /**
     * setDesc setter for description of Item.
     *
     * @param description short describe of Item
     */
    public void setDesc(String description) {
        this.description = description;
    }

    /**
     * getTime getter for time of Item.
     *
     * @return time date of create Item
     */
    public long getLong() {
        return this.time;
    }

    /**
     * setTime setter for time of Item.
     *
     * @param time date of create Item
     */
    public void setLomg(long time) {
        this.time = time;
    }

    /**
     * newTime current time setter.
     *
     * @return current time
     */
    public long newTime() {
        return date.getTime();
    }

    /**
     * getComment getter for comment of Item.
     *
     * @return comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * setComment setter for comment of Item.
     *
     * @param comment date of create Item
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * getId getter for id of Item.
     *
     * @return id unique name of Item
     */
    public String getId() {
        return this.id;
    }

    /**
     * setId setter for id of Item.
     *
     * @param id unique name of Item
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * equals overriding.
     *
     * @param obj object
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Item stamp = (Item) obj; // time - don`t include in @override cos it must be real time of task
        return (this.name != null && this.name.equals(stamp.name))
                && (this.description != null && this.description.equals(stamp.description))
                && (this.comment != null && this.comment.equals(stamp.comment))
                && (this.id != null && this.id.equals(stamp.id));
    }

    /**
     * hashCode overriding.
     *
     * @return result
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.valueOf(id);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }
}