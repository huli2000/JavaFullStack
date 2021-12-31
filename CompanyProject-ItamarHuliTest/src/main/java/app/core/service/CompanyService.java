package app.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.entities.Employee;
import app.core.entities.Job;
import app.core.repo.EmployeeRepo;
import app.core.repo.JobRepo;

@Service
@Transactional
public class CompanyService {

	private EmployeeRepo employeeRepo;
	private JobRepo jobRepo;

	public void insertEmployee(Employee employee) throws Exception {
		if (employee != null) {
			List<Employee> employees = employeeRepo.findAll();
			if (employee.getName().equals(employees)) {
				return employeeRepo.save(employee);
			} else {
				throw new Exception("Employee already in data-source");

			}
		}
	}

	public Optional<Employee> getEmployee(Long id) {
		if (id > 0) {
			return employeeRepo.findById(id);
		}
		return Optional.empty();
	}

	public List<Employee> getEmployeesByName(String name) {
		return EmployeeRepo.findByName(name);
	}

	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	public List<Job> getAllJobs() {
		return jobRepo.findAll();

	}

	public List<Job> findByEndDate(LocalDate endDate) {
		return jobRepo.findByEndDate(endDate);
	}
}