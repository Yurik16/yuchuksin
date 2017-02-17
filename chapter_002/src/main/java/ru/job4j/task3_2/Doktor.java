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
	* @param patient human who fill illness
	* @return setDisease get report
	*/
	public String diagnostic(Patient patient) {
		return patient.setDisease("Tupojkakdrova");
	}

	/**
	* operation treatment process.
	* @param patient human who fill illness and get diagnostic
	* @return setHealth how patient filles himself after operation
	*/
	public byte operation(Patient patient) {
		return patient.setHealth((byte) 100);
	}
}