package app.core;

import java.util.Iterator;

public class Bank {

	private float balance;
	private Client[] clients = new Client[100];
	private Logger logger = new Logger(null);
	Object accountsUpdater;
	
	
	public float getBalance() {
		return balance;
	}
	
	
	public float getClientFortune() {
		float fortune = 0;
		for (int i = 0; i < clients.length; i++) {
			if(clients[i] != null) {
				fortune += clients[i].getFortune();
				}
		}
		return fortune;
			}
	
	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				this.clients[i] = client;
//				logger ===================
				Log log = new Log(System.currentTimeMillis(),client.getId(),"add client", client.getFortune());
				logger.log(log);
//				==========================
				return;
			}
			
		}
		System.out.println("add client failed = Bank has 100 clients already");
	}
	public void removeClient(int clientId) {
				for (int i = 0; i < clients.length; i++) {
					if (clients[i] != null && clients[i].getId()==clientId) {	
						Client client = clients[i];
						clients[i] = null;
//						logger ===================
						Log log = new Log(System.currentTimeMillis(),client.getId(),"removeClient", -client.getFortune());
						logger.log(log);
//						==========================		
						return;
					}
					
				}
		System.out.println("ckinet with id " + clientId + "not found");
		
	}
	
	public Client[] getClients() {
		return clients;
	}
	
	public void viewLogs() {
		System.out.println("not supported");
		
	}
	
	public void startAccountUpdater () {
		System.out.println("not supported");

	}
}


