
public class Company {
	
	private String name;
	private User[] users;
	
	
	public Company(String name) {
		
		this.name = name;
		users = new User[10];
}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public User[] getUsers() {
		return users;
	}


	public void setUsers(User[] users) {
		this.users = users;
	}
	
	
	
	

}
