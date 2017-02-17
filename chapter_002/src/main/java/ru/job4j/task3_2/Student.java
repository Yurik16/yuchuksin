package ru.job4j.task3_2;

/**
* Student class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Student extends Human {

	/**
	* Creating Human object for using it`s var fields.
	*/
	private Human human = new Human();

	/**
	* course from 1 to 5.
	*/
	private byte course;

	/**
	* specialty some technical or another.
	*/
	private String specialty;

	/**
	* educTime count in hours.
	*/
	private int educTime;

	/**
	* educMark list for each lesson sudent gets mark.
	*/
	private byte[] educMark;

	/**
	* knowlegwLevel form 1 to 100.
	*/
	private byte knowlegwLevel;

	/**
	* Student constructor.
	* @param obj object of class Human
	* @param course from 1 to 5
	* @param specialty some technical or another
	* @param educTime count in hours
	* @param educMark list of marks for each lesson
	* @param knowlegwLevel form 1 to 100
	*/
	public Student(Human obj, byte course, String specialty, int educTime, byte[] educMark, byte knowlegwLevel) {
		super(this.human.name, this.human.age, this.human.sex);
		this.course = course;
		this.specialty = specialty;
		this.educTime = educTime;
		this.educMark = educMark;
		this.knowlegwLevel = knowlegwLevel;
	}

	/**
	* selfLearning.
	*/
	public void selfLearning() {

	}
}