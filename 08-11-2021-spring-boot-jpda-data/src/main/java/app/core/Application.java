package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Person;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		EntityManagerFactory emFactory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emFactory.createEntityManager();

		try {
			em.getTransaction().begin(); // start the transaction

			Person p = new Person(0, "dan", 25);
			Person p1 = new Person(0, "moshe", 33);
			Person p2 = new Person(0, "eli", 44);
			em.persist(p); // save the person to DB
			em.persist(p1);
			if (Math.random() < 0.8) {
				throw new RuntimeException("testing....");
			}
			em.persist(p2);
			em.getTransaction().commit(); // end the transaction
			System.out.println("commited");
		} catch (Exception e) {
			em.getTransaction().rollback(); // end the transaction
			e.printStackTrace();
		}

	}

}
