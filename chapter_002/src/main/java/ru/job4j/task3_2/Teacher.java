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
	* @param time how many hours lesson last
	* @param student person that wants to learn
	* @return student.setEducMark() from 0 to 10
	*/
	public byte teach(int time, Student student) {
		return student.setEducMark((byte) 22); //typing random 22 just for javac
	}

	/**
	* examine resalt teach process.
	* @param student person that wants to learn
	* @param subject what kind of
	* @return student.setRank() form 0 to 10000
	*/
	public byte examine(String subject, Student student) {
		return student.setRank((byte) 22); //typing random 22 just for javac
	}
}