package app.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;
import app.core.repo.CompanyRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(Application.class, args);
		
		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
		
		Company company = new Company(0, "Google", "google@gmail.com", new Address(0, "Jerusalem", "Israel"));
		companyRepo.save(company);
		Optional <Company> opt = companyRepo.findById(1);
		if (opt.isPresent()) {
		
			
			Company company = opt.get() ;
			System.out.println(company);
			System.out.println(company.getAddress());
		}else {
			System.out.println("company not found");
		}
		
		companyRepo.deleteById(1);
		
	}
	{ 
		
	}

}
