package app.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Student;

public interface StudentRepo  extends JpaRepository<Student, Integer>{
	
	List <Student> findByActiveTrue();
	List <Student> findByActiveFalse();
	//derived method
	List <Student> findByName (String name);
	
	long countByName(String name);
	
	//JPQL
	@Query("from Student where gender='F'")
		List <Student> getFemales();
	
	@Query ("select t.name from Student t")
	List <String> getNames();
	
	//native SQL
	@Query (value = "select * from students where gender='M' ", nativeQuery = true)
	List <Student> getMales();
	
	@Query ("from Student where age > :minAge")
	List <Student> getOlderThan (int minAge);
	
	
	
	
}
