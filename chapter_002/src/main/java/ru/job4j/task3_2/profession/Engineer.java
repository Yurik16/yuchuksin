package ru.job4j.task3_2.profession;

/**
* Engineer class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Engineer extends Profession {

	/**
	* Engineer constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, female is false
	* @param educ graduate from "under school" till "professor"
	* @param exp practice in years
	* @param spec with what knowlege person do his job
	* @param salary earn money per month
	*/
	public Engineer(String name, short age, boolean sex, String educ, byte exp, String spec, int salary) {
		super(name, age, sex, educ, exp, spec, salary);
	}

	/**
	* work process - engineer doing his job.
	* @param client employer
	* @param time hours spending for job
	* @return setSatisfactoin
	*/
	public byte work(Client client, int time) {
		return client.setSatisfactoin((byte) time);
	}

	/**
	* consultation short answer.
	* @param client employer
	* @return setBankAcc
	*/
	public int consultation(Client client) {
		return client.setBankAcc(500);
	}
}