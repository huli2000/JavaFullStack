package coupons.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.PreparedStatement;
import coupons.core.beans.Company;
import coupons.core.db.ConnectionPool;
import coupons.core.exceptions.CouponSystemException;

public class CompanyDaoDb implements CompanyDao {

	@Override
	public int addCompany(Company company) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "insert into company values (0, ? , ? , ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			// add the company
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.executeUpdate();
			// get auto generate id for the newly added company

			ResultSet rsKey = pstmt.getGeneratedKeys();
			rsKey.next();
			int id = rsKey.getInt(1);
			return id;

		} catch (Exception e) {
			throw new CouponSystemException("addCompany failed", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
	}

	@Override
	public void deleteCompany(int companyId) throws CouponSystemException {

	}

}
