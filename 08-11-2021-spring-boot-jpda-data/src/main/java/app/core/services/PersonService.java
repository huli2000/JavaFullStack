package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.dao.PersonRepository;
import app.core.entities.Person;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepo;

	public int add(Person preson) {
		return personRepo.create(preson);

	}

	public Person find(int personId) {
		return this.personRepo.read(personId);

	}

	public List<Person> readAll() {
		return this.personRepo.readAll();
	}
}
