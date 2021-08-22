package a.Targil;

import java.util.List;

public class EmployeeStatistics {

	public static double averageSalary(List<? extends Employee> employees) throws RuntimeException {
		double sum = 0;
		int n = 0;
		for (Employee currEmp : employees) {
			if (currEmp != null) {
				sum += currEmp.getSalary();
				n++;
			}
		}
		if (n > 0) {
			double avg = sum / n;
			return avg;
		} else {
			throw new RuntimeException("no avg - list is empty");
		}
	}

	public static int getNumberOfEmployee(List<? extends Employee> employees) {
		int n = 0;
		for (Employee currEmp : employees) {
			if (currEmp != null) {
				n++;
			}
		}
		return n;
	}

	public static int getNumberOfEmployee(List<? extends Employee> employees, String department) {
		int n = 0;
		for (Employee currEmp : employees) {
			if (currEmp != null && currEmp.getDepartment().equals(department)) {
				n++;
			}
		}
		return n;
	}
}