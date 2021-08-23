package a.Targil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {

	// a pool of random data
	private static String[] firstNames = { "Eli", "David", "Yosi", "Dafna", "Mira", "John", "Ann" };
	private static String[] lastNames = { "Levi", "Kohen", "Israeli", "Avrahami", "Johns", "Smith" };
	private static String[] departments = { "Legal", "Sales", "Tecnical", "Customers" };

	public static void main(String[] args) {
		// get a list of random employees
		List<Employee> list = getRandomEmployees(15);
		// print the list
		print(list);
		// print statistic data using the EmployeeStatistics class
		System.out.println("total employees: " + EmployeeStatistics.getNumberOfEmployee(list));
		System.out.println("total legal employees: " + EmployeeStatistics.getNumberOfEmployee(list, "Legal"));
		System.out.println("total Sales employees: " + EmployeeStatistics.getNumberOfEmployee(list, "Sales"));
		System.out.println("total Tecnical employees: " + EmployeeStatistics.getNumberOfEmployee(list, "Tecnical"));
		System.out.println("total Customers employees: " + EmployeeStatistics.getNumberOfEmployee(list, "Customers"));
		System.out.println("total average: " + EmployeeStatistics.averageSalary(list));

		System.out.println("===============================");
		// managers
		List<Manager> managers = getRandomManagers(5);
		print(managers);
		System.out.println("total managers: " + EmployeeStatistics.getNumberOfEmployee(managers.subList(0, 0)));
		System.out.println("total legal employees: " + EmployeeStatistics.getNumberOfEmployee(managers, "Legal"));
		System.out.println("total Sales employees: " + EmployeeStatistics.getNumberOfEmployee(managers, "Sales"));
		System.out
				.println("total Tecnical employees: " + EmployeeStatistics.getNumberOfEmployee(managers, "Tecnical"));
		System.out.println(
				"total Customers employees: " + EmployeeStatistics.getNumberOfEmployee(managers, "Customers"));
		System.out.println("total average: " + EmployeeStatistics.averageSalary(managers));

	}

	public static void print(Collection<? extends Employee> list) {
		System.out.println("===== list =====");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		System.out.println("=====------=====");
	}

	public static List<Employee> getRandomEmployees(int number) {
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < number; i++) {
			if (Math.random() < 0.8) {
				employees.add(getRandomEmployee());
			} else {
				employees.add(getRandomManager());
			}
		}
		return employees;
	}

	public static List<Manager> getRandomManagers(int number) {
		List<Manager> managers = new ArrayList<Manager>();
		for (int i = 0; i < number; i++) {
			managers.add(getRandomManager());
		}
		return managers;
	}

	public static Employee getRandomEmployee() {
		// create random values for Employee CTOR
		String first = firstNames[(int) (Math.random() * firstNames.length)];
		String last = lastNames[(int) (Math.random() * lastNames.length)];
		double salary = (int) (Math.random() * 5000);
		String department = departments[(int) (Math.random() * departments.length)];
		// create an Employee from the random values
		Employee e = new Employee(first, last, salary, department);
		return e;
	}

	public static Manager getRandomManager() {
		// create random values for Employee CTOR
		String first = firstNames[(int) (Math.random() * firstNames.length)];
		String last = lastNames[(int) (Math.random() * lastNames.length)];
		double salary = (int) (Math.random() * 5000);
		String department = departments[(int) (Math.random() * departments.length)];
		// create an Employee from the random values
		Manager m = new Manager(first, last, salary, department);
		return m;
	}

}
