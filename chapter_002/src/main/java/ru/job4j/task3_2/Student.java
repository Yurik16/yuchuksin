package ru.job4j.task3_2;

/**
* Student class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Student extends Human {

	/**
	* course from 1 to 5.
	*/
	private byte course;

	/**
	* specialty some technical or another.
	*/
	private String specialty;

	/**
	* educMark list for each lesson sudent gets mark.
	*/
	private byte educMark;

	/**
	* knowlegwLevel form 1 to 100.
	*/
	private byte knowlegwLevel;

	/**
	* setEducMark set educMark for student.
	* @param mark form 1 to 10
	* @return educMark
	*/
	public byte setEducMark(byte mark) {
		this.educMark = mark;
		return this.educMark;
	}

	/**
	* setRank set knowlegwLevel for student.
	* @param mark form 1 to 100
	* @return knowlegwLevel
	*/
	public byte setRank(byte mark) {
		this.knowlegwLevel = mark;
		return this.knowlegwLevel;
	}

	/**
	* Student constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, frmale is false
	* @param course from 1 to 5
	* @param specialty some technical or another
	* @param educMark list of marks for each lesson
	* @param knowlegwLevel form 1 to 100
	*/
	public Student(String name, short age, boolean sex, byte course, String specialty, byte educMark, byte knowlegwLevel) {
		super(name, age, sex);
		this.course = course;
		this.specialty = specialty;
		this.educMark = educMark;
		this.knowlegwLevel = knowlegwLevel;
	}

	/**
	* selfLearning.
	*/
	public void selfLearning() {

	}
}