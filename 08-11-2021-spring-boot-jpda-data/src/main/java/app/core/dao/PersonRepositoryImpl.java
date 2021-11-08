package app.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import app.core.entities.Person;

@Repository

public class PersonRepositoryImpl implements PersonRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int create(Person person) {
		em.persist(person);
		return person.getId();
	}

	@Override
	public Person read(int personId) {
		return em.find(Person.class, personId);

	}

	@Override
	public List<Person> readAll() {
		TypedQuery<Person> query = em.createQuery("from Person", Person.class);
		return query.getResultList();
	}

	@Override
	public boolean update(Person person) {
		Person personFromDb = read(person.getId());
		if (personFromDb != null) {
			personFromDb.setAge(person.getAge());
			personFromDb.setName(person.getName());

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(int personId) {
		Person personFromDb = read(personId);
		if (personFromDb != null) {
			em.remove(personFromDb);
			return true;
		}

		return false;
	}

}
