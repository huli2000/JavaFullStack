package a.Targil;

public class Manager extends Employee {

	public Manager() {
	}

	public Manager(String first, String last, double salary, String department) {
		super(first, last, salary, department);
	}

	@Override
	public String toString() {
		return "Manager [First()=" + getFirst() + ", Last()=" + getLast() + ", Salary()=" + getSalary()
				+ ", Department()=" + getDepartment() + "]";
	}
	


}
