package app.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;
import app.core.exceptions.PersonAppException;
import app.core.repo.PersonRepo;

@Service
@Transactional
public class PersonService {

	private PersonRepo personRepo;

	public PersonService(PersonRepo personRepo) {
		super();
		this.personRepo = personRepo;
	}

	public int add(Person person) {
		this.personRepo.save(person);
		return person.getId();
	}

	public Person get(int personId) throws PersonAppException {
		Optional<Person> opt = this.personRepo.findById(personId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new PersonAppException("get person with id " + personId + " failed:NOT FOUND");
		}
	}

	public List<Person> getAll() {
		return this.personRepo.findAll();

	}

	public boolean update(Person person) throws PersonAppException {
		
		try {
			Person personFromDb = get(person.getId());
			personFromDb.setName(person.getName());
			personFromDb.setAge(person.getAge());
		} catch (PersonAppException e) {
		throw new PersonAppException("update failed", e);
		}

	public void delete (int personId) {
		try {
			 
			 Person p = get(personId);
			 if (p!=null) {
				 this.personRepo.deleteById(personId);
		} catch (PersonAppException e) {
		
			throw new PersonAppException("delete failed", e);

		}
		
		
		
			
		
	}
