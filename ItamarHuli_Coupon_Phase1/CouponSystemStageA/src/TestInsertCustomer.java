import db.dao.CustomerDBDao;
import db.dao.CustomerDao;
import db.ex.NoSuchCustomerException;
import model.Customer;


public class TestInsertCustomer {

    public static void main(String[] args) {

        CustomerDao dao = new CustomerDBDao();
        try {
            dao.createCustomer(new Customer(0, "Customer", "Test", "customer@gmail.com", "1234"));
        }
        catch (NoSuchCustomerException e) {
            System.out.println(e.getMessage());
        }
    }
}
