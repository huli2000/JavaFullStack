import db.dao.CustomerDBDao;
import db.dao.CustomerDao;
import db.ex.NoSuchCustomerException;
import model.Customer;


public class TestUpdateCustomer {
    public static void main(String[] args) {
        CustomerDao dao = new CustomerDBDao();

        try {
            dao.updateCustomer(new Customer(6, "UpdatedFirstName", "UpdatedLastName", "UpdatedEmail",
                                                "UpdatedPassword"));
            System.out.println("Success!");
        }
        catch (NoSuchCustomerException e) {
            e.printStackTrace();
        }
    }
}
