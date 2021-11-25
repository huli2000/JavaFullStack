package app.core;

import java.util.ArrayList;
import java.util.List;
import app.core.entities.Review;
import app.core.entities.Student;
import app.core.entities.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.entities.Review;

@SpringBootApplication
public class App10 {

	
	public static void main(String[] args) {
		
	
		
		ApplicationContext ctx = SpringApplication.run(App10.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			
			Customer cus1 = new Customer(0, "aaaa", "aaa@mail.com")
			
			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
