package ru.job4j.task3_2;

/**
* Patient class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Patient extends Human {

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
	* setDisease set disease.
	* @param report document with illness name
	* @return this.disease
	*/
	public String setDisease(String report) {
		this.disease = report;
		return this.disease;
	}

	/**
	* setHealth set Health.
	* @param result from 0 to 100
	* @return this.health
	*/
	public byte setHealth(byte result) {
		this.health = result;
		return this.health;
	}

	/**
	* Patient constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, frmale is false
	* @param disease illness
	* @param temp normal 36.6
	* @param press normal 110.70
	* @param health from 0 - death to 100 - healthy
	*/
	public Patient(String name, short age, boolean sex, String disease, float temp, float press, byte health) {
		super(name, age, sex);
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