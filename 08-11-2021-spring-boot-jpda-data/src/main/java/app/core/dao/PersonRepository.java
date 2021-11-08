package app.core.dao;

import java.util.List;

import app.core.entities.Person;

public interface PersonRepository {

	int create(Person person);

	Person read(int personId);

	List<Person> readAll();

	boolean update(Person person);

	boolean delete(int personId);

}
