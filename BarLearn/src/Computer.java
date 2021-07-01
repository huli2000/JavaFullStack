
public class Computer {

	private String name;
	private int ipAddress;
	private User user;
	
	
	public Computer(String name, int ipAddress, User user) {
	
		this.name = name;
		this.ipAddress = ipAddress;
		this.user = user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(int ipAddress) {
		this.ipAddress = ipAddress;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
