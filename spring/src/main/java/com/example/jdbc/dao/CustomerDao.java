package com.example.jdbc.dao;

import com.example.jdbc.model.Customer;
import java.util.List;

public interface CustomerDao {
    public List<Customer> findAll();
    public void insert();
}
