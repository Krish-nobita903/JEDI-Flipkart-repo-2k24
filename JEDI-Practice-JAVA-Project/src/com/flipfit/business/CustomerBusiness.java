package com.flipfit.business;

public interface CustomerBusiness {
    public void createCustomer();
    public boolean updateCustomer(int customerId);
    public boolean deleteCustomer(int customerId);
    public void listCustomers();
}
