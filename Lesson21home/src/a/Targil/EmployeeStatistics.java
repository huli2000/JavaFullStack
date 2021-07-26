package a.Targil;

import java.util.List;

public class EmployeeStatistics {

	public static double aveargeSalary(List<Employee> employees) throws RuntimeException {
		double sum = 0;
		// number of employees
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
}
