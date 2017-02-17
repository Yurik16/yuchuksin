package ru.job4j.task3_2;

/**
* Doktor class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Doktor extends Profession {

	/**
	* Doktor constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, female is false
	* @param educ graduate from "under school" till "professor"
	* @param exp practice in years
	* @param spec with what knowlege person do his job
	* @param salary earn money per month
	*/
	public Doktor(String name, short age, boolean sex, String educ, byte exp, String spec, int salary) {
		super(name, age, sex, educ, exp, spec, salary);
	}

	/**
	* diagnostic determines wich problems have patient.
	*/
	public void diagnostic() { //must returnes report

	}

	/**
	* operation treatment process.
	*/
	public void operation() { //must returnes result

	}
}