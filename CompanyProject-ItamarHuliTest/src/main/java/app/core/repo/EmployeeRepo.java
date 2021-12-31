package app.core.repo;
import app.core.entities.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Long> {
	
	public static List<Employee> findByName(String name) {
		return null;
	}

	public <S> S save(Employee employee) ;

	public List<Employee> findAll();


	public Optional<Employee> findById(Long id);
	

}
