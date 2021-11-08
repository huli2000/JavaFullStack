package app.core;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.PersonRepository;
import app.core.entities.Person;

@SpringBootApplication
public class Application2Dao {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application2Dao.class, args);

		PersonRepository personDao = ctx.getBean(PersonRepository.class);
//		personDao.create(new Person(0, "aaa", 22));
//		personDao.create(new Person(0, "bbb", 23));
//		personDao.create(new Person(0, "ccc", 52));

//		personDao.delete(7);
		List<Person> list = personDao.readAll();
		System.out.println("=================");
		for (Person person : list) {
			System.out.println(person);

		}
		System.out.println("=================");
	}

}
