package coupon.tests;

import coupons.core.db.ConnectionPool;
import coupons.core.exceptions.CouponSystemException;

public class Test1pool {
	
	public static void main(String[] args) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}
		
	}

}
