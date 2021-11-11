import db.ex.NoSuchCompanyException;
import db.ex.NoSuchCouponException;
import db.ex.NoSuchCustomerException;
import facade.AdminFacade;
import facade.ex.InvalidLoginException;
import model.Company;
import model.Customer;

import java.util.List;

public class TestAdminFacade {
    public static void main(String[] args) {
        AdminFacade adminFacade;
        try {

            //Test Login
            System.out.println("Login:");
            adminFacade = AdminFacade.from("admin", "1234");
            System.out.println("Admin login successfully!");

            //Test CreateCompany
            System.out.println("CreateCompany:");
            boolean create = adminFacade.createCompany(new Company(4, "Youtube", "youtube@gmail.com", "1234"));
            if (create) {
                System.out.println("Company created!");
            } else {
                System.out.println("Already company with this name");
            }

            //Test getAllCompanies
            System.out.println("getAllCompanies:");
            List<Company> allCompanies = adminFacade.getAllCompanies();
            for (Company allCompany : allCompanies) {
                System.out.println(allCompany.getName());
            }

            //Test getCompany
            System.out.println("getCompany:");
            Company c = adminFacade.getCompany(1);
            System.out.println(c.getName());

            //Test updateCompany
            System.out.println("updateCompany:");
            boolean isUpdated = adminFacade.updateCompany(new Company(1, "Google", "goole@gmail.com", "12345"));
            if (isUpdated) {
                System.out.println("The company is updated!");
            } else {
                System.out.println("Can't change the company name!");
            }

            //Test removeCompany
            adminFacade.removeCompany(6);
            System.out.println();

            //Test createCustomer
            System.out.println("createCustomer:");
            boolean isCustomer = adminFacade.createCustomer(new Customer(1, "Itamar", "huli", "huli2000@gmail.com", "1234"));
            if (isCustomer) {
                System.out.println("Customer is been created!");
            } else {
                System.out.println("cant create customer with same email");
            }

            //Test getCustomer
            System.out.println("getCustomer:");
            Customer customer = adminFacade.getCustomer(1);
            if (customer != null) {
                System.out.println(customer.getFirstName() + " " + customer.getLastName());
            } else {
                System.out.println("Cant get any customer");
            }

            //Test updateCustomer
            System.out.println("updateCustomer:");
            boolean b = adminFacade.updateCustomer(new Customer(1, "Itamar", "huli", "itamar.huli@gmail.com", "1234"));
            if (b) {
                System.out.println("Customer as been updated!");
            } else {
                System.out.println("Cant update user");
            }

            //Test removeCustomer
            System.out.println("removeCustomer:");
            boolean b1 = adminFacade.removeCustomer(3);
            if (b1) {
                System.out.println("Customer removed!");
            } else {
                System.out.println("cant remove customer");
            }

        } catch (NoSuchCustomerException ex) {
            System.out.println("Customer exception: " + ex.getMessage());
        } catch (NoSuchCompanyException ex) {
            System.out.println("Company exception: " + ex.getMessage());
        } catch (NoSuchCouponException ex) {
            System.out.println("Coupon exception: " + ex.getMessage());
        } catch (InvalidLoginException ex) {
            System.out.println("Invalid Login exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



    }
}
