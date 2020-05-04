package com.sagala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagala.dao.CustomerDao;
import com.sagala.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		customerDao.delete(customerId);
	}

	@Override
	@Transactional
	public Customer findById(int customerId) {
		return customerDao.findById(customerId);
	}

}
