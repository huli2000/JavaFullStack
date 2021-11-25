package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;

@SpringBootApplication
public class App3 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App3.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// ==========================

		try {
			Address address = em.find(Address.class, 1);
			if (address != null) {
				System.out.println(address);
				System.out.println(address.getCompany());
			}

			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
