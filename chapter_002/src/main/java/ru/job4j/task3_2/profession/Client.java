package ru.job4j.task3_2.profession;

/**
* Client class.
* @author Yury Chuksin (chuksinyury.gmail.com)
* @since 17.02.2017
*/
public class Client extends Human {

	/**
	* bankAccount amoynt of money.
	*/
	private int bankAccount;

	/**
	* wishes what client wants.
	*/
	private String wishes;

	/**
	* satisfaction happyness of client from 0 to 100.
	*/
	private byte satisfaction;

	/**
	* setSatisfactoin seting satisfaction.
	* @param documentation per cent of finishing work
	* @return this.satisfaction
	*/
	public byte setSatisfactoin(byte documentation) {
		this.satisfaction = documentation;
		return this.satisfaction;
	}

	/**
	* setBankAcc seting bankAccount.
	* @param answer payment for consultation
	* @return this.bankAccount
	*/
	public int setBankAcc(int answer) {
		this.bankAccount = this.bankAccount - answer;
		return this.bankAccount;
	}

	/**
	* Client constructor.
	* @param name family
	* @param age from 1 to 150
	* @param sex male is true, frmale is false
	* @param bankAccount amoynt of money
	* @param wishes what client wants
	* @param satisfaction happyness of client from 0 to 100
	*/
	public Client(String name, short age, boolean sex, int bankAccount, String wishes, byte satisfaction) {
		super(name, age, sex);
		this.bankAccount = bankAccount;
		this.wishes = wishes;
		this.satisfaction = satisfaction;
	}
}