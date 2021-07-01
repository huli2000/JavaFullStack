import java.util.Arrays;



public class User {

	
	private int id;
	private String name;
	private int age;
	private Computer[] computers;
	
	
	public User(int id, String name, int age) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.computers = new Computer[5];
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Computer[] getComputers() {
		return computers;
	}


	public void setComputers(Computer[] computers) {
		this.computers = computers;
	}
	
	public void printName() {
		System.out.println(this.name);
	}
	
//	public void printUser() {
//		System.out.println(this.toString());
//	}


	public String printUser() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", computers=" + Arrays.toString(computers) + "]";
	}
	
	public String addComputer(Computer computer) {
		
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] == null) {
				computers[i] = computer;
				break;
			}
		}
	
		return computer.getName();
		
	}
}
	

