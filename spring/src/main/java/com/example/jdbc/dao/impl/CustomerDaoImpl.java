package com.example.jdbc.dao.impl;

import com.example.jdbc.dao.CustomerDao;
import com.example.jdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;

 
    @Override
    public List<Customer> findAll() {
        List<Customer> list = jdbcTemplate.query("select * from customer",new BeanPropertyRowMapper<Customer>(Customer.class));
        return list;
    }
    @Override
    public void insert(){
        String id=UUID.randomUUID().toString();
        jdbcTemplate.execute("insert into customer values("+"'"+id+"'"+","+"'"+id+"'"+","+"'"+id+"'"+")");
    }
}