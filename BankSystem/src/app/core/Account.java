package app.core;

public class Account {

	private int id;
	private float balance;
	
	public Account(int id, float balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
		Log log1 = new Log(12323123, 123, "deposit", 25000);
		System.out.println(log1.getData());

	}
	
	
	
}
