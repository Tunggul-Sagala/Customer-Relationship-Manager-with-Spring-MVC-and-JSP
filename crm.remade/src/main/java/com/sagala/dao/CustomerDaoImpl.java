package com.sagala.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sagala.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> findAll() {
		Session session =sessionFactory.getCurrentSession();
		Query<Customer> query =session.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	public Object save(Customer customer) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		return null;
	}

	@Override
	public void delete(int customerId) {
		Session session =sessionFactory.getCurrentSession();
		Query query =session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

	@Override
	public Customer findById(int customerId) {
		Session session =sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

}
