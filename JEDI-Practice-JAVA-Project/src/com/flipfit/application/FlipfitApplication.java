package com.flipfit.application;

import com.flipfit.business.CustomerBusiness;
import com.flipfit.business.CustomerBusinessImpl;

public class FlipfitApplication {
    public static void main(String[] args) {
        CustomerBusiness service = new CustomerBusinessImpl();
        service.createCustomer();
        System.out.println("Customer deleted by id -> "+ service.deleteCustomer(123));
        System.out.println("Customer updated by id -> "+ service.updateCustomer((127)));
        service.listCustomers();
    }
}
