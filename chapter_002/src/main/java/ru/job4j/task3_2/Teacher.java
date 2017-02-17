package ru.job4j.task3_2;

/**
* Teacher class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 16.02.2017
*/
public class Teacher extends Profession {

	/**
	* Teacher constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, female is false
	* @param educ graduate from "under school" till "professor"
	* @param exp practice in years
	* @param spec with what knowlege person do his job
	* @param salary earn money per month
	*/
	public Teacher(String name, short age, boolean sex, String educ, byte exp, String spec, int salary) {
		super(name, age, sex, educ, exp, spec, salary);
	}

	/**
	* teach student learn some knowlege and than get mark.
	* param time how many hours lesson last
	* param student person that wants to learn
	*/
	public void teach() { //returns byte (mark) but temporarily make this method void

	}

	/**
	* examine resalt teach process.
	* param student person that wants to learn
	*/
	public void examine() { //returns int (rating) but temporarily make this method void

	}
}