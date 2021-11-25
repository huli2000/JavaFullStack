package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;

@SpringBootApplication
public class App1 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App1.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			// create 3 companies with addresses and save:
			Address a1 = new Address(0, "Herzel", 25, "Jerusalem", "Israel");
			Company c1 = new Company(0, "aaa", "aaa@mail", a1);

			Address a2 = new Address(0, "Ben Gurion", 32, "Tel Aviv", "Israel");
			Company c2 = new Company(0, "bbb", "bbb@mail", a2);

			Address a3 = new Address(0, "Begin", 12, "Haifa", "Israel");
			Company c3 = new Company(0, "ccc", "ccc@mail", a3);

			em.persist(c1);
			em.persist(c2);
			em.persist(c3);

			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
