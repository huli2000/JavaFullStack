package app.core;

import java.util.ArrayList;
import java.util.List;
import app.core.entities.Review;
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
public class App6 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App6.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			Coupon coupon = new Coupon(0, "Food");
			
			List<Review> reviews = new ArrayList<>(); 
			reviews.add(new Review(0, "Very Good"));
			reviews.add(new Review(0, "Good"));
			reviews.add(new Review(0, "Bad"));
			
			coupon.setReviews(reviews);;
			
			em.persist(coupon);
			
			
			
			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
