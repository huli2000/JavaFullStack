import db.dao.CustomerDBDao;
import db.dao.CustomerDao;
import db.ex.NoSuchCustomerException;


public class TestDeleteCustomer {
    public static void main(String[] args) {
        CustomerDao dao = new CustomerDBDao();

        try {
            dao.removeCustomer(11);
            System.out.println("Deleted successfully!");
        }
        catch (NoSuchCustomerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
