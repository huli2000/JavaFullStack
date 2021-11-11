package model;

import java.util.HashSet;
import java.util.Set;


public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /*A collection that contains no duplicate elements.*/
    private Set<Coupon> coupons;

    public Customer(long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

        coupons = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, firstName='%s', lastName='%s', email='%s', password='%s', coupons=%s}",
                             id,
                             firstName,
                             lastName,
                             email,
                             password,
                             coupons);
    }
}
