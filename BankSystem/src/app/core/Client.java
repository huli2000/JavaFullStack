package app.core;

import java.util.Iterator;

public class Client {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts = new Account[5];
	private float commisionRate = 0;
	private float interestRate = 0;
	private Logger logger = new Logger(null);
	
	
	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		
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
				// log this operation
				long timestamp = System.currentTimeMillis();
				int clientId = this.id;
				String description = "Add Account";
				float amount = account.getBalance();
										
				Log log2 = new Log(timestamp, clientId, description,amount);
				//2.use the logger to save/print to screen
				logger.log(log2);
				return;
			}
		}
		//if the array is full
		System.out.println("Array account failed - array account full for account id " + account.getId());
	}
	public Account getAccount(int index) {
		if (index >=0 && index<accounts.length) {
			return accounts[index];
		}
		return null;
	}
	public void removeAccount (int accountId) {
		for (int i = 0; i < accounts.length; i++) {
			Account account = accounts[i];
				if (account != null && account.getId() == accountId);
					accounts[i] = null;
					balance += account.getBalance();
					
					long timestamp = System.currentTimeMillis();
					int clientId = this.id;
					String description = "Remove Account";
					float amount = account.getBalance();
											
					Log log3 = new Log(timestamp, clientId, description,amount);
					//2.use the logger to save/print to screen
					logger.log(log3);
								
			}
		System.out.println("removeAccount failed " + accountId + " not found");
		}

	public void deposit(float amount) {
		float commision = this.commisionRate*amount;
		this.balance += amount ;
		this.balance -= commision;
		
		long timestamp = System.currentTimeMillis();
		int clientId = this.id;
		String description = "deposit";	
		Log log = new Log(timestamp, clientId, description,amount);
		//2.use the logger to save/print to screen
		logger.log(log);
		
	}
	
	public void withdraw(float amount) {
		float commision = this.commisionRate*amount;
		this.balance += amount ;
		this.balance -= commision;
		
		Log log = new Log(System.currentTimeMillis(), this.id, "withdraw",amount);
		logger.log(log);
				
		}
	
	public void autoUpdateAccounts() {
		for (int i = 0; i < accounts.length; i++) {
		if (accounts[i] != null) {
				
				float interest = accounts[i].getBalance()* this.interestRate;
				accounts[i].setBalance(accounts[i].getBalance() + interest);
				
				Log log = new Log(System.currentTimeMillis(), this.id, "autoUpdateAccounts",interest);
				logger.log(log);
			}
			
		}
		
		
	}
	
	public float getFortune() {
		float fortune = getBalance();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				fortune += accounts[i].getBalance();
				
			}
		}
		return fortune;
		
	}
	
}

