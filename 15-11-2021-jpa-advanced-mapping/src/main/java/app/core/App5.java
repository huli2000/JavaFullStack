package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;

@SpringBootApplication
public class App5 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App5.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			Company company = em.find(Company.class, 4);
			if (company != null) {
				Address address = company.getAddress();
				
				company.setAddress(null);
				em.remove(address);
				System.out.println("deleted");
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
