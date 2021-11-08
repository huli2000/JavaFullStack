package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Person;
import app.core.services.PersonService;

@SpringBootApplication
public class Application3Service {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application3Service.class, args);

		PersonService personService = ctx.getBean(PersonService.class);

		personService.add(new Person(0, "yubal", 22));
		personService.add(new Person(0, "moshe", 23));
		personService.add(new Person(0, "eli", 52));

	}

}
