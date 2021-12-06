package app.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

	
}
