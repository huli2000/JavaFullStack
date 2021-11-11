package coupon.tests;

import coupons.core.beans.Company;
import coupons.core.dao.CompanyDao;
import coupons.core.dao.CompanyDaoDb;
import coupons.core.exceptions.CouponSystemException;

public class Test2CompanyDao {
	
	public static void main(String[] args) {
		
		try {
	Company company = new Company ("CCC", "ccc@mail", "cccPass");
	CompanyDao companydao = new CompanyDaoDb();
	int companyId = companydao.addCompany(company);
	System.out.println("company added. id" + companyId);
	}catch (CouponSystemException e) {
		e.printStackTrace();
	}
	}

}
