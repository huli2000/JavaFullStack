package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Company;

@SpringBootApplication
public class App2 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App2.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			Company company = em.find(Company.class, 2);
			if (company != null) {
				System.out.println(company);
				System.out.println(company.getAddress());

				em.remove(company);
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
