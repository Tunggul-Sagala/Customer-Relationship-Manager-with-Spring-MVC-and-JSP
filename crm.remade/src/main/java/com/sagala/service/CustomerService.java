package com.sagala.service;

import java.util.List;

import com.sagala.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public void save(Customer customer);

	public void delete(int customerId);

	public Customer findById(int customerId);
}
