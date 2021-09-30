import db.ex.NoSuchCouponException;
import db.ex.NoSuchCustomerException;
import db.ex.ZeroCouponAmountException;
import facade.CustomerFacade;
import facade.ex.InvalidLoginException;
import model.Coupon;
import model.Customer;

import java.util.List;

public class TestCustomerFacade {
    public static void main(String[] args) {
        try {
            //Test Login
            System.out.println("Login:");
            CustomerFacade customerFacade = CustomerFacade.from("itamar.huli@gmail.com", "1234");
            System.out.println("Login successfully!");

            //Test purchaseCoupon
            System.out.println("purchaseCoupon:");
            boolean b = customerFacade.purchaseCoupon(1);
            if (b) {
                System.out.println("Coupon purchase!");
            } else {
                System.out.println("Can't purchase coupon...");
            }

            //Test updateCustomer
            System.out.println("updateCustomer:");
            boolean b1 = customerFacade.updateCustomer(new Customer(1, "Itamar1", "huli1", "itamar.huli@gmail.com", "1234"));
            if (b1) {
                System.out.println("Customer updated!");
            } else {
                System.out.println("cant update customer....");
            }

            //Test getAllCoupons
            System.out.println("getAllCoupons:");
            List<Coupon> allCoupons = customerFacade.getAllCoupons();
            if (allCoupons != null) {
                for (Coupon coupon : allCoupons) {
                    System.out.println(coupon.getTitle());
                }
            }

            //Test getCoupon(category)
            System.out.println("getCoupon(category):");
            List<Coupon> coupons = customerFacade.getCoupons(2);
            if (coupons != null) {
                for (Coupon coupon : coupons) {
                    System.out.println(coupon.getTitle());
                }
            }

            //Test getCouponsLowerThanPrice
            System.out.println("getCouponsLowerThanPrice:");
            List<Coupon> couponsLowerThanPrice = customerFacade.getCouponsLowerThanPrice(20);
            if (couponsLowerThanPrice != null) {
                couponsLowerThanPrice.forEach(coupon -> System.out.println(coupon.toString()));
            }

        } catch (NoSuchCustomerException ex) {
            System.out.println("Customer exception: " + ex.toString());
        } catch (InvalidLoginException ex) {
            System.out.println("Invalid Login exception: " + ex.toString());
        } catch (ZeroCouponAmountException ex) {
            System.out.println("Zero Coupon Amount exception: " + ex.toString());
        } catch (NoSuchCouponException ex) {
            System.out.println("Coupon exception: " + ex.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
