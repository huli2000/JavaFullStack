package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;

@SpringBootApplication
public class App4 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App4.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// ==========================

		try {
			Company company = em.find(Company.class, 1);
			if (company != null) {
				Address address = company.getAddress();
				System.out.println(company);
				System.out.println(address);
				
				
				System.out.println("===============");
				System.out.println("is company persistant? " + em.contains(company));
				System.out.println("is address persistant? " + em.contains(address));
				System.out.println("===============");
				em.detach(company);
				System.out.println("===============");
				System.out.println("is company persistant? " + em.contains(company));
				System.out.println("is address persistant? " + em.contains(address));
				System.out.println("===============");
				
				company = em.merge(company);
				address = company.getAddress();
				System.out.println("===============");
				System.out.println("is company persistant? " + em.contains(company));
				System.out.println("is address persistant? " + em.contains(address));
				System.out.println("===============");
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
