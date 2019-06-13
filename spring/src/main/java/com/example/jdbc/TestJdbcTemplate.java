package com.example.jdbc;

import com.example.jdbc.config.SpringConfig;
import com.example.jdbc.model.Customer;
import com.example.jdbc.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestJdbcTemplate {
    private ApplicationContext applicationContext;
    private CustomerService customerService;

    @Test
    public void testSearch() {
        List<Customer> list = customerService.findAllCustomer();
        for (Customer customer : list) {
            System.out.print("customer = " + customer.getId());
            System.out.print(" " + customer.getName());
            System.out.print(" " + customer.getSex());
            System.out.println();
        }
    }

    @Test
    public void testInsert() {
        customerService.inert();
    }

    @Before
    public void instance() {
        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        customerService = (CustomerService) applicationContext.getBean("customerService");

    }
}