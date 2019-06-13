package com.example.jdbc.service.impl;

import com.example.jdbc.dao.CustomerDao;
import com.example.jdbc.model.Customer;
import com.example.jdbc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> list = customerDao.findAll();
        return list;

    }

    @Override
    public void inert() {
        customerDao.insert();
    }
}