package ru.job4j.task3_2;

/**
* Profession class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 16.02.2017
*/
public class Profession extends Human {

	/**
	* Education graduate from "under school" till "professor".
	*/
	private String education;

	/**
	* experience practice in years.
	*/
	private byte experience;

	/**
	* specialty with what knowlege person do his job.
	*/
	private String specialty;

	/**
	* salary earn money per month.
	*/
	private int salary;

	/**
	* Profession constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, frmale is false
	* @param educ graduate from "under school" till "professor"
	* @param exp practice in years
	* @param spec with what knowlege person do his job
	* @param salary earn money per month
	*/
	public Profession(String name, short age, boolean sex, String educ, byte exp, String spec, int salary) {
		super(name, age, sex);
		this.education = educ;
		this.experience = exp;
		this.specialty = spec;
		this.salary = salary;
	}
}