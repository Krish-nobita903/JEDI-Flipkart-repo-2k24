package com.flipfit.business;
import java.lang.*;

public class CustomerBusinessImpl implements CustomerBusiness {
    @Override
    public void createCustomer() {
        System.out.println("in the create customer method");
    }

    @Override
    public boolean updateCustomer(int customerId) {
        System.out.println("in the update customer method -> "+customerId);
        return true;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        System.out.println("in the delete customer method -> "+customerId);
        return true;
    }

    @Override
    public void listCustomers() {
        System.out.println("in the list customer method");
    }
}
