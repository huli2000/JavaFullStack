package app.core;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Employee;
import app.core.entities.Job;
import app.core.repo.EmployeeRepo;
import app.core.service.CompanyService;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
		CompanyService service = ctx.getBean(CompanyService.class);

		try {

//			Employee e1 = new Employee(0, "Moshe", 15400, "CodeCreation");
//			service.insertEmployee(e1);
//			Employee e2 = new Employee(0, "Avi", 7400, "CopyJob");
//			service.insertEmployee(e2);

			List<Employee> employees = service.getEmployees();
			System.out.println(employees);

			List<Employee> employeesByName = service.getEmployeesByName("Moshe");
			System.out.println(employeesByName);

			List<Job> listAllJobs = service.getAllJobs();
			System.out.println(listAllJobs);

//			List<Job> listAllJobsByEndDate = service.findByEndDate("12-10-2021");
//			System.out.println(listAllJobsByEndDate);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
