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
public class App51 {

	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ctx = SpringApplication.run(App51.class, args);
		AdminService adminService = ctx.getBean(AdminService.class);
		Company company = adminService.getCompanyById(1);
		System.out.println(company);
		System.out.println(company.getAddress());
		
}
}