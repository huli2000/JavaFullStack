package coupons.core.dao;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public interface CompanyDao {

	/** 
	 * @param company the company to be added to the data storage
	 * @return the id that was auto generated for this company
	 */
	

	int addCompany(Company company) throws CouponSystemException; 
	
	void deleteCompany (int companyId) throws CouponSystemException;
}

