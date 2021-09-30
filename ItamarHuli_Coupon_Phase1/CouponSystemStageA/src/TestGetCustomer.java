import db.dao.CustomerDBDao;
import db.dao.CustomerDao;
import db.ex.NoSuchCouponException;
import db.ex.NoSuchCustomerException;
import model.Customer;


public class TestGetCustomer {
    public static void main(String[] args) {
        CustomerDao dao = new CustomerDBDao();

        Customer customer = null;
        try {
            customer = dao.getCustomer(2);
            System.out.println(customer);
        }
        catch (NoSuchCustomerException | NoSuchCouponException ex) {
            ex.printStackTrace();
        }
    }
}
