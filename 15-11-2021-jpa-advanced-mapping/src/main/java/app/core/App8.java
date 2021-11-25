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
import app.core.entities.Review;

@SpringBootApplication
public class App8 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App8.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			University barIlan = new University(0, "Bar Ilan", "Israel");
			University Hebrew = new University(0, "Hebrew", "Israel");
			University TelAviv = new University(0, "TLV", "Israel");
			
			em.persist(TelAviv);
			em.persist(Hebrew);
			em.persist(barIlan);
			
			Student st1 = new Student(0, "aaa", barIlan);
			Student st2 = new Student(0, "bbb", barIlan);
			Student st3 = new Student(0, "ccc", barIlan);
			
			Student st4 = new Student(0, "ddd", TelAviv);
			Student st5 = new Student(0, "eee", TelAviv);
			
			Student st6 = new Student(0, "ggg", Hebrew);
			Student st7 = new Student(0, "qqq", Hebrew);
			
			em.persist(st1);
			em.persist(st2);
			em.persist(st3);
			em.persist(st4);
			em.persist(st5);
			em.persist(st6);
			em.persist(st7);
			
		
			
			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
