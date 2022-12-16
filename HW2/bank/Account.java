package bank;

public class Account {
	private String name;
	private int balance;

	//constructor to initialize fields
	public Account(String name) {
		this.name = name;
		balance = 0;
	}
//returns balance
	public int getShekels() {
		return balance;
	}
//returns name
	public String getName() {
		return name;
	}
//adjusts balance
	public void add(int amount) {
		balance += amount;
	}
//returns formated output
	public String toString() {
		return name + " has " + balance + " shekels";
	}

}
