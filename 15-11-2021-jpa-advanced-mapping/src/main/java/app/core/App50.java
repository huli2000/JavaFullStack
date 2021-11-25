package app.core;

import app.core.services.AdminService;
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

@SpringBootApplication
public class App50 {

	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ctx = SpringApplication.run(App50.class, args);
		AdminService adminService = ctx.getBean(AdminService.class);
		Company company = new Company(0,"apple", "apple@mail.com", null);
		adminService.addCompany(company);
}
}