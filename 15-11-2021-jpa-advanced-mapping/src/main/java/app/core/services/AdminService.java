package app.core.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.repo.CompanyRepo;

@Service
@Transactional
public class AdminService {
	@Autowired
	private CompanyRepo companyRepo;

	public int addCompany(Company company) {
		company = companyRepo.save(company);
		return company.getId();
	}
	public Company getCompanyById (int companyId) {
		Optional<Company> opt = this.companyRepo.findById(companyId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new RuntimeException("Company wth id " + companyId + "not found");
		}
	}
}
