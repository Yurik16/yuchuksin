package ru.job4j.task3_2;

/**
* Human class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 16.02.2017
*/
public class Human {

	/**
	* Name of Human.
	*/
	private String name;

	/**
	* Age of Human.
	*/
	private short age;

	/**
	* Sex of Human.
	*/
	private boolean sex;

	/**
	* Recreating constructor of class Human with varibales of class Human.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, frmale is false
	*/
	public Human(String name, short age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
}