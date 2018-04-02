package com.ksleano.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksleano.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	// need to inject the session factory using dependency injection
	@Autowired
	private SessionFactory sessionFactory;
	
	
	// @Transactional will handle the session.begin and commit stuff
	// This method will get the customers using a query to the DB
	// EDIT 
	// transactional is now removed and used in the service implementation
	@Override
	public List<Customer> getCustomers(){
		// get the current Hibernate session using the SessionFactory
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create the query... and order by last name. Remember to call it in relation to the
		// object name
		String hbq = "from Customer order by lastName";
		Query<Customer> query =currentSession.createQuery(hbq, Customer.class);
		
		// execute query and get result list	
		List<Customer> customers = query.getResultList();
		
		// return the result
		// or return query.getResultList() but it's just better for debug
		return customers;
		
	}


	@Override
	public void saveCustomer(Customer customerFromForm) {

		// get current hibernate session to start saving 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save or update if the id already exists the customer to the database
		// save or update looks at the primary key
		currentSession.saveOrUpdate(customerFromForm);
		
		
	}


	@Override
	public Customer getCustomer(int idFromTheUrl) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// grab the customer based on the primary key id
		Customer c = currentSession.get(Customer.class, idFromTheUrl);
		return c;
	}


	@Override
	public void deleteCustomer(int idFromTheUrl) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		/* delete object with the given primary key
		String query = "delete from Customer where id=:customerId";
		Query q = currentSession.createQuery(query);
		q.setParameter("customerId", idFromTheUrl);
		*/
		Customer c = new Customer();
		c = currentSession.get(Customer.class, idFromTheUrl);
		currentSession.delete(c);
		
	}



}













