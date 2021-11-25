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
public class App11 {

	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ctx = SpringApplication.run(App11.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			Customer cus1 = new Customer (0, "aaa", "aaa@mail.com");
			Customer cus2 = new Customer (0, "bbb", "bbb@mail.com");
			Customer cus3 = new Customer (0, "ccc", "ccc@mail.com");
			
			Coupon coup1 = new Coupon(0, "xxx");
			Coupon coup2 = new Coupon(0, "ccc");
			Coupon coup3 = new Coupon(0, "rrr");
			Coupon coup4 = new Coupon(0, "ttt");
			Coupon coup5 = new Coupon(0, "qqq");
			
			em.persist(cus3);
			em.persist(cus2);
			em.persist(cus1);
			
			em.persist(coup5);
			em.persist(coup3);
			em.persist(coup4);
			em.persist(coup2);
			em.persist(coup1);
			
			
			
			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
