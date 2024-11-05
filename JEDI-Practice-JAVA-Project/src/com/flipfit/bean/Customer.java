package com.flipfit.bean;
import java.lang.*;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;

    public int customerId() {
        return customerId;
    }

    public Customer setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public String customerName() {
        return customerName;
    }

    public Customer setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String customerAddress() {
        return customerAddress;
    }

    public Customer setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }
}
