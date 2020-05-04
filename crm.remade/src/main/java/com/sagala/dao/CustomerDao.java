package com.sagala.dao;

import java.util.List;

import com.sagala.entity.Customer;

public interface CustomerDao {

	public List<Customer> findAll();

	public Object save(Customer customer);

	public void delete(int customerId);

	public Customer findById(int customerId);
}
