
public class App {

	public static void main(String[] args) {

		Company company = new Company("Ozar");
		System.out.println(company.getName());
		
		User user = new User(101, "Moshe", 30);
		Computer computer = new Computer("L1487",192168101,user );
		
		String cn = user.addComputer(computer);
		System.out.println(cn);
		
		System.out.println(user.printUser());
		
//		user.printName();
		user.setAge(35);
		System.out.println(user.getAge());
		
	}

}
