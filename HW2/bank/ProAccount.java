package bank;

public class ProAccount extends Account {

	private int[] transactionLog;
	private int index;
//constructor to to initialize the fields and create an empty transcation log
	public ProAccount(String name) {
		super(name);
		transactionLog = new int[100];
		index = 0;
	}
//adjusts balance and saves it in the transaction log
	public void add(int amount) {
		super.add(amount);
		transactionLog[index++] = super.getShekels();
	}
//returns account name and transaction log
	public String toString() {
		StringBuilder transactions = new StringBuilder(" [");
		for (int i = 0; i < index - 1; i++) {
			transactions.append(transactionLog[i] + ",");
		}
		transactions.append(transactionLog[index - 1] + "]");
		return super.toString() + transactions;
	}
//transfers money from one account to another
	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(-1 * (amount));
		to.add(amount);
	}

}
