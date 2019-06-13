package com.example.jdbc.service;

import com.example.jdbc.model.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> findAllCustomer();
    public void inert();
}
