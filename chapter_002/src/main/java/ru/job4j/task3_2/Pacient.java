package ru.job4j.task3_2;

/**
* Pacient class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Pacient extends Human {

	/**
	* Creating Human object for using it`s var fields.
	*/
	private Human human = new Human();

	/**
	* disease illness name.
	*/
	private String disease;

	/**
	* temperature normal 36.6.
	*/
	private float temperature;

	/**
	* pressure normal 110.70.
	*/
	private float pressure;

	/**
	* health from 0 - death to 100 - healthy.
	*/
	private byte health;

	/**
	* Pacient constructor.
	* @param obj object of class Human
	* @param disease illness name
	* @param temp normal 36.6
	* @param press normal 110.70
	* @param health from 0 - death to 100 - healthy
	*/
	public Pacient(Human obj, String disease, float temp, float press, byte health) {
		super(this.human.name, this.human.age, this.human.sex);
		this.disease = disease;
		this.temperature = temp;
		this.pressure = press;
		this.health = health;
	}

	/**
	* lifeCycle.
	*/
	public void lifeCycle() {

	}
}