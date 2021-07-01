package app.core;

public class Client {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts = new Account[5];
	private float commisionRate = 0;
	private float interestRate = 0;
	private Logger logger;
	
	
	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.logger = new Logger(name);
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	public Account[] getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account account) {
		
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account;
				Log log2 = new Log(1231561, this.id, "account has been added",3500);
				logger.log(log2);
				break;
			}
		}
	}
	public Account getAccount(int index) {
		if (accounts[index] != null) {
			return accounts[index];
		}
		return null;
	}
	public void removeAccount (int id) {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getId() == id) {
				accounts[i] = null ;
			}
		}
			
			
		}
	
}

